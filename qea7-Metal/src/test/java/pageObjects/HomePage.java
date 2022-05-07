package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import foundation.PageObjectBase;

public class HomePage extends PageObjectBase {

	public HomePage (WebDriver driver) {
		super(driver);
	}

	public HomePage navigate() {
		this.getDriver().get("http://invenauto.tech/index.php");

		return this;
	}

	public HomePage enterSearchDetails (String searchDetails) {
		WebElement keyword = this.getDriver().findElement(By.id("search_query_top"));
		keyword.sendKeys(searchDetails);

		return this;
	}

	public SearchPage clickSearchButton() {
		this.getDriver().findElement(By.name("submit_search")).click();

		return new SearchPage(this.getDriver());
	}

}
