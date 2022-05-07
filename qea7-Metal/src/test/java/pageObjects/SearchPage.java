package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import foundation.PageObjectBase;

public class SearchPage extends PageObjectBase {

	public SearchPage(WebDriver driver) {

		super(driver);
	}

	public String getProductTitle() {
		String keyString = this.getDriver().findElement(By.xpath("//*[@id=\"product_list\"]/li/div"));
		return keyString;
	}

}
