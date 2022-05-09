import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {

	private static WebDriver driver;

	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;

	}

	public static void navigate() {
		driver.navigate().to("http://invenauto.tech/index.php?id_product=1&controller=product");
	}

	public ProductDetailPage setQuantity(String quantity) {
		WebElement quantityElement = driver.findElement(By.id("quantity_wanted"));
		quantityElement.clear();
		quantityElement.sendKeys(quantity);
		return this;
	}

	public ProductDetailPage addToCart() {
		WebElement addToCart = driver.findElement(By.id("add_to_cart"));
		addToCart.click();
		return this;
	}

	public String getResultText() {
		WebElement getResultText = driver
				.findElement(By.xpath("//span[normalize-space()='Product successfully added to your shopping cart']"));
		String text = getResultText.getText();
		return text;
	}

	public static By element() {
		By by = By.xpath("//span[normalize-space()='Product successfully added to your shopping cart']");
		return by;
	}

	public ProductDetailPage time() {
		ProductDetailPage pdPage = new ProductDetailPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdPage.element()));
		return this;
	}

}
