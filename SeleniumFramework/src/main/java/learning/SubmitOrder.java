package learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitOrder extends ReusableWait{

	WebDriver driver;
	
	public SubmitOrder(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder*='Country']")
	WebElement countryTextBox;
	
	@FindBy(css=".ta-results.list-group.ng-star-inserted span")
	List<WebElement> countries;
	
	@FindBy(css="div.actions a")
	WebElement placeOrderBtn;
	
	public void selectCountry(String cntry) {
		countryTextBox.sendKeys(cntry);
		WebElement country = countries.stream().filter(s -> s.getText().trim().equalsIgnoreCase("india")).findFirst().orElse(null);
		country.click();
	}
	
	public SummaryPage placeOrder(String cntry) {
		selectCountry(cntry);
		placeOrderBtn.click();
		SummaryPage summaryPage = new SummaryPage(driver);
		return summaryPage;
	}
}
