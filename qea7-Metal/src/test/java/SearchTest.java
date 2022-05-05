import static org.testng.Assert.assertEquals;


import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchTest {
	
  @Test
  public void canSearchWithInvalidKeyword() {
	  	URL driverPath = getClass().getResource("Mac/chromedriver");
		System.setProperty("webdriver.chrome.driver", driverPath.getPath());
		WebDriver driver = new ChromeDriver();
		String expectedSearchResults = "0 results have been found.";
		
		driver.get("http://invenauto.tech/index.php");
		WebElement searchBox = driver.findElement(By.id("search_query_top"));
		searchBox.sendKeys("short123456");
		driver.findElement(By.cssSelector("button[name='submit_search']")).click();
		String results = driver.findElement(By.cssSelector("span[class='heading-counter']")).getText();	
		
		assertEquals(expectedSearchResults, results, "Zero results should display");
		driver.quit();
  }

}
