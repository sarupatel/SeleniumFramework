import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.fetch.Fetch;
import org.openqa.selenium.devtools.v114.network.model.Request;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class MockedURL {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request -> {
			Request req = request.getRequest();
			if(req.getUrl().contains("shetty")) {
				String mockedUrl = req.getUrl().replace("=shetty", "=BadGuy");
				System.out.println(mockedUrl);
				
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl), Optional.of(req.getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
			} else {
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(req.getUrl()), Optional.of(req.getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
			}
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		Thread.sleep(3000);
		String message = driver.findElement(with(By.tagName("p")).above(By.cssSelector(".table.table-dark"))).getText();
		//String message = driver.findElement(By.cssSelector("p")).getText();
		if(message.equalsIgnoreCase("Oops only 1 Book available")) {
			System.out.println("Message displayed");
		}
		
		
	}

}
