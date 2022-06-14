package nopCommerce.pages.gui;

import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P11_ShoppingCart_Page {
    private WebDriver driver;

    public P11_ShoppingCart_Page(WebDriver driver) {
        this.driver = driver;
    }

    private By termsService_chkBx = By.xpath("//input[@id='termsofservice']");
    private By checkout_Btn = By.xpath("//button[@id='checkout']");


    /////////////////////////////////////////////////////////////////
    /////////////////// Business Actions ////////////////////////////
    /////////////////////////////////////////////////////////////////

    @Step("Select the Agree Terms of Service Letter ")
    public P11_ShoppingCart_Page checkAgreeTermsService_ChkBx(String state) {
        if (state.equalsIgnoreCase("uncheck")
                && driver.findElement(termsService_chkBx).isSelected()) {
            ElementActions.click(driver, termsService_chkBx);

        } else if (state.equalsIgnoreCase("check")
                && !driver.findElement(termsService_chkBx).isSelected()) {
            ElementActions.click(driver, termsService_chkBx);
        }
        return this;
    }

    @Step("Click on Checkout Button")
    public P14_Checkout_Page clickOn_checkOutButton() {
        ElementActions.click(driver, checkout_Btn);
        return new P14_Checkout_Page(driver);
    }

}
