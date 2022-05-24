package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import foundation.PageObjectBase;

public class SearchResultsPage extends PageObjectBase {
	private WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getHeaderText() {
		WebElement headerTextElement = this.driver.findElement(By.cssSelector("H1 span.lighter"));
		String headerText = headerTextElement.getText();
		String headerTextCleaned = headerText.replace("\"","").toLowerCase();

		return headerTextCleaned;
	}
	public String getSearchResultAmountText() {
		String results = this.driver.findElement(By.cssSelector("span[class='heading-counter']")).getText();
		return results;
	}
	public SearchResultsPage sortResultsByLowestFirst() {
		Select dropDownSort = new Select(this.driver.findElement(By.id("selectProductSort")));
		dropDownSort.selectByValue("price:asc");
		return this;
	}

}
