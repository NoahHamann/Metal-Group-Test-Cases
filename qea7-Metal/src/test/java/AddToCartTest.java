import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {
	WebDriver driver;

	@Test
	public void canAddMultipleQuantityItemIntoShoppingCart() throws InterruptedException {
		String expectedText = "Product successfully added to your shopping cart";
		String quantity = "5";
		HomePage homePage = new HomePage(this.getDriver());
		ProductDetailPage pdPage = new ProductDetailPage(this.getDriver());
		Set setTime = new Set(this.getDriver());

		homePage.navigate();
		homePage.clickToImage();
		pdPage.setQuantity(quantity);
		pdPage.addToCart();
		setTime.time();
		String actualText = pdPage.getResultText();

		Assert.assertEquals(actualText, expectedText, "not match with expected result");
	}

}
