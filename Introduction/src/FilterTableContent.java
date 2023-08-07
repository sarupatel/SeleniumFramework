import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterTableContent {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredVeggies = veggies.stream().filter(s -> s.getText().equals("Rice")).collect(Collectors.toList());
		Assert.assertTrue(veggies.equals(filteredVeggies));
	}

}
