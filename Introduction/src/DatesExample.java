import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DatesExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();

		//WebElement month = driver.findElement(By.xpath("//div[@class='DayPicker']"));
		List<WebElement> selectedMonths = driver.findElements(By.xpath("//div[@class='DayPicker-Month']"));
		for(WebElement month: selectedMonths) {
			String str = month.getText().split("2023")[0].trim();
			System.out.println(str);
			if(str.equalsIgnoreCase("August")) {
				
				List<WebElement> dates = month.findElements(By.cssSelector("[class='dateInnerCell'] p"));
				for(WebElement date : dates) {
					String d = date.getText().split("₹")[0].trim();
					System.out.println(d);
					if (d.equals("13")) {
						date.click();
						break;
					}
				}
			}
		}
	}
}
