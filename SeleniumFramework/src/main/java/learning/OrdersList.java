package learning;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersList extends ReusableWait{
	
	WebDriver driver;
	
	public OrdersList(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ordersName;
	
	public Boolean ordersList(String productName) {
		Boolean match = ordersName.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		return match;
	}
	
}
