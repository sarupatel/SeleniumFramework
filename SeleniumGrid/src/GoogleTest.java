import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GoogleTest {

	@Test
	public void homePageCheck() throws MalformedURLException {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WIN11);
		WebDriver driver = new RemoteWebDriver(new URL(" http://192.168.29.227:4444"), capability); //This connects to Selenium Grid
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("rahul shetty");
		driver.close();
		
	}
}
