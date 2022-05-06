import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {

	public ChromeDriver driver;

	@BeforeMethod
	public void launchDriver() {
		URL driverPathForWindows = getClass().getResource("windows/chromedriver.exe");
		URL driverPathPathForMac = getClass().getResource("mac/chromedriver");
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", driverPathPathForMac.getPath());
		}
		if (os.contains("windows")) {
			System.setProperty("webdriver.chrome.driver", driverPathForWindows.getPath());
		}
		this.driver = new ChromeDriver();
		// driver.navigate().to("http://invenauto.tech/index.php");

	}

	@AfterMethod
	public void cleanUp() {

		if (this.driver != null) {
			this.driver.quit();
		}
	}

	public ChromeDriver getDriver() {
		return driver;
	}

}
