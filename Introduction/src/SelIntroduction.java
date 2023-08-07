import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		
		//This will set the path of the browser executable
		//System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		//For Firefox Gecko driver is used
		//System.setProperty("webdriver.gecko.driver", "C:/Selenium/Driver/chromedriver_win32/geckodriver.exe");
		//set path for Microsoft Edge Driver
		System.setProperty("webdriver.edge.driver", "C:/Selenium/Driver/edgedriver_win64/msedgedriver.exe");
		
		//Invoking Chrome Browser
		//WebDriver driver = new ChromeDriver();
		//Invoking Ffirefox Driver
		//WebDriver driver = new FirefoxDriver();
		//Invoking MS Edge Driver
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		}

}
