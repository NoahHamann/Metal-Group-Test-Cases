import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.TestBase;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailPage;

public class ProceedCheckout extends TestBase{
	@Test
	public void CanUserProceedAndCheckout() {

		String quantity = "1";
		String emailText = "invenauto@gmail.com";
		String passwordText = "12345";

		HomePage homePage = new HomePage(this.getDriver());
		homePage.navigate()
		.clickBlouseImage();
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		productDetailPage.setQuantity(quantity)
		.addToCart()
		.proceedToCheckout();
		CheckoutPage checkoutPage = new CheckoutPage(this.getDriver());
		checkoutPage.proceedToCheckout()
		.enterEmailTextAtCheckout(emailText)
		.enterPasswordTextAtCheckout(passwordText)
		.clickLoginButtonAtCheckout()
		.proceedToCheckoutInAddressPage()
		.agreeToTermsAndConditions()
		.processCarrier()
		.clickPayByBank()
		.submit();

		String getConfirmText = checkoutPage.getText();
		String expectedText = "Your order on Clothes Carnival is complete.";

		assertEquals(getConfirmText,expectedText);
	}
}
