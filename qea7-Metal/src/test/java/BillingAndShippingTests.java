import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillingAndShippingTests extends TestBase {
	@Test
	public void canEnterBillingAndShippingInformationBeforePayment() {

		this.getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		this.getDriver().manage().window().maximize();
		this.getDriver().get("http://invenauto.tech/index.php");

		WebElement blouse = this.getDriver().findElement(By.linkText("Blouse"));
		blouse.click();

		WebElement quantity = this.getDriver().findElement(By.id("quantity_wanted"));
		Select size = new Select(this.getDriver().findElement(By.id("group_1")));
		WebElement color = this.getDriver().findElement(By.name("White"));
		WebElement addToCart = this.getDriver().findElement(By.id("add_to_cart"));
		quantity.clear();
		quantity.sendKeys("7");
		size.selectByVisibleText("M");
		color.click();
		addToCart.click();

		WebElement checkout = this.getDriver().findElement(By.partialLinkText("Proceed to checkout"));
		checkout.click();

		WebElement proceedToCheckout = this.getDriver().findElement(By.partialLinkText("Proceed to checkout"));
		proceedToCheckout.click();

		WebElement username = this.getDriver().findElement(By.id("email"));
		WebElement password = this.getDriver().findElement(By.id("passwd"));
		WebElement login = this.getDriver().findElement(By.id("SubmitLogin"));
		username.sendKeys("fake_email@gmail.com");
		password.sendKeys("Abcd1234");
		login.click();

		String enterAddressUrl = "http://invenauto.tech/index.php?controller=address&back=order.php%3Fstep%3D1&id_address=136";
		String currentUrl = this.getDriver().getCurrentUrl();

		if (enterAddressUrl == currentUrl) {
			WebElement primaryAddress = this.getDriver().findElement(By.id("address1"));
			WebElement city = this.getDriver().findElement(By.id("city"));
			Select state = new Select(this.getDriver().findElement(By.id("id_state")));
			WebElement zipCode = this.getDriver().findElement(By.id("postcode"));
			WebElement phone = this.getDriver().findElement(By.id("phone_mobile"));
			WebElement addressTitle = this.getDriver().findElement(By.id("alias"));
			WebElement saveAddress = this.getDriver().findElement(By.id("submitAddress"));
			primaryAddress.clear();
			primaryAddress.sendKeys("123 Fake Lane");
			city.clear();
			city.sendKeys("Fakington");
			state.selectByVisibleText("Alaska");
			zipCode.clear();
			zipCode.sendKeys("13579");
			phone.clear();
			phone.sendKeys("123-456-7890");
			addressTitle.clear();
			addressTitle.sendKeys("Home");
			saveAddress.click();
		} else {

			WebElement processAddress = this.getDriver().findElement(By.name("processAddress"));
			processAddress.click();
		}

		WebElement agreeToTermsAndConditions = this.getDriver().findElement(By.id("cgv"));
		WebElement processCarrier = this.getDriver().findElement(By.name("processCarrier"));
		agreeToTermsAndConditions.click();
		processCarrier.click();

		String actualUrl = this.getDriver().getCurrentUrl();
		String expectedUrl = "http://invenauto.tech/index.php?controller=order";
		Assert.assertEquals(actualUrl, expectedUrl, "Exepcted payment and actual payment URL's do not match.");

	}
}
