import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver", "C:/Selenium/Driver/edgedriver_win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		String name = "rahul";
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys("hello13");
		driver.findElement(By.className("signInBtn")).click();
		String err = driver.findElement(By.cssSelector("p.error")).getText(); //This failed as the page took time to load the error message
																//To overcome that implicit wait was added after object created.

		System.out.println(err);
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeHolder='Name']")).sendKeys("John");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("134567890");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String password= driver.findElement(By.cssSelector("form p")).getText();
		String[] passArr = password.split("'");
		password = passArr[1].split("'")[0]; //This will further split and extract text from passArr at index 1 and return the result at index 0.
		driver.findElement(By.xpath("//div/button[contains(@class,'login')]")).click();
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type*='word']")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='checkbox-container']/span[1]/input[@value='rmbrUsername']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'signInBtn')]")).click();
		Thread.sleep(1000);
		String str = driver.findElement(By.tagName("p")).getText();
		System.out.println(str);
		Assert.assertEquals(str, "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+"," );
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();
	}

}
