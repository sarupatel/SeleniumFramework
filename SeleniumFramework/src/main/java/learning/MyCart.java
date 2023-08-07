package learning;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyCart extends ReusableWait{

	WebDriver driver;
	
	public MyCart(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> selectedElementsOnCart;
	
	@FindBy(xpath="//li[@class='totalRow']/button")
	WebElement chkBtn;
	
	public List<String> verifyCartItems() {
		return selectedElementsOnCart.stream().map(s -> s.getText()).collect(Collectors.toList());
	}
	
	public SubmitOrder checkOut() {
		chkBtn.click();
		SubmitOrder submitOrder =  new SubmitOrder(driver);
		return submitOrder;
	}
	
}
