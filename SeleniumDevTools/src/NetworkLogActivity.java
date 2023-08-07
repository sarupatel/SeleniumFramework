import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.Network;

import org.openqa.selenium.devtools.v114.network.model.Request;
import org.openqa.selenium.devtools.v114.network.model.Response;

public class NetworkLogActivity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
				
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.addListener(Network.requestWillBeSent(), request -> {
			
			Request req = request.getRequest();
			//System.out.println(req.getUrl());
		});
		
		devTools.addListener(Network.responseReceived(), response -> {
			
			Response res = response.getResponse();
			//System.out.println(res.getStatus());
			String url = res.getUrl();
			if(url.contains("footer")) {
				Integer statusCode = res.getStatus();
				if(statusCode > 200) {
					System.out.println("Load FAILED");
				} else {
					System.out.println("Load PASSED");
				}
			}
		});
		
		driver.get("https://www.makemytrip.com");
		Thread.sleep(10000);
		//driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
		//Thread.sleep(5000);
		//driver.findElement(By.className("imageSlideContainer")).click();
		//Thread.sleep(5000);
		driver.findElement(By.cssSelector("li[class='menu_Hotels'] .chNavText.darkGreyText")).click();
		//driver.findElement(By.linkText("Browse Products")).click();
	}

}
