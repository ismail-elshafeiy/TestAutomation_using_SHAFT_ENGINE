package gui.nopCommerce.pages;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private SHAFT.GUI.WebDriver driver;

    public MyAccountPage(SHAFT.GUI.WebDriver driver) {
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
    public MyAccountPage openChangeMyPassword_Page() {
        driver.element().click( changePassword_Link);
        return this;
    }

    @Step("enter Old password {password}")
    public MyAccountPage enterOLdPassword_TxtFd(String password) {
        driver.element().type( oldPassword_TxtBox, password);
        return this;
    }

    @Step("enter new password {password}")
    public MyAccountPage enterNewPassword_TxtFd(String newPassword) {
        driver.element().type(  newPassword_TxtBox, newPassword);
        return this;
    }


    @Step("enter Confirm password {password}")
    public MyAccountPage enterConfirmPassword_TxtFd(String newPassword) {
        driver.element()
                .type(confirmPassword_TxtBox, newPassword)
                .type(changePassword_Btn, Keys.ENTER);
        return this;
    }


}

