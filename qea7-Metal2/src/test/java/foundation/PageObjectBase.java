package foundation;

import org.openqa.selenium.WebDriver;

public abstract class PageObjectBase {
	private WebDriver driver;

	public PageObjectBase() {
	}

	public PageObjectBase(WebDriver driver) {
	}

	protected WebDriver getDriver() {
		return driver;
	}

}
