import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindowDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.partialLinkText("Free Access")).click();
		
		Set<String> windows = driver.getWindowHandles();
		//If you know the number of window open by Automation Script and the Child window you have to traverse to, Iterator can be used like below
		//Iterator<String> it = windows.iterator();
		//String parentId = it.next();
		//String childID = it.next();
		//driver.switchTo().window(childID); -- This will take you to the required child window
		
		//If you are not aware how many child windows will be open by Selenium use below Method 
		switchContext(windows, driver, "https://rahulshettyacademy.com/documents-request");
		String userName = driver.findElement(By.xpath("//div[@class='col-md-8']/p[contains(@class,'red')]/strong/a")).getText();
		
		System.out.println(userName);
		switchContext(windows, driver, "https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys(userName);
		
	}
	
	public static void switchContext(Set<String> windows, WebDriver driver, String url) {
		for(String str : windows) {
			driver.switchTo().window(str);
			if(driver.getCurrentUrl().equalsIgnoreCase(url)) {
				break;
			}
		}
	}

}
