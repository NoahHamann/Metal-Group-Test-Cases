import static org.testng.Assert.assertFalse;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SanityTests {

	@BeforeMethod
	public void beforeMethod() {

		URL driverPath = getClass().getResource("Mac/chromedriver");

		System.setProperty("webdriver.chrome.driver", driverPath.getPath());



		WebDriver driver = new ChromeDriver();

		assertFalse(driver == null, "the webdriver should be initialized");

	}

	@Test
	public void canLaunchWebdriver() {
	}

}
