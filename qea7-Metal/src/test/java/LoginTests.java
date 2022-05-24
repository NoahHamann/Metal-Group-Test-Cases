import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.TestBase;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTests extends TestBase {

	@Test
	public void canLogIntoAccount() {
		String emailText = "fake_email@gmail.com";
		String passwordText = "Abcd1234";
		String expectedHeaderText = "my account";

		HomePage homePage = new HomePage(this.getDriver());
		homePage.navigate();
		homePage.clickSignInButton();
		LoginPage loginPage = new LoginPage(this.getDriver());
		loginPage.enterEmailText(emailText);
		loginPage.enterPasswordText(passwordText);
		loginPage.clickLoginButton();
		AccountPage accountPage = new AccountPage(this.getDriver());

		assertEquals(accountPage.getAccountHeaderText(), expectedHeaderText,
				"expected header text and account header text should match.");

	}

}
