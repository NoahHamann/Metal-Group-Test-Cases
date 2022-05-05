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

public class AddToCart {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() {
		URL driverPathForWindows = getClass().getResource("windows/chromedriver.exe");
		URL driverPathPathForMac = getClass().getResource("mac/chromedriver");
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", driverPathPathForMac.getPath());
		} else {
			System.setProperty("webdriver.chrome.driver", driverPathForWindows.getPath());
		}
		driver = new ChromeDriver();
		driver.navigate().to("http://invenauto.tech/index.php");

		assertFalse(driver == null, "the webdriver should be initialized");

	}

	@Test
	public void canUserAddONeQuantityItemIntoShoppingCart()  {
		String expectedText = "Product successfully added to your shopping cart";
		String elementImage = "[class*= 'first-item-of-mobile-line'] [class='right-block'] [title='Faded Short Sleeves T-shirt']";

		WebElement clickImage = driver.findElement(By.cssSelector(elementImage));
		clickImage.click();
		WebElement quantity = driver.findElement(By.id("quantity_wanted"));
		quantity.clear();
		quantity.sendKeys("5");
		WebElement addToCart = driver.findElement(By.id("add_to_cart"));
		addToCart.click();
		WebElement text = driver.findElement(By.className("title"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(text, expectedText));
		String actualText = text.getText();

		assertEquals(actualText, expectedText);
	}

	@AfterMethod
	public void closeDriver() throws InterruptedException {
		driver.quit();
	}
}
