package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import foundation.PageObjectBase;

public class SearchResultsPage extends PageObjectBase {
	private WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;

		//super(driver);
	}

	public String getHeaderText() {
		WebElement headerTextElement = this.driver.findElement(By.cssSelector("H1 span.lighter"));
		String headerText = headerTextElement.getText();
		String headerTextCleaned = headerText.replace("\"","").toLowerCase();

		return headerTextCleaned;
	}

}
