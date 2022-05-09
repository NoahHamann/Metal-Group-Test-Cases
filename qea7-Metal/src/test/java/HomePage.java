import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePage {

	private static WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	public static void navigate() {
		driver.navigate().to("http://invenauto.tech/index.php");
	}

	public List<WebElement> getAllCategories() {
		List<WebElement> categoryNames = this.driver
				.findElements(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li"));
		return categoryNames;
	}

	public void clickToEachCategory() {
		List<WebElement> categories = getAllCategories();
		for (int i = 0; i < categories.size(); i++) {
			categories.get(i).click();
			;
			this.driver.navigate().back();

		}
	}

	public void clickToImage() {
		String imageElement = "[class*= 'first-item-of-mobile-line'] [class='right-block'] [title='Faded Short Sleeves T-shirt']";
		WebElement clickToImage = this.driver.findElement(By.cssSelector(imageElement));
		clickToImage.click();
	}

}