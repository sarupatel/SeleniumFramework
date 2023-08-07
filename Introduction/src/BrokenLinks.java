import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		SoftAssert a = new SoftAssert();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.cssSelector("div[id='gf-BIG'] 	a"));
		int respCode = 0;
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			//System.out.println(url);
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			respCode = conn.getResponseCode(); 
			a.assertTrue(respCode<400, "Response code is "+ respCode + " for Link " + link.getText());
		}
		a.assertAll();
	}

}
