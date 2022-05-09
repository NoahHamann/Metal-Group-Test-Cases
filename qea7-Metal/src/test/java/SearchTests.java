import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.TestBase;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;

public class SearchTests extends TestBase {

	@Test
	public void canSearchWithInvalidKeyword() {
		String expectedSearchResults = "0 results have been found.";
	
			new HomePage(this.getDriver())
				.navigate()
				.enterSearchText("short123456")
				.clickSearchButton();
			String results = new SearchResultsPage(this.getDriver())
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

		HomePage homePage = new HomePage(this.getDriver());
		homePage.navigate();
		homePage.enterSearchText(searchText);
		homePage.clickSearchButton();
		SearchResultsPage searchResultsPage = new SearchResultsPage(this.getDriver());
		String headerText = searchResultsPage.getHeaderText();

		assertEquals(headerText, searchText, "header text should match search text.");
	}
}
