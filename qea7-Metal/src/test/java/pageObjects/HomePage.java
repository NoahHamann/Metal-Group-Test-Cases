package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import foundation.PageObjectBase;

public class HomePage extends PageObjectBase {

	private static final String URL = "http://invenauto.tech/index.php";
	private   WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	public  HomePage navigate() {
		driver.navigate().to(URL);
		return this;
	}

	public List<WebElement> getAllCategories() {
		List<WebElement> categoryNames = this.driver
				.findElements(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li"));



		return categoryNames;
	}

	public HomePage clickToEachCategory() {
		List<WebElement> categories = this.driver
				.findElements(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li"));

		for (int i = 0; i < categories.size(); i++) {
			categories.get(i).click();

			this.driver.navigate().back();

		}
		return this;
	}

	public HomePage clickToImage() {
		String imageElement = "[class*= 'first-item-of-mobile-line'] [class='right-block'] [title='Faded Short Sleeves T-shirt']";
		WebElement clickToImage = this.driver.findElement(By.cssSelector(imageElement));
		clickToImage.click();
		return this;
	}


	public HomePage enterSearchText (String searchText) {
		WebElement keyword = this.driver.findElement(By.id("search_query_top"));
		keyword.sendKeys(searchText);

		return this;
	}

	public SearchResultsPage clickSearchButton() {
		WebElement buttonElement = this.driver.findElement(By.name("submit_search"));
		buttonElement.click();

		return new SearchResultsPage(this.getDriver());
	}

}