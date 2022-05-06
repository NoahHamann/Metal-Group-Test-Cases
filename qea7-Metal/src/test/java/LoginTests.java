import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
	WebDriverWait wait;

	@Test
	public void canLogIntoAccount() {

		this.getDriver().manage().window().maximize();
		this.getDriver().get("http://invenauto.tech/index.php?controller=authentication&back=my-account");

		WebElement username = this.getDriver().findElement(By.id("email"));
		WebElement password = this.getDriver().findElement(By.id("passwd"));
		WebElement login = this.getDriver().findElement(By.id("SubmitLogin"));
		username.sendKeys("fake_email@gmail.com");
		password.sendKeys("Abcd1234");
		login.click();

		String actualUrl = this.getDriver().getCurrentUrl();
		String expectedUrl = "http://invenauto.tech/index.php?controller=my-account";
		Assert.assertEquals(actualUrl, expectedUrl, "Exepcted post-login and actual post-login URL's do not match.");

	}

}
