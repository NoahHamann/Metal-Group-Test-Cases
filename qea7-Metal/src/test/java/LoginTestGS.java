import static org.testng.Assert.assertFalse;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestGS {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() {
		URL driverPathForWindows = getClass().getResource("windows/chromedriver.exe");
		URL driverPathPathForMac = getClass().getResource("mac/chromedriver");
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", driverPathPathForMac.getPath());
		}
		if (os.contains("windows")) {
			System.setProperty("webdriver.chrome.driver", driverPathForWindows.getPath());
		}
		driver = new ChromeDriver();
		// driver.navigate().to("http://invenauto.tech/index.php");

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
