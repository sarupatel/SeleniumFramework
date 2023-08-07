import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CompleteFlightBooking {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Launch Flight Booking site
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Select From and To Destination
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		//Select Current Date and Verify Return Date is disabled
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("Its Disabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		//Select number of Adults
		driver.findElement(By.id("divpaxinfo")).click();
		for(int i = 1; i < 3; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//Set Currency to INR
		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select staticDropdown = new Select(dropdown);
		staticDropdown.selectByValue("INR");
		
		//Select Friends and Family Check box
		driver.findElement(By.cssSelector("#ctl00_mainContent_chk_friendsandfamily")).click();
				
		//Submit the Search
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		//Accept the alert
		driver.switchTo().alert().accept();
		
		//Increase the number of passengers by 1 more
		driver.findElement(By.id("divpaxinfo")).click();
		driver.findElement(By.id("hrefIncAdt")).click();
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//Submit the search
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "1 Adult");
		
		driver.close();
	}

}
