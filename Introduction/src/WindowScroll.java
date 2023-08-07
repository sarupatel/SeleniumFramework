import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowScroll {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		//document is HTML DOM 
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> columnValues = driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));
		//div[@class='tableFixHead']/table/tbody/tr/td[4] -- Above xpath can be replaced with parent child traverse 
		Integer sum=0;
		for(WebElement columnValue : columnValues ) {
			sum = sum + Integer.valueOf(columnValue.getText());
		}
		String str = driver.findElement(By.cssSelector(".totalAmount")).getText();
		
		if(sum.equals(Integer.valueOf(str.split(":")[1].trim()))) {
			System.out.println("Values match");
		}
		else
			System.out.println("There is a mismatch");
	}

}
