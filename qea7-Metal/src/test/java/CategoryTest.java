import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CategoryTest extends TestBase {

	@Test
	public void canClickEachCategory() {
		String[] expectedCategoryTitle = { "WOMEN", "DRESSES", "T-SHIRTS" };

		List<WebElement> getCategoryTitle = new HomePage(this.getDriver())
				.navigate()
				.clickToEachCategory()
				.getAllCategories();

		assertEquals(getCategoryTitle.get(0).getText(), expectedCategoryTitle[0], "not mach");
		assertEquals(getCategoryTitle.get(1).getText(), expectedCategoryTitle[1], "not mach");
		assertEquals(getCategoryTitle.get(2).getText(), expectedCategoryTitle[2], "not mach");

	}
}
