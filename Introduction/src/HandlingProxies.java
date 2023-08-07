import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HandlingProxies {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		//Similarly we can set or firefox, safari and Edge 
		FirefoxOptions options1 = new FirefoxOptions();
		options1.setAcceptInsecureCerts(true);
		EdgeOptions options2 = new EdgeOptions();
		options2.setAcceptInsecureCerts(true);
				
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	}

}
