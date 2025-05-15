package gui.automationExecrise;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TestCasePage {
    private SHAFT.GUI.WebDriver driver;

    private  final By testCasePageTitle_h2 = By.cssSelector("h2 > b");

    public TestCasePage(SHAFT.GUI.WebDriver driver)
    {
        this.driver= driver;
    }

    @Step("Validate On Test Cases Page Is Loaded")
    public TestCasePage assertTestCasePageLoaded(String testCasePageTitle) {
        driver.verifyThat().element(testCasePageTitle_h2).textTrimmed().equalsIgnoringCaseSensitivity(testCasePageTitle).perform();
        return this;
    }
}
