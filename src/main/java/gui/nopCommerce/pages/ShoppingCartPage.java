package gui.nopCommerce.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    private SHAFT.GUI.WebDriver driver;

    public ShoppingCartPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By termsService_chkBx = By.xpath("//input[@id='termsofservice']");
    private By checkout_Btn = By.xpath("//button[@id='checkout']");


    /////////////////////////////////////////////////////////////////
    /////////////////// Business Actions ////////////////////////////
    /////////////////////////////////////////////////////////////////

    @Step("Select the Agree Terms of Service Letter ")
    public ShoppingCartPage checkAgreeTermsService_ChkBx(String state) {
        if (state.equalsIgnoreCase("uncheck")
                && driver.getDriver().findElement(termsService_chkBx).isSelected()) {
            driver.element().click( termsService_chkBx);
        } else if (state.equalsIgnoreCase("check")
                && !driver.getDriver().findElement(termsService_chkBx).isSelected()){
            driver.element().click( termsService_chkBx);
        }
        return this;
    }

    @Step("Click on Checkout Button")
    public CheckoutPage clickOn_checkOutButton() {
        driver.element().click(checkout_Btn);
        return new CheckoutPage(driver);
    }

}
