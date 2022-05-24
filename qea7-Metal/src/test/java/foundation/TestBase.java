package foundation;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {

	private ChromeDriver driver;

	@BeforeMethod
	public void launchDriver() {
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("mac")) {
			URL driverPathPathForMac = getClass().getResource("mac/chromedriver");

			System.setProperty("webdriver.chrome.driver", driverPathPathForMac.getPath());
		}
		if (os.contains("windows")) {
			URL driverPathForWindows = getClass().getResource("windows/chromedriver.exe");

			System.setProperty("webdriver.chrome.driver", driverPathForWindows.getPath());
		}
		this.driver = new ChromeDriver();

		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
	}

	@AfterMethod
	public void cleanUp() {
		if (this.driver != null) {
			this.driver.quit();
		}
	}

	protected ChromeDriver getDriver() {
		return driver;
	}

}
