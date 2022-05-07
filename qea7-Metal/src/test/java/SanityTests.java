import static org.testng.Assert.assertFalse;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SanityTests extends TestBase {
	
	@Test
	public void canLaunchWebdriver() {
		WebDriver driver = this.getDriver();
		assertFalse(driver == null, "the webdriver should be initialized");
	}
}
