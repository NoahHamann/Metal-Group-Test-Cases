import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.TestBase;
import pageObjects.HomePage;


public class SearchTests extends TestBase {

	@Test
	public void canSearchWithInvalidKeyword() {
		String expectedSearchResults = "0 results have been found.";
	
		String results = new HomePage(this.getDriver())
				.navigate()
				.enterSearchText("short123456")
				.clickSearchButton()
				.getSearchResultAmountText();

		assertEquals(expectedSearchResults, results, "Zero results should display");
	}

	@Test
	public void canSearchWithValidKeyword() {
		String expectedResultsText = "4 results have been found.";
		String results = new HomePage(this.getDriver())
			.navigate()
			.enterSearchText("short")
			.clickSearchButton()
			.sortResultsByLowestFirst()
			.getSearchResultAmountText();
		
		assertEquals(expectedResultsText, results);
	}

	@Test
	public void canSearchUsingSearchText() {
		String searchText = "t-shirts";

		String headerText = new HomePage(this.getDriver())
			.navigate()
			.enterSearchText(searchText)
			.clickSearchButton()
			.getHeaderText();

		assertEquals(headerText, searchText, "header text should match search text.");
	}
}
