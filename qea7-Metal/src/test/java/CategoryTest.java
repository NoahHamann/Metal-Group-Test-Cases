import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CategoryTest extends TestBase {

	@Test
	public void canClickEachCategory() {
		this.getDriver().navigate().to("http://invenauto.tech/index.php");
		List<WebElement> actualCategoryName = this.getDriver()
				.findElements(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li"));
		String[] expectedCategoryName = { "WOMEN", "DRESSES", "T-SHIRTS" };

		for (int i = 0; i < actualCategoryName.size(); i++) {
			actualCategoryName.get(i).click();
			this.getDriver().navigate().back();
		}

		assertEquals(actualCategoryName.get(0).getText(), expectedCategoryName[0], "not mach");
		assertEquals(actualCategoryName.get(1).getText(), expectedCategoryName[1], "not mach");
		assertEquals(actualCategoryName.get(2).getText(), expectedCategoryName[2], "not mach");

	}
}
