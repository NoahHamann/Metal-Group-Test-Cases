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

		new HomePage(this.getDriver())
		        .navigate()
		        .clickToImage();
		String actualText = new ProductDetailPage(this.getDriver())
				.setQuantity(quantity)
				.addToCart()
				.time()
				.getResultText();

		Assert.assertEquals(actualText, expectedText, "not match with expected result");
	}

}
