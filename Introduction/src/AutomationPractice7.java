import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPractice7 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		int rowsCount = driver.findElements(By.cssSelector("table[name='courses'] tr")).size();
	 	int columnsCount = driver.findElements(By.cssSelector("table[name='courses'] th")).size();
	 	
	 	System.out.println("Total Rows: " + rowsCount + " Total Columns: " + columnsCount);
	 	
	 	List<WebElement> rows = driver.findElements(By.cssSelector("table[name='courses'] tr"));
	 	
	 	for (int i=0; i< rows.size(); i++) {
	 		if (i==2) {
	 			List<WebElement> data = rows.get(i).findElements(By.cssSelector("td"));
	 			//System.out.print(data);
	 			for(int j=0; j<data.size();j++) {
	 				System.out.print(data.get(j).getText() + "\t");
		 			
	 			}
	 			break;
	 		}
	 	}
	 	driver.close();
	}
}
