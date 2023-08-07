import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableSorting {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> originalList = elements.stream().map(s-> s.getText()).collect(Collectors.toList());
		
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(sortedList));
		
		List<String> price = elements.stream().filter(s->s.getText().equals("Beans")).map(s->getPrice(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
	}
	
	public static String getPrice(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
