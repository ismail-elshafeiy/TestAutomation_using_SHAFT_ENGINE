package gui.nopCommerce.pages;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private SHAFT.GUI.WebDriver driver;

    public CheckoutPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By country_dropDown = By.id("BillingNewAddress_CountryId");
    private By city_txtBox = By.id("BillingNewAddress_City");
    private By address1_txtBox = By.id("BillingNewAddress_Address1");
    private By postalCode_txtBox = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumber_txtBox = By.id("BillingNewAddress_PhoneNumber");
    private By continueAddress_Btn = By.xpath("//*[@id='billing-buttons-container']");
    private By continueShipping_Btn = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
    private By continuePayment_Btn = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    private By continueInfo_Btn = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    private By confirmOrder_Btn = By.xpath("//button[@class='button-1 confirm-order-next-step-button']");

    private By inputOrderNumber_ShippingMethodList(int shippingMethod) {
        return By.xpath("//input[@id='shippingoption_" + shippingMethod + "']");

    }

    private By inputOrderNumber_PaymentMethodList(int paymentMethod) {
        return By.xpath("//input[@id='shippingoption_" + paymentMethod + "']");
    }

    private By ground_radioBtn = By.id("shippingoption_1");


    public static By success_checkoutMessage_txt = By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]");


    /////////////////////////////////////////////////////////////////
    //////////////////  Business Actions ////////////////////////////
    /////////////////////////////////////////////////////////////////


    @Step("Enter Email {email} And password {password}")
    public CheckoutPage enterAddress(String country, String city, String address1, String postalCode) {
        driver.element()
                .select(country_dropDown, country)
                .type(city_txtBox, city)
                .type(address1_txtBox, address1)
                .type(postalCode_txtBox, postalCode);
        return this;
    }

    @Step("Enter Phone Number [{phoneNumber}]")
    public CheckoutPage enterPhoneNumber(String phoneNumber) {
        driver.element().type(phoneNumber_txtBox, phoneNumber);
        return this;
    }

    @Step("Click on Continue Button in Billing Address")
    public CheckoutPage clickOn_ContinueButton_address() {
        driver.element().click(continueAddress_Btn);
        return this;
    }

    @Step("Click on Continue Button in Shipping Method")
    public CheckoutPage clickOn_ContinueButton_Shipping() {
        driver.element().click(continueShipping_Btn);
        return this;
    }

    @Step("Click on Continue Button in Payment method")
    public CheckoutPage clickOn_ContinueButton_payment() {
        driver.element().click(continuePayment_Btn);
        return this;
    }

    @Step("Click on Continue Button in Payment information")
    public CheckoutPage clickOn_ContinueButton_info() {
        driver.element().click(continueInfo_Btn);
        return this;
    }

    @Step("Click on Confirm Button in Confirm order")
    public CheckoutPage clickOn_ConfirmOrderButton() {
        driver.element().click(confirmOrder_Btn);
        return this;
    }

    @Step("Select shipping Method --> [{shippingOrder}] from the list")
    public CheckoutPage setOrderNumber_ShippingMethodList(int shippingMethod) {
        driver.element().click(inputOrderNumber_ShippingMethodList(shippingMethod));
        return this;
    }

    @Step("Select payment Method --> [{paymentOrder}] from the list")
    public CheckoutPage setOrderNumber_paymentMethodList(int paymentMethod) {
        driver.element().click(inputOrderNumber_PaymentMethodList(paymentMethod));
        return this;
    }

    @Step("Click on Ground Button")
    public CheckoutPage clickOn_groundRadio() {
        driver.element().click(ground_radioBtn);
        return this;
    }


}
