package gui.nopCommerce.pages;

import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class P4_MyAccount_Page {
    // driver
    private WebDriver driver;

    // Constructor
    public P4_MyAccount_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Elements Locators
    private By changePassword_Link = By.linkText("Change password");
    private By oldPassword_TxtBox = By.id("OldPassword");
    private By newPassword_TxtBox = By.id("NewPassword");
    private By confirmPassword_TxtBox = By.id("ConfirmNewPassword");
    private By changePassword_Btn = By.cssSelector("button.button-1.change-password-button");

    public static By passwordWasChanged() {
        return By.xpath("//p[@class='content']");
    }

    /////////////////////////////////////////////////////////////////
    //////////////////  Business Actions ////////////////////////////
    /////////////////////////////////////////////////////////////////

    @Step("click on Change my password Link")
    public P4_MyAccount_Page openChangeMyPassword_Page() {
        ElementActions.click(driver, changePassword_Link);
        return this;
    }

    @Step("enter Old password {password}")
    public P4_MyAccount_Page enterOLdPassword_TxtFd(String password) {
        ElementActions.type(driver, oldPassword_TxtBox, password);
        return this;
    }

    @Step("enter new password {password}")
    public P4_MyAccount_Page enterNewPassword_TxtFd(String newPassword) {
        ElementActions.type(driver, newPassword_TxtBox, newPassword);
        return this;
    }


    @Step("enter Confirm password {password}")
    public P4_MyAccount_Page enterConfirmPassword_TxtFd(String newPassword) {
        (new ElementActions(driver))
                .type(confirmPassword_TxtBox, newPassword)
                .keyPress(changePassword_Btn, Keys.ENTER);
        return this;
    }


}

