package learning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductCatalogue extends ReusableWait {
	
	WebDriver driver;
	List<WebElement> filteredProduct = new ArrayList<WebElement>();
	By successMessage = By.cssSelector("#toast-container");
	By addToCartBtn = By.cssSelector(".w-10");
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='card'] div")
	List<WebElement> elements;
	
	@FindBy(css=".ng-star-inserted")
	WebElement page;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartBtn;
	
	public List<WebElement> filterProducts(List<String> products) {
		waitForInvisbilityOfElement(successMessage);
		for(String product : products) {
			filteredProduct.add(elements.stream().filter(s -> s.getText().contains(product)).findFirst().orElse(null));
		}
		return filteredProduct;
	}
	
	public void selectProducts(List<String> actualProducts) {
		for(WebElement prod : filterProducts(actualProducts)) {
			waitForElementToBeClickable(addToCartBtn);
			prod.findElement(By.cssSelector(".w-10")).click();
			waitForVisbilityOfElement(successMessage);
			System.out.println(driver.findElement(By.id("toast-container")).getText());
			Assert.assertTrue(driver.findElement(By.id("toast-container")).getText().equalsIgnoreCase("Product Added To Cart"));
		}		
	}
	
	public MyCart clickOnCart() {
		waitForInvisbilityOfElement(successMessage);
		page.click();
		cartBtn.click();
		MyCart myCart = new MyCart(driver);
		return myCart;
	}

}
