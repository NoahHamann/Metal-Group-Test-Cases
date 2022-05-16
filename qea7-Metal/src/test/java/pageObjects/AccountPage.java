package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import foundation.PageObjectBase;

public class AccountPage extends PageObjectBase {
	private WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getAccountHeaderText() {
		WebElement accountHeaderTextElement = this.driver.findElement(By.cssSelector("H1.page-heading"));
		String accountHeaderText = accountHeaderTextElement.getText();
		String accountHeaderTextCleaned = accountHeaderText.replace("\"","").toLowerCase();

		return accountHeaderTextCleaned;

	}

}
