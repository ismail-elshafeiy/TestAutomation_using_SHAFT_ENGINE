package gui.nopCommerce.pages;

import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P7_ContactUsPage {
    // driver
    private WebDriver driver;
    // Constructor
    public P7_ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }
    // Elements Locators
    private By fullName_txtField = By.id("FullName");
    private By email_txtField = By.id("Email");
    private By enquiry_txtField = By.id("Enquiry");
    private By submit_btn = By.xpath("//div[@class='buttons'][1]");
    public static By successMessage_contactUsProcess(){ return By.xpath("//div[@class='result'][1]");}

    /////////////////////////////////////////////////////////////////
    //////////////////  Business Actions ////////////////////////////
    /////////////////////////////////////////////////////////////////

    @Step("enter Full Name --> [{fullName}]")
    public P7_ContactUsPage enterFullName_TxtFd(String fullName) {
        ElementActions.type(driver, fullName_txtField, fullName);
        return this;
    }

    @Step("enter email --> [{email}]")
    public P7_ContactUsPage enterEmail_TxtFd(String email) {
        ElementActions.type(driver, email_txtField, email);
        return this;
    }

    @Step("enter Enquiry --> [{enquiry}]")
    public P7_ContactUsPage enterEnquiry_TxtFd(String enquiry) {
        ElementActions.type(driver, enquiry_txtField, enquiry);
        return this;
    }

    @Step("Click on Submit Button")
    public P7_ContactUsPage clickOn_SubmitButton(){
        ElementActions.click(driver,submit_btn);
        return this;
    }


}
