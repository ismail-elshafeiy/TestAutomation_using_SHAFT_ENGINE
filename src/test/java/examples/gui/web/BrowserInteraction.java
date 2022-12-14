package examples.gui.web;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Browser Interactions")
@Feature("Windows")
public class BrowserInteraction extends BaseTests {

	@Story("Window management ")
	@Test
	public void testWindowActions1 () {
		driver.browser()
				.navigateToURL("https://www.w3schools.com/")
				.setWindowSize(600, 466)
				.getWindowSize();
		driver.browser()
				.maximizeWindow()
				.fullScreenWindow()
				.refreshCurrentPage()
				.navigateBack().getCurrentURL();
		driver.browser().getCurrentWindowTitle();
	}

	@Story("Window management ")
	@Test
	public void testSwitchToWindow () {
		driver.browser().navigateToURL("https://www.w3schools.com/");
		String parentWindow = driver.browser().getWindowHandle();
		driver.browser()
				.switchToNewTab("https://the-internet.herokuapp.com/windows")
				.switchToWindow(parentWindow)
				.getWindowPosition();
		driver.browser().capturePageSnapshot();
	}
	@Story("Window management ")
	@Test
	public void basicAuth () {
		driver.browser().navigateToURLWithBasicAuthentication(
				"https://the-internet.herokuapp.com/basic_auth",
				"admin",
				"admin",
				"https://the-internet.herokuapp.com/basic_auth");
		driver.browser().capturePageSnapshot();
		driver.browser().getPageSource();
	}
}
