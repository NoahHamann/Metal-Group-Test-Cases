import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.TestBase;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTests extends TestBase {
	//WebDriverWait wait;

	@Test
	public void canLogIntoAccount() {
		String emailText = "fake_email@gmail.com";
		String passwordText = "Abcd1234";
		String expectedHeaderText = "my account";

		//this.getDriver().manage().window().maximize();
		//this.getDriver().get("http://invenauto.tech/index.php");
		HomePage homePage = new HomePage(this.getDriver());
		homePage.navigate();
		homePage.clickSignInButton();
		//WebElement signIn = this.getDriver().findElement(By.linkText("Sign in"));
		//signIn.click();
		LoginPage loginPage = new LoginPage(this.getDriver());
		loginPage.enterEmailText(emailText);
		loginPage.enterPasswordText(passwordText);
		loginPage.clickLoginButton();
		AccountPage accountPage = new AccountPage(this.getDriver());
		//String currentUrl = this.getDriver().getCurrentUrl();

		assertEquals(accountPage.getAccountHeaderText(), expectedHeaderText, "current url should match actual url of AccountPage.");

		//WebElement signIn = this.getDriver().findElement(By.linkText("Sign in"));
		//signIn.click();

		//WebElement username = this.getDriver().findElement(By.id("email"));

		//WebElement password = this.getDriver().findElement(By.id("passwd"));

		//WebElement login = this.getDriver().findElement(By.id("SubmitLogin"));

		//username.sendKeys("fake_email@gmail.com");
		//password.sendKeys("Abcd1234");
		//login.click();

		//String actualUrl = "http://invenauto.tech/index.php?controller=my-account";
		//String expectedUrl = this.getDriver().getCurrentUrl();
		//Assert.assertEquals(actualUrl, expectedUrl, "Exepcted post-login and actual post-login URL's do not match.");

	}

}
