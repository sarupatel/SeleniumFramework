import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG'] //a")).size());
		//The above can also be achieved by creating a Sub Driver from the mail Driver
		// WebElement footer = driver.findElement(By.id("gf-BIG"));
		//System.out.println(footer.findElements(By.tagName("a")).size());
		WebElement columnDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td/ul"));
		for(int i=1; i < columnDriver.findElements(By.tagName("a")).size();i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
		}
		
		Set<String> childWindows = driver.getWindowHandles();
		for(String childWindow : childWindows) {
			if (driver.switchTo().window(childWindow).getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/AutomationPractice/")) {
				continue;
			}
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
		}
		driver.quit();
	}
}
