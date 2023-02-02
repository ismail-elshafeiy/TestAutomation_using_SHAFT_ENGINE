package examples.gui.web.validations;

import examples.gui.web.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ElementsValidations extends BaseTests {
	@Test
	public void testValidations(){
		By searchButton = By.cssSelector("#learntocode_searchbtn");
		driver.browser().navigateToURL("https://www.w3schools.com/");
		driver.verifyThat()
				.element(searchButton)
				.exists().perform();
		driver.verifyThat()
				.element(searchButton)
				.isEnabled().perform();

	}
	@Test
	public void testValidations2(){
		By googleLogo = By.xpath("//img[@alt='Google']");
		driver.browser().navigateToURL("https://www.google.com/ncr");
		driver.verifyThat()
				.element(googleLogo).doesNotMatchReferenceImage()
				.perform();
	}

	@Test
	public void testValidations3(){
		By checkBox = By.xpath("//input[@type='checkbox'][1]");
		By checkBox2 = By.xpath("//input[@type='checkbox'][2]");
		driver.browser().navigateToURL("https://the-internet.herokuapp.com/checkboxes");
		driver.verifyThat()
				.element(checkBox).isNotChecked()
				.perform();
		driver.verifyThat()
				.element(checkBox2).isChecked()
				.perform();
	}
}
