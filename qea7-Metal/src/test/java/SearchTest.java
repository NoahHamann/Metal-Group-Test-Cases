

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {
	
	
  @Test
  public void canSearchWithInvalidKeyword() {
		String expectedSearchResults = "0 results have been found.";
		
		this.getDriver().get("http://invenauto.tech/index.php");
		WebElement searchBox = this.getDriver().findElement(By.id("search_query_top"));
		searchBox.sendKeys("short123456");
		this.getDriver().findElement(By.cssSelector("button[name='submit_search']")).click();
		String results = this.getDriver().findElement(By.cssSelector("span[class='heading-counter']")).getText();	
		
		assertEquals(expectedSearchResults, results, "Zero results should display");	
  }
  @Test
  public void canSearchWithValidKeyword() {
	  String expectedResultsText = "4 results have been found."; 
	  
	  this.getDriver().get("http://invenauto.tech/index.php");
	  WebElement searchBox = this.getDriver().findElement(By.id("search_query_top"));
	  searchBox.sendKeys("short");
	  this.getDriver().findElement(By.cssSelector("button[name='submit_search']")).click();
	  Select dropDownSort = new Select(this.getDriver().findElement(By.id("selectProductSort")));
	  dropDownSort.selectByValue("price:asc");
	  String results = this.getDriver().findElement(By.cssSelector("span[class='heading-counter']")).getText();	
	  
	  
	  assertEquals(expectedResultsText, results);
	  
  }
}
