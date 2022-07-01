package gui.nopCommerce.pages;

import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class P3_Login_Page {
    // driver
    private WebDriver driver;

    // Constructor
    public P3_Login_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Elements Locators
    private By email_TxtBox = By.id("Email");
    private By password_TxtBox = By.id("Password");
    private By rememberMe_ChkBx = By.cssSelector("input#RememberMe");
    private By login_Btn = By.cssSelector("button.button-1.login-button");
    private By myAccount_Link = By.cssSelector("a.ico-account");

    public static By myAccount_txt() {
        return By.cssSelector("a.ico-account");
    }


    /////////////////////////////////////////////////////////////////
    //////////////////  Business Actions ////////////////////////////
    /////////////////////////////////////////////////////////////////

    @Step("Enter Email [{ email }] And password [{ password }]")
    public P1_Home_Page loginViaEmail(String email, String password) {
        (new ElementActions(driver))
                .type(email_TxtBox, email)
                .type(password_TxtBox, password)
                .keyPress(login_Btn, Keys.ENTER);
        return new P1_Home_Page(driver);
    }

    @Step("Select Remember Me ? {state}")
    public P3_Login_Page selectRememberMe_ChkBx(String state) {
        if (state.equalsIgnoreCase("uncheck") && driver.findElement(rememberMe_ChkBx).isSelected()) {
            ElementActions.click(driver, rememberMe_ChkBx);

        } else if (state.equalsIgnoreCase("check") && !driver.findElement(rememberMe_ChkBx).isSelected()) {
            ElementActions.click(driver, rememberMe_ChkBx);
        }
        return this;
    }


}
