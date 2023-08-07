import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowLaunch {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		System.out.println(courseName);
		
		driver.switchTo().window(parentWindow);
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys(courseName);
		//Screenshot of a particular element of web page
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:/Selenium/Screenshot/name.png"));
		
		//Get Height and Width
		System.out.println("Height: " +name.getRect().getDimension().getHeight());
		System.out.println("Width: " +name.getRect().getDimension().getWidth());
		
		driver.quit();
	}

}
