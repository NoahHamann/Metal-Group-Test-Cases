import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Set {
	private static WebDriver driver;
	WebDriverWait wait;

	public Set(WebDriver driver) {
		this.driver = driver;

	}

	public void time() {
		ProductDetailPage pdPage = new ProductDetailPage(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdPage.element()));
	}

}
