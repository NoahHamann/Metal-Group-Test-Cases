import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import foundation.TestBase;

public class RegistrationTests extends TestBase {
	@Test
	public void canRegisterNewAccount() {

		this.getDriver().manage().window().maximize();
		this.getDriver().get("http://invenauto.tech/index.php");
		int emailAttribute = 0;

		WebElement signIn = this.getDriver().findElement(By.linkText("Sign in"));
		signIn.click();

		WebElement email = this.getDriver().findElement(By.id("email_create"));
	}
}
