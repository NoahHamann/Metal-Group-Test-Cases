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

		// this.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// this.getDriver().manage().window().maximize();
		// this.getDriver().get("http://invenauto.tech/index.php");

		// WebElement blouse = this.getDriver().findElement(By.linkText("Blouse"));
		// blouse.click();
		HomePage homePage = new HomePage(this.getDriver());
		homePage.navigate();
		homePage.clickBlouseImage();
		ProductDetailPage productDetailPage = new ProductDetailPage(this.getDriver());
		productDetailPage.setQuantity(quantity);
		productDetailPage.selectSize(size);
		productDetailPage.selectColor(color);
		productDetailPage.addBlouseToCart();
		productDetailPage.proceedToCheckout();
		CheckoutPage checkoutPage = new CheckoutPage(this.getDriver());
		checkoutPage.confirmShoppingCartSummary();
		checkoutPage.enterEmailTextAtCheckout(emailText);
		checkoutPage.enterPasswordTextAtCheckout(passwordText);
		checkoutPage.clickLoginButtonAtCheckout();

		String enterAddressUrl = "http://invenauto.tech/index.php?controller=address&back=order.php%3Fstep%3D1&id_address=136";
		String currentUrl = this.getDriver().getCurrentUrl();

		if (enterAddressUrl == currentUrl) {

			checkoutPage.enterPrimaryAddress(primaryAddress);
			checkoutPage.enterCity(city);
			checkoutPage.selectState(state);
			checkoutPage.enterZipCode(zipCode);
			checkoutPage.enterPhone(phone);
			checkoutPage.enterAddressTitle(addressTitle);
			checkoutPage.confirmAddress();
		} else {
			checkoutPage.processAddress();
		}

		checkoutPage.agreeToTermsAndConditions();
		checkoutPage.processCarrier();

		assertEquals(checkoutPage.getPaymentHeaderText(), expectedPaymentHeaderText,
				"Exepcted payment and actual payment headers should match.");

	}
}
