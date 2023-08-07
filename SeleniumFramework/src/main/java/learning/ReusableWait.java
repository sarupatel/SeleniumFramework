package learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableWait {

	WebDriver driver;
	
	public ReusableWait(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orders;
	
	public void waitForInvisbilityOfElement(By element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}
	
	public void waitForVisbilityOfElement(By element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public void waitForElementToBeClickable(By element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public void waitForElementToAppaear(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(element));
	}
	
	public OrdersList goToOrdersPage() {
		orders.click();
		return new OrdersList(driver);
	}
}
