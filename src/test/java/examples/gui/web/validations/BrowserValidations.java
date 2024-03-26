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
		driver.get().browser().navigateToURL("https://www.w3schools.com/");
		(new Verifications(driver.get()))
				.verifyUrlContains("https://www.w3schools.com/")
				.verifyTitleContains("W3Schools Online Web Tutorials");
		Verifications.verifyUrlContains(driver.get(), "https://www.w3schools.com/");
	}

	@Test
	public void ValidateTitle () {
		driver.get().browser().navigateToURL("https://www.w3schools.com/");
		//make assertion
	//	Validations.assertThat().browser(driver.get().getDriver.get()).attribute("title").isNotNull().perform();
		driver.get().assertThat()
				.browser().attribute("title").isNotNull().perform();
		//make verification
		driver.get().verifyThat()
				.browser().attribute("title").isNotNull().perform();
	}

}
