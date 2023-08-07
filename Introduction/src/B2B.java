import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class B2B {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.rahulshettyacademy.com/");
		driver.findElement(By.linkText("Practice")).click();
		driver.findElement(By.cssSelector("#name")).sendKeys("SP");
		driver.findElement(By.id("email")).sendKeys("sarita.hpatel@gmail.com");
		driver.findElement(By.id("form-submit")).click();
		driver.findElement(By.linkText("Automation Practise - 1")).click();
		
		String[] itemsNeeded = {"Cucumber", "Brocolli", "Beans", "Onion"};
		addItems(driver, itemsNeeded); //Since its a Static method, we need not create an object to call it.
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
	}
	
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0, j=0; i<products.size(); i++)
		{
			String[] name = products.get(i).getText().split("-");
			List<String> items = Arrays.asList(itemsNeeded);
			if(items.contains(name[0].trim()))
			{
				//This was inconsistent as the text on the button was changed to ADDED for 3 seconds before returning back to ADD TO CART which caused different items to get added to cart.
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if(j==itemsNeeded.length)
					break;
			}
		}
		
	}

}
