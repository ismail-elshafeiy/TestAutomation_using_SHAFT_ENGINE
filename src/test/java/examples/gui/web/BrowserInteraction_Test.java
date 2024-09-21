package examples.gui.web;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Browser Interactions")
@Feature("Windows")
public class BrowserInteraction_Test extends BaseTests {

	@Story("Window management")
	@Test
	public void testWindowActions1 () {
		driver.get()
				.browser()
				.navigateToURL("https://www.w3schools.com/")
				.setWindowSize(600, 466)
				.getWindowSize();
		driver.get()
				.browser()
				.maximizeWindow()
				.fullScreenWindow()
				.refreshCurrentPage()
				.navigateBack().getCurrentURL();
		driver.get()
				.browser().getCurrentWindowTitle();
		driver.get()
				.verifyThat().browser()
				.attribute("title")
				.contains("W3Schools")
				.withCustomReportMessage("Test The title of the page is not as expected")
				.perform();
	}

	@Story("Window management ")
	@Test
	public void testSwitchToWindow () {
		driver.get()
				.browser().navigateToURL("https://www.w3schools.com/");
		String parentWindow = driver.get()
				.browser().getWindowHandle();
		driver.get()
				.browser()
				.switchToWindow("https://the-internet.herokuapp.com/windows")
				.switchToWindow(parentWindow)
				.getWindowPosition();
		driver.get()
				.browser().capturePageSnapshot();
		driver.get()
				.verifyThat().browser()
				.attribute("title")
				.isEqualTo("W3Schools Online Web Tutorials")
				.withCustomReportMessage("Test The title of the page is not as expected")
				.perform();
	}
	@Story("Window management ")
	@Test
	public void basicAuth () {
		driver.get()
				.browser().navigateToURLWithBasicAuthentication(
				"https://the-internet.herokuapp.com/basic_auth",
				"admin",
				"admin",
				"https://the-internet.herokuapp.com/basic_auth");
		driver.get()
				.browser().capturePageSnapshot();
		driver.get()
				.browser().getPageSource();
	}
}
