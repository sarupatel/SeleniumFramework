import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomationPractice8 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("autocomplete"))).click().sendKeys("uni").build().perform();
		Thread.sleep(2000);
		a.moveToElement(driver.findElement(By.xpath("//li[@class='ui-menu-item'][5]/div"))).click().build().perform();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("input#autocomplete")).getAttribute("value"));
		driver.close();
	}

}
