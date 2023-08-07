import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPractice4 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.xpath("//div[@class='example']/a")).click();
		Set<String> windows = driver.getWindowHandles();
		switchContext(windows, driver, "https://the-internet.herokuapp.com/windows/new");
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		switchContext(windows, driver, "https://the-internet.herokuapp.com/windows");
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		
		driver.close();
	}
	
	public static void switchContext(Set<String> windows, WebDriver driver, String url) {
		for(String str : windows) {
			driver.switchTo().window(str);
			if(driver.getCurrentUrl().equals(url)) {
				System.out.println(driver.getCurrentUrl());
				break;
			}
		}
	}

}
