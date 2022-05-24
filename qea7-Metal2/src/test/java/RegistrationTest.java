import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import foundation.TestBase;
import pageObjects.LoginPage;


public class RegistrationTest extends TestBase {
	@BeforeMethod 
	protected String getRandomString() {
		String charactersAndNumbers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder buildString = new StringBuilder();
		Random rnd = new Random();
		while (buildString.length() < 10) {
			int index = (int) (rnd.nextFloat() * charactersAndNumbers.length());
			buildString.append(charactersAndNumbers.charAt(index));
		}
		String randomString = buildString.toString();
		return randomString;
	}
  @Test
  public void canRegisterWithValidEmail() {
	
	  String expectedMessage = "Your account has been created.";
	  String validEmail = this.getRandomString() + "@gmail.com";
	  String firstName = "Joe";
	  String lastName = "Schmoe";
	  String password = "thisismypass";
	  String day = "10";
	  String month = "10";
	  String year = "2001";
	  
	  String actualMessage = new LoginPage(this.getDriver())
	  	.navigate()
	  	.enterEmailInCreateAccount(validEmail)
	  	.clickCreateAccountButton()
	  	.enterFirstName(firstName)
	  	.enterLastName(lastName)
	  	.enterPassword(password)
	  	.enterDateOfBirth(day, month, year)
	  	.clickRegister()
	  	.getRegistrationSuccess();
	 
	  assertEquals(expectedMessage, actualMessage);
  }
}
