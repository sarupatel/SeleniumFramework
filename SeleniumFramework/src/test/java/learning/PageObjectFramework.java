package learning;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import learning.testData.BaseTest;

public class PageObjectFramework extends BaseTest {

	@Test
	public void e2eTest() throws InterruptedException, IOException {
		
	
		List<String> products = Arrays.asList("ZARA COAT 3", "IPHONE 13 PRO");
		
		//Login Page code
		ProductCatalogue productCatalogue = landingPage.loginApplication("hpatel@gmail.com", "Keshav&jivan13");
		
		//Select Products Page
		productCatalogue.selectProducts(products);
		MyCart myCart = productCatalogue.clickOnCart();
		
		//Checkout Items Page
		List<String> selectedProducts = myCart.verifyCartItems();
		Assert.assertEquals(selectedProducts, products);
		SubmitOrder submitOrder = myCart.checkOut();
		
		//Submit Order Page
		SummaryPage summaryPage = submitOrder.placeOrder("ind");
		
		//Successful order submitted summary page
		Assert.assertEquals(summaryPage.getSuccessMessage(), "THANKYOU FOR THE ORDER.");	
				
		driver.findElement(By.cssSelector("[routerlink*='myorders']")).click();
		
	}

	@Test(dependsOnMethods={"e2eTest"}, dataProvider="getData")
	public void ordersValidation(HashMap<String, String> input) throws InterruptedException, IOException {
		
	
		landingPage.loginApplication(input.get("email"), input.get("password"));
		OrdersList orders = landingPage.goToOrdersPage();
		Boolean match = orders.ordersList(input.get("product"));
		Assert.assertTrue(match);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		//Data Set 1
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "spatel@gmail.com");
//		map.put("password", "Keshav&jivan13");
//		map.put("product", "ZARA COAT 3");
//		
//		//Data Set 2
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "hpatel@gmail.com");
//		map1.put("password", "Keshav&jivan13");
//		map1.put("product", "IPHONE 13 PRO");
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"/src/test/java/learning/data/OrdersValidation.json");
		
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
}
