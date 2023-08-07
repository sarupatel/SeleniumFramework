import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.fetch.Fetch;
import org.openqa.selenium.devtools.v114.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v114.network.model.ErrorReason;

public class FailedRequest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		List<RequestPattern> pattern = Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())) ;
		
		devTools.send(Fetch.enable(Optional.of(pattern), Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request -> {
			devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
	}

}
