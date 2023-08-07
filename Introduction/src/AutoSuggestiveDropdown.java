import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement option : options) 
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
		System.out.println(driver.findElement(By.cssSelector("[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("[id*='SeniorCitizenDiscount']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("[id*='SeniorCitizenDiscount']")).isSelected(), true);
		System.out.println(driver.findElement(By.cssSelector("[id*='SeniorCitizenDiscount']")).isSelected());
		
		System.out.println(driver.findElements(By.cssSelector("[type='checkbox']")).size());
		
		//driver.close();
	}

}
