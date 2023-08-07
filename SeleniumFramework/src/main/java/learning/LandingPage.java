package learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends ReusableWait{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPass;
	
	@FindBy(name="login")
	WebElement loginBtn;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPass.sendKeys(password);
		loginBtn.click();
		ProductCatalogue productCatalogue =  new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public void goToUrl(String url) {
		driver.get(url);
	}
	
	public String incorrectLoginCredentials() {
		waitForElementToAppaear(errorMessage);
		return errorMessage.getText();
	}

}
