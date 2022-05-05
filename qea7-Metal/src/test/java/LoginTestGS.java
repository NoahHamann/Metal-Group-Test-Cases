import static org.testng.Assert.assertFalse;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestGS {
	private WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		URL driverPath = getClass().getResource("Mac/chromedriver");

		System.setProperty("webdriver.chrome.driver", driverPath.getPath());

		driver = new ChromeDriver();

		assertFalse(driver == null, "the webdriver should be initialized");

	}

	@Test
	public void canLogIntoAccount() {

		driver.manage().window().maximize();
		driver.get("http://invenauto.tech/index.php?controller=authentication&back=my-account");

		WebElement username = driver.findElement(By.id("email"));

		WebElement password = driver.findElement(By.id("passwd"));

		WebElement login = driver.findElement(By.id("SubmitLogin"));

		username.sendKeys("fake_email@gmail.com");
		password.sendKeys("Abcd1234");
		login.click();

		String actualUrl = "http://invenauto.tech/index.php?controller=my-account";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Exepcted post-login and actual post-login URL's do not match.");

	}

	@AfterMethod
	public void afterMethod() {
	}

}
