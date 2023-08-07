package learning.testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import learning.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/learning/resources/GlobalData.properties");
		prop.load(fis);
		//To read from command prompt i any browser value provided
		String browser = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		//String browser = prop.getProperty("browser");
		System.out.println(browser);
		
		if(browser.contains("chrome") || browser.contains("Chrome")) {
			//Here ChromeOptions is used to run Chrome integrated with Jenkins in headless mode
			ChromeOptions options = new ChromeOptions();
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
			if(browser.contains("headless")) {
			options.addArguments("headless");
			}
			driver= new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1920,1080));//run in full screen
		} else if(browser.equalsIgnoreCase("fireox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		//read data from file as a String
		String jsonContent = FileUtils.readFileToString(new File (filePath), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
		return data;
	}
	
	public String getScreenShot(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"reports"+testcaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"reports"+testcaseName+".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goToUrl("https://rahulshettyacademy.com/client");
		return landingPage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeDriver() {
		driver.close();
	}
}
