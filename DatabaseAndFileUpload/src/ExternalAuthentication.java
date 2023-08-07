import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExternalAuthentication {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//http://Username:Password@SiteURL
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();
		
		System.out.println(System.getProperty("user.home"));
	}

}
