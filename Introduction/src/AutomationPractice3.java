import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutomationPractice3 {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		
		signIn(driver);
		addItemsToCart(driver);
		
		//CheckOut
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("a[class='navbar-brand']:nth-child(1)")).getText(), "ProtoCommerce");
		driver.close();
		
	}

	public static void addItemsToCart(WebDriver driver)
	{
		List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'h-100')]"));
		for(int i=0;i<products.size();i++)
		{
			driver.findElements(By.cssSelector("button[class*='btn-info']")).get(i).click();
		}
		
	}
	
	public static void signIn(WebDriver driver) 
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement s = driver.findElement(By.cssSelector("select.form-control"));
		Select dropdown = new Select(s);
		dropdown.selectByVisibleText("Consultant");
		driver.findElement(By.name("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		//Explicit wait for Page2 to load
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.list-group")));
		
	}
}
