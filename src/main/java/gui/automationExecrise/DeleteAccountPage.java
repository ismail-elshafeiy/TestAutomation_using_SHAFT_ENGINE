package gui.automationExecrise;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DeleteAccountPage {

    private SHAFT.GUI.WebDriver driver;

    private final By accountDeleted_h2 = By.cssSelector("h2[data-qa='account-deleted'] > b");
    private final By continueBtn_button=By.cssSelector("a[data-qa='continue-button']");

    public DeleteAccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click On Continue Button")
    public DeleteAccountPage clickOnContinueBtn(){
        driver.element().click(continueBtn_button);
        return this;
    }

    @Step("Validate Account Deleted")
    public DeleteAccountPage validateAccountDeleted(String expectedMessage) {
        driver.verifyThat().element(accountDeleted_h2).text().equalsIgnoringCaseSensitivity(expectedMessage).perform();
        return this;
    }
}
