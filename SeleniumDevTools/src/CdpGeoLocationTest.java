import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CdpGeoLocationTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map<String, Object> geoLocation = new HashMap<>();
		geoLocation.put("latitude", 40);
		geoLocation.put("longitude", 3);
		geoLocation.put("accuracy", 10);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", geoLocation);
		
		driver.get("https://my-location.org/");
		System.out.println(driver.findElement(By.id("address")).getText());
		
//		driver.get("http://google.com");
//		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
//		Thread.sleep(3000);
//		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
//		System.out.println(driver.findElement(By.cssSelector(".default-ltr-cache-19f4kxn.ejqbulh8")).getText());
//		Thread.sleep(3000);

	}

}
