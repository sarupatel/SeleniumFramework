import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				
		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select staticDropdown = new Select(dropdown);
		staticDropdown.selectByIndex(3);
		System.out.println(staticDropdown.getFirstSelectedOption().getText());
		staticDropdown.selectByVisibleText("AED");
		System.out.println(staticDropdown.getFirstSelectedOption().getText());
		staticDropdown.selectByValue("INR");
		System.out.println(staticDropdown.getFirstSelectedOption().getText());
		
		driver.close();
		
	}

}
