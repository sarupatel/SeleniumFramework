import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EnableDisableAttributes {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		//Even though the element is disabled it still returns true, so we use getAttributes method and put a check
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("Its Enabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}

}
