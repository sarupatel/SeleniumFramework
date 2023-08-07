import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.amazon.com/");
		Actions a = new Actions(driver);
		
		a.moveToElement(driver.findElement(By.cssSelector("span[class='nav-line-2 ']"))).contextClick().build().perform();
		Thread.sleep(10000);
		a.click(driver.findElement(By.id("twotabsearchtextbox"))).keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		Thread.sleep(5000);
		List<WebElement> options = driver.findElements(By.className("s-suggestion-container"));
		
		for(WebElement option : options) {
			if (option.getText().equalsIgnoreCase("hello toothpaste")) {
				option.click();
				break;
			}
		}
		
	}

}
