import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocatorsMethod {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameeditBox = driver.findElement(By.name("name"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameeditBox)).getText());
		
		WebElement dateOfBirth = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
		
		WebElement checkBox = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBox)).click();
		
		WebElement radioLabel = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioLabel)).getText());
		
		driver.close();
	}

}
