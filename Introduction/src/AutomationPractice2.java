import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AutomationPractice2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
	
		driver.findElement(By.xpath("//form-comp/div/form/div/input[contains(@class,'ng-pristine')]")).sendKeys("ABC");
		driver.findElement(By.name("email")).sendKeys("abc.gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
		
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select staticDropdown = new Select(dropdown);
		staticDropdown.selectByIndex(1);
		
		driver.findElement(By.name("inlineRadioOptions")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("01/01/1999");
		driver.findElement(By.cssSelector("[value='Submit']")).click();
		
			
		
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
	
		Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText(), "×\n"
				+ "Success! The Form has been submitted successfully!.");
		
		
	}

}
