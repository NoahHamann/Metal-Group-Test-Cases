package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import foundation.PageObjectBase;

public class LoginPage extends PageObjectBase {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage navigate() {
		this.driver.get("http://invenauto.tech/index.php?controller=authentication&back=my-account");
		return this;
	}

	public LoginPage enterEmailText(String emailText) {
		WebElement email = this.driver.findElement(By.id("email"));
		email.sendKeys(emailText);

		return this;
	}
	
	public LoginPage enterEmailInCreateAccount(String emailText) {
		WebElement email = this.driver.findElement(By.id("email_create"));
		email.sendKeys(emailText);

		return this;
	}

	public LoginPage enterPasswordText(String passwordText) {
		WebElement password = this.driver.findElement(By.id("passwd"));
		password.sendKeys(passwordText);

		return this;
	}

	public AccountPage clickLoginButton() {
		WebElement loginButton = this.driver.findElement(By.id("SubmitLogin"));
		loginButton.click();

		return new AccountPage(this.driver);
	}
	
	public RegistrationPage clickCreateAccountButton() {
		WebElement createAccountButton = this.driver.findElement(By.id("SubmitCreate"));
		createAccountButton.click();
		return new RegistrationPage(this.driver);
	}

}
