package learning;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userEmail")).sendKeys("spatel@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Keshav&jivan13");
		driver.findElement(By.name("login")).click();
		List<String> products = Arrays.asList("ZARA COAT 3", "IPHONE 13 PRO");
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		List<WebElement> elements = driver.findElements(By.cssSelector("div[class='card'] div"));
		
		WebElement filteredProduct = elements.stream().filter(s -> s.getText().contains("ZARA COAT 3")).findFirst().orElse(null);
		filteredProduct.findElement(By.cssSelector(".w-10")).click();
		
		//Above 2 lines off code is doing below but using streams 
		/*
		 * for(WebElement element : elements) { //System.out.println(element.getText());
		 * if(element.getText().contains("ZARA COAT 3")) {
		 * element.findElement(By.cssSelector("button[class*='w-10']")).click(); break;
		 * } }
		 */
		
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("toast-container")));
		
		System.out.println(driver.findElement(By.id("toast-container")).getText());
		Assert.assertTrue(driver.findElement(By.id("toast-container")).getText().equalsIgnoreCase("Product Added To Cart"));
		
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".w-10")));
		
		WebElement filteredProduct1 = elements.stream().filter(s -> s.getText().contains("IPHONE 13 PRO")).findFirst().orElse(null);
		filteredProduct1.findElement(By.cssSelector(".w-10")).click();
		
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("toast-container")));
		
		System.out.println(driver.findElement(By.id("toast-container")).getText());
		Assert.assertTrue(driver.findElement(By.id("toast-container")).getText().equalsIgnoreCase("Product Added To Cart"));
		
		//w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']")));
		driver.findElement(By.cssSelector(".ng-star-inserted")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> selectedElementsOnCart = driver.findElements(By.cssSelector(".cartSection h3"));
		List<String> selectedProducts = selectedElementsOnCart.stream().map(s -> s.getText()).collect(Collectors.toList());
		
		Assert.assertEquals(selectedProducts, products);
		
		driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
		
		driver.findElement(By.cssSelector("[placeholder*='Country']")).sendKeys("ind");
		
		List<WebElement> countries = driver.findElements(By.cssSelector(".ta-results.list-group.ng-star-inserted span"));
		
		WebElement country = countries.stream().filter(s -> s.getText().trim().equalsIgnoreCase("india")).findFirst().orElse(null);
		
		country.click();
		
		driver.findElement(By.cssSelector("div.actions a")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText().trim(), "THANKYOU FOR THE ORDER.");
		
		driver.findElement(By.cssSelector("[routerlink*='myorders']")).click();
		
	}

}
