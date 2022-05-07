package foundation;

import org.openqa.selenium.WebDriver;

public abstract class PageObjectBase {
	private WebDriver driver;

	public PageObjectBase() {
		// TODO Auto-generated constructor stub
	}

	public PageObjectBase(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	protected WebDriver getDriver() {
		return driver;
	}

}
