package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import foundation.PageObjectBase;

public class ProductDetailPage extends PageObjectBase {

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

	public ProductDetailPage proceedToCheckout() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement checkout = wait
				.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Proceed to checkout")));
		checkout.click();
		return this;
	}

	public ProductDetailPage selectSize(String size) {
		Select productSize = new Select(driver.findElement(By.id("group_1")));
		productSize.selectByVisibleText(size);
		return this;
	}

	public ProductDetailPage selectColor(String color) {
		WebElement productColor = driver.findElement(By.name(color));
		productColor.click();
		return this;
	}

	public ProductDetailPage addBlouseToCart() {
		WebElement addToCart = driver.findElement(By.name("Submit"));
		addToCart.click();
		return this;
	}

}
