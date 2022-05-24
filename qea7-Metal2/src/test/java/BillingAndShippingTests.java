import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.TestBase;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailPage;

public class BillingAndShippingTests extends TestBase {
	@Test
	public void canEnterBillingAndShippingInformationBeforePayment() {

		String quantity = "7";
		String size = "M";
		String color = "White";
		String emailText = "fake_email@gmail.com";
		String passwordText = "Abcd1234";
		String primaryAddress = "123 Fake Lane";
		String city = "Fakington";
		String state = "Alaska";
		String zipCode = "13579";
		String phone = "123-456-7890";
		String addressTitle = "Home";
		String expectedPaymentHeaderText = "please choose your payment method\n"
				+ "your shopping cart contains: 7 products";

		HomePage homePage = new HomePage(this.getDriver());
		homePage.navigate()
		.clickBlouseImage();
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		productDetailPage.setQuantity(quantity)
		.selectSize(size)
		.selectColor(color)
		.addToCart()
		.proceedToCheckout();
		CheckoutPage checkoutPage = new CheckoutPage(this.getDriver());
		checkoutPage.proceedToCheckout()
		.enterEmailTextAtCheckout(emailText)
		.enterPasswordTextAtCheckout(passwordText)
		.clickLoginButtonAtCheckout();

		String enterAddressUrl = "http://invenauto.tech/index.php?controller=address&back=order.php%3Fstep%3D1&id_address=136";
		String currentUrl = this.getDriver().getCurrentUrl();

		if (enterAddressUrl == currentUrl) {

			checkoutPage.enterPrimaryAddress(primaryAddress)
			.enterCity(city)
			.selectState(state)
			.enterZipCode(zipCode)
			.enterPhone(phone)
			.enterAddressTitle(addressTitle)
			.confirmAddress();
		} else {
			checkoutPage.processAddress();
		}

		checkoutPage.agreeToTermsAndConditions()
		.processCarrier();

		assertEquals(checkoutPage.getPaymentHeaderText(), expectedPaymentHeaderText,
				"Exepcted payment and actual payment headers should match.");

	}
}
