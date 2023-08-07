import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AutomationPractice6 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption3")).click();
		String label = driver.findElement(By.cssSelector("[for='honda']")).getText();
		
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(label);
		driver.findElement(By.name("enter-name")).sendKeys(label);
		driver.findElement(By.id("alertbtn")).click();
		String message = driver.switchTo().alert().getText();
		String name = message.split("Hello")[1].split(",")[0].trim();
		System.out.println("Label: "+label+" Name in message: "+ name);
	
		Assert.assertEquals(name, label);
		driver.switchTo().alert().accept();
		driver.close();
	}

}
