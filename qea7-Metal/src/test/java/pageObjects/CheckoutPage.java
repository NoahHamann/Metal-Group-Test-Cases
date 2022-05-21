package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import foundation.PageObjectBase;

public class CheckoutPage extends PageObjectBase {
	private WebDriver driver;
	WebDriverWait wait;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public CheckoutPage proceedToCheckout() {
		WebElement checkout = this.driver.findElement(By.partialLinkText("Proceed to checkout"));
		checkout.click();

		return this;
	}

	public CheckoutPage enterEmailTextAtCheckout(String emailText) {
		WebElement email = this.driver.findElement(By.id("email"));
		email.sendKeys(emailText);

		return this;
	}

	public CheckoutPage enterPasswordTextAtCheckout(String passwordText) {
		WebElement password = this.driver.findElement(By.id("passwd"));
		password.sendKeys(passwordText);

		return this;
	}

	public CheckoutPage clickLoginButtonAtCheckout() {
		WebElement loginButton = this.driver.findElement(By.id("SubmitLogin"));
		loginButton.click();

		return this;
	}

	public CheckoutPage enterPrimaryAddress(String primaryAddress) {
		WebElement primaryAddressText = this.getDriver().findElement(By.id("address1"));
		primaryAddressText.clear();
		primaryAddressText.sendKeys(primaryAddress);

		return this;
	}

	public CheckoutPage enterCity(String city) {
		WebElement cityText = this.getDriver().findElement(By.id("city"));
		cityText.clear();
		cityText.sendKeys(city);

		return this;
	}

	public CheckoutPage selectState(String state) {
		Select stateSelection = new Select(this.getDriver().findElement(By.id("id_state")));
		stateSelection.selectByVisibleText(state);

		return this;

	}

	public CheckoutPage enterZipCode(String zipCode) {
		WebElement zipCodeText = this.getDriver().findElement(By.id("postcode"));
		zipCodeText.clear();
		zipCodeText.sendKeys(zipCode);

		return this;
	}

	public CheckoutPage enterPhone(String phone) {
		WebElement phoneNumber = this.getDriver().findElement(By.id("phone_mobile"));
		phoneNumber.clear();
		phoneNumber.sendKeys(phone);

		return this;
	}

	public CheckoutPage enterAddressTitle(String addressTitle) {
		WebElement addressTitleText = this.getDriver().findElement(By.id("alias"));
		addressTitleText.clear();
		addressTitleText.sendKeys(addressTitle);

		return this;
	}

	public CheckoutPage confirmAddress() {
		WebElement saveAddress = this.getDriver().findElement(By.id("submitAddress"));
		saveAddress.click();

		return this;
	}

	public CheckoutPage processAddress() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement processAddress = wait.until(ExpectedConditions.elementToBeClickable(By.name("processAddress")));
		processAddress.click();

		return this;
	}

	public CheckoutPage agreeToTermsAndConditions() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement agreeToTermsAndConditions = wait
				.until(ExpectedConditions.elementToBeClickable(By.id("uniform-cgv")));
		agreeToTermsAndConditions.click();

		return this;
	}

	public CheckoutPage processCarrier() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement processCarrier = wait.until(ExpectedConditions.elementToBeClickable(By.name("processCarrier")));
		processCarrier.click();

		return this;
	}

	public String getPaymentHeaderText() {
		WebElement paymentHeaderTextElement = this.driver.findElement(By.cssSelector("H1.page-heading"));
		String paymentHeaderText = paymentHeaderTextElement.getText();
		String paymentHeaderTextCleaned = paymentHeaderText.replace("\"", "").toLowerCase();

		return paymentHeaderTextCleaned;
	}

	public CheckoutPage clickPayByBank() {
		//[class='bankwire']
		WebElement payBank = this.driver.findElement(By.cssSelector("[class='bankwire']"));
		payBank.click();

		return this;
	}

	public CheckoutPage submit() {
		// [id='cart_navigation'] [type='submit']
		WebElement submit = this.driver.findElement(By.cssSelector("[id='cart_navigation'] [type='submit']"));
		submit.click();

		return this;
	}

	public CheckoutPage proceedToCheckoutInAddressPage() {
		 
		WebDriverWait wait = new WebDriverWait(this.driver, 30);
		WebElement clickToCheckoutButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='processAddress']")));
		clickToCheckoutButton.click();
		return this;
	}

	public String getText() {
		WebElement text = this.driver.findElement(By.cssSelector("[class='alert alert-success']"));
		return text.getText();
	}

}
