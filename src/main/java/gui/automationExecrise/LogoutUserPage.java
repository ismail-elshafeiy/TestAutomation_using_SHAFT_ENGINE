package gui.automationExecrise;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LogoutUserPage {
    private SHAFT.GUI.WebDriver driver;

    private final By logoutBtn_button = By.xpath("//a[contains(text(),\" Logout\")]");

    public LogoutUserPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigate To Home Page")
    public LogoutUserPage logOut() {
        driver.element().click(logoutBtn_button);
        return this;
    }
}
