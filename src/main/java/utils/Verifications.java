package utils;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

// Soft Assertion
public class Verifications {

	public final SHAFT.GUI.WebDriver driver;

	public Verifications (SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	public static void verifyUrlContains (SHAFT.GUI.WebDriver driver, String expectedUrl) {
		driver.verifyThat().browser().title().contains(expectedUrl).perform();
	}

	public Verifications verifyUrlContains (String expectedUrl) {
		verifyUrlContains(driver, expectedUrl);
		return this;
	}

	public static void verifyBrowserAttribute (SHAFT.GUI.WebDriver driver, String browserAttribute, String expectedValue) {
		driver.verifyThat().browser().attribute(browserAttribute).contains(expectedValue).perform();
	}

	public Verifications verifyBrowserAttribute (String browserAttribute, String expectedValue) {
		verifyBrowserAttribute(driver, browserAttribute, expectedValue);
		return this;
	}

	public static void verifyTitleContains (SHAFT.GUI.WebDriver driver, String expectedTitle) {
		driver.verifyThat().browser().title().contains(expectedTitle).perform();
	}

	public Verifications verifyTitleContains (String expectedTitle) {
		verifyTitleContains(driver, expectedTitle);
		return this;
	}

	public static void verifyTextIsEqualTo (SHAFT.GUI.WebDriver driver, By locator, String expectedText) {
		driver.verifyThat().element(locator).text().isEqualTo(expectedText).perform();
	}

	public Verifications verifyTextIsEqualTo (By locator, String expectedText) {
		verifyTextIsEqualTo(driver, locator, expectedText);
		return this;
	}

	public static void verifyTextContains (SHAFT.GUI.WebDriver driver, By locator, String expectedText) {
		driver.verifyThat().element(locator).text().contains(expectedText).perform();
	}

	public Verifications verifyTextContains (By locator, String expectedText) {
		verifyTextContains(driver, locator, expectedText);
		return this;
	}

	public static void verifyTextNotNull (SHAFT.GUI.WebDriver driver, By locator) {
		driver.verifyThat().element(locator).text().isNotNull().perform();
	}

	public Verifications verifyTextNotNull (By locator, String expectedText) {
		verifyTextNotNull(driver, locator);
		return this;
	}

}
