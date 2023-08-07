package learning.stepDefinition;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import learning.LandingPage;
import learning.MyCart;
import learning.ProductCatalogue;
import learning.SubmitOrder;
import learning.SummaryPage;
import learning.testData.BaseTest;

public class StepDefinitionImpl extends BaseTest{
	
	public LandingPage landingPage;
	@Given("I land on Ecommerce page")
	public void I_land_on_Ecommerce_page() throws IOException {
		landingPage = launchApplication();
	}
	
	public ProductCatalogue productCatalogue;
	@Given("^Logged in with username (.+) and password (.+)$") //(.+) is a regular expression for the data that will come as user name and password
	public void Logged_in_with_username_and_Password(String username, String password) {
		productCatalogue = landingPage.loginApplication(username, password);
	}
	
	public MyCart myCart;
	@When("^I add product (.+) to the cart$")
	public void I_add_product_to_cart(String productName) {
		List<String> items = Arrays.asList(productName.split("\\s*,\\s*"));
		productCatalogue.selectProducts(items);
		myCart = productCatalogue.clickOnCart();
	}
	
	public SummaryPage summaryPage;
	@And("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_order(String productName) {
		List<String> selectedProducts = myCart.verifyCartItems();
		List<String> items = Arrays.asList(productName.split("\\s*,\\s*"));
		Assert.assertEquals(selectedProducts, items);
		SubmitOrder submitOrder = myCart.checkOut();
		summaryPage = submitOrder.placeOrder("ind");
	}
	
	@Then("{string} message is displayed on Confirmation Page") //here string means the type of static data coming from test
	public void verify_message_is_displayed(String message) {
		Assert.assertEquals(summaryPage.getSuccessMessage(), message);
		driver.close();
	}

	@Then("{string} is displayed")
	public void incorrect_login_message_displayed(String message) {
		Assert.assertEquals(message, landingPage.incorrectLoginCredentials());
		driver.close();
	}
}
