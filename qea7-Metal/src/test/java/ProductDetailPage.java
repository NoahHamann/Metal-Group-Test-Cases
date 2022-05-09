import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage {

	private static WebDriver driver;

	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;

	}

	public static void navigate() {
		driver.navigate().to("http://invenauto.tech/index.php?id_product=1&controller=product");
	}

	public static void setQuantity(String quantity) {
		WebElement quantityElement = driver.findElement(By.id("quantity_wanted"));
		quantityElement.clear();
		quantityElement.sendKeys(quantity);
	}

	public static void addToCart() {
		WebElement addToCart = driver.findElement(By.id("add_to_cart"));
		addToCart.click();
	}

	public static String getResultText() {
		WebElement getResultText = driver
				.findElement(By.xpath("//span[normalize-space()='Product successfully added to your shopping cart']"));

		return getResultText.getText();
	}

	public static By element() {
		By by = By.xpath("//span[normalize-space()='Product successfully added to your shopping cart']");
		return by;
	}

}
