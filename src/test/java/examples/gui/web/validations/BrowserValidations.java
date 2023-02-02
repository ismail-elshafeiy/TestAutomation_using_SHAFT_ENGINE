package examples.gui.web.validations;

import com.shaft.validation.Validations;
import examples.gui.web.BaseTests;
import org.testng.annotations.Test;
import utils.Verifications;

public class BrowserValidations extends BaseTests {
	/**
	 * Checks by contains(), isNotNull(), isEqualTo() and isNotEqualTo() ,
	 */


	@Test
	public void ValidateUrl () {
		driver.browser().navigateToURL("https://www.w3schools.com/");
		(new Verifications(driver))
				.verifyUrlContains("https://www.w3schools.com/")
				.verifyTitleContains("W3Schools Online Web Tutorials");
		Verifications.verifyUrlContains(driver, "https://www.w3schools.com/");
	}

	@Test
	public void ValidateTitle () {
		driver.browser().navigateToURL("https://www.w3schools.com/");
		//make assertion
		Validations.assertThat().browser(driver.getDriver()).attribute("title").isNotNull().perform();
		driver.assertThat()
				.browser().attribute("title").isNotNull().perform();
		//make verification
		driver.verifyThat()
				.browser().attribute("title").isNotNull().perform();
	}

}
