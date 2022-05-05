import static org.testng.Assert.assertEquals;


import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {
	WebDriver driver;
	
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
	}
	
  @Test
  public void canSearchWithInvalidKeyword() {
		String expectedSearchResults = "0 results have been found.";
		
		driver.get("http://invenauto.tech/index.php");
		WebElement searchBox = driver.findElement(By.id("search_query_top"));
		searchBox.sendKeys("short123456");
		driver.findElement(By.cssSelector("button[name='submit_search']")).click();
		String results = driver.findElement(By.cssSelector("span[class='heading-counter']")).getText();	
		
		assertEquals(expectedSearchResults, results, "Zero results should display");
		driver.quit();
  }
  @Test
  public void canSearchWithValidKeyword() {
	  String expectedResultsText = "4 results have been found."; 
	  
	  driver.get("http://invenauto.tech/index.php");
	  WebElement searchBox = driver.findElement(By.id("search_query_top"));
	  searchBox.sendKeys("short");
	  driver.findElement(By.cssSelector("button[name='submit_search']")).click();
	  Select dropDownSort = new Select(driver.findElement(By.id("selectProductSort")));
	  dropDownSort.selectByValue("price:asc");
	  String results = driver.findElement(By.cssSelector("span[class='heading-counter']")).getText();	
	  
	  assertEquals(expectedResultsText, results);
	  driver.quit();
  }
  @AfterMethod
	public void closeDriver() throws InterruptedException {
		driver.quit();
	}
}
