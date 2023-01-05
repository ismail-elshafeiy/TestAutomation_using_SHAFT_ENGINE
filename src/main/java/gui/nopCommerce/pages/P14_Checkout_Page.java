package gui.nopCommerce.pages;

import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P14_Checkout_Page {

    private WebDriver driver;

    public P14_Checkout_Page(WebDriver driver) {
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
    public P14_Checkout_Page enterAddress(String country, String city, String address1, String postalCode) {
        (new ElementActions(driver))
                .select(country_dropDown, country)
                .type(city_txtBox, city)
                .type(address1_txtBox, address1)
                .type(postalCode_txtBox, postalCode);
        return this;
    }

    @Step("Enter Phone Number [{phoneNumber}]")
    public P14_Checkout_Page enterPhoneNumber(String phoneNumber) {
        ElementActions.type(driver, phoneNumber_txtBox, phoneNumber);
        return this;
    }

    @Step("Click on Continue Button in Billing Address")
    public P14_Checkout_Page clickOn_ContinueButton_address() {
        ElementActions.click(driver, continueAddress_Btn);
        return this;
    }

    @Step("Click on Continue Button in Shipping Method")
    public P14_Checkout_Page clickOn_ContinueButton_Shipping() {
        ElementActions.click(driver, continueShipping_Btn);
        return this;
    }

    @Step("Click on Continue Button in Payment method")
    public P14_Checkout_Page clickOn_ContinueButton_payment() {
        ElementActions.click(driver, continuePayment_Btn);
        return this;
    }

    @Step("Click on Continue Button in Payment information")
    public P14_Checkout_Page clickOn_ContinueButton_info() {
        ElementActions.click(driver, continueInfo_Btn);
        return this;
    }

    @Step("Click on Confirm Button in Confirm order")
    public P14_Checkout_Page clickOn_ConfirmOrderButton() {
        ElementActions.click(driver, confirmOrder_Btn);
        return this;
    }

    @Step("Select shipping Method --> [{shippingOrder}] from the list")
    public P14_Checkout_Page setOrderNumber_ShippingMethodList(int shippingMethod) {
        ElementActions.click(driver, inputOrderNumber_ShippingMethodList(shippingMethod));
        return this;
    }

    @Step("Select payment Method --> [{paymentOrder}] from the list")
    public P14_Checkout_Page setOrderNumber_paymentMethodList(int paymentMethod) {
        ElementActions.click(driver, inputOrderNumber_PaymentMethodList(paymentMethod));
        return this;
    }

    @Step("Click on Ground Button")
    public P14_Checkout_Page clickOn_groundRadio() {
        ElementActions.click(driver, ground_radioBtn);
        return this;
    }


}
