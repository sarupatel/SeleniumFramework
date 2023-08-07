import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Pagination {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<String> price;
		do {
			List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
			price = elements.stream().filter(s->s.getText().equals("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
			if(price.size()<1) driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			else price.forEach(s->System.out.println(s));
		}while(price.size()<1);
	}

	public static String getPrice(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}
}
