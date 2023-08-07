import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.edge.driver", "C:/Selenium/Driver/edgedriver_win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
		driver.navigate().to("https://rahulshettyacademy.com");
		driver.navigate().back(); //Navigate back to the last URL
		driver.navigate().forward();
		driver.close();
	}

}
