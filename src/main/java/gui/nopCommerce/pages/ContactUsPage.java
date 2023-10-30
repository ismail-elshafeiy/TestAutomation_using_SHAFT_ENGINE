package gui.nopCommerce.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class ContactUsPage {
    private SHAFT.GUI.WebDriver driver;

    public ContactUsPage(SHAFT.GUI.WebDriver driver) {
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
    public ContactUsPage enterFullName_TxtFd(String fullName) {
        driver.element().type( fullName_txtField, fullName);
        return this;
    }

    @Step("enter email --> [{email}]")
    public ContactUsPage enterEmail_TxtFd(String email) {
        driver.element().type( email_txtField, email);
        return this;
    }

    @Step("enter Enquiry --> [{enquiry}]")
    public ContactUsPage enterEnquiry_TxtFd(String enquiry) {
        driver.element().type( enquiry_txtField, enquiry);
        return this;
    }

    @Step("Click on Submit Button")
    public ContactUsPage clickOn_SubmitButton(){
        driver.element().click(submit_btn);
        return this;
    }
}
