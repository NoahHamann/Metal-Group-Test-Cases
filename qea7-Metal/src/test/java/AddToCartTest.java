import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void canAddMultipleQuantityItemIntoShoppingCart() {
		String expectedText = "Product successfully added to your shopping cart";
		String imageElement = "[class*= 'first-item-of-mobile-line'] [class='right-block'] [title='Faded Short Sleeves T-shirt']";

		this.getDriver().navigate().to("http://invenauto.tech/index.php");
		WebElement clickToImage = this.getDriver().findElement(By.cssSelector(imageElement));
		clickToImage.click();
		WebElement setQuantity = this.getDriver().findElement(By.id("quantity_wanted"));
		setQuantity.clear();
		setQuantity.sendKeys("5");
		WebElement addToCart = this.getDriver().findElement(By.id("add_to_cart"));
		addToCart.click();
		WebElement getResultText = this.getDriver()
				.findElement(By.xpath("//span[normalize-space()='Product successfully added to your shopping cart']"));
		wait = new WebDriverWait(this.getDriver(), 30);
		wait.until(ExpectedConditions.textToBePresentInElement(getResultText, expectedText));
		String actualText = getResultText.getText();

		Assert.assertEquals(actualText, expectedText, "not match with expected result");
	}

}
