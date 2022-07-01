package gui.nopCommerce.pages;

import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P2_Register_Page {
    // driver
    private WebDriver driver;

    // Constructor
    public P2_Register_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Elements Locators
    private By register_Screen = By.cssSelector("div.form-fields");
    private By maleGender_RdBtn = By.xpath("//div[@id='gender']/span[1]");
    private By femaleGender_RdBtn = By.xpath("//div[@id='gender']/span[2]");
    private By firstName_txtBox = By.id("FirstName");
    private By error_firstNameRequired = By.id("FirstName-error");
    private By lastName_TxtBox = By.id("LastName");
    private By dayList_DpDn = By.name("DateOfBirthDay");
    private By monthList_DpDn = By.name("DateOfBirthMonth");
    private By yearList_DpDn = By.name("DateOfBirthYear");
    private By companyName_TxtBox = By.id("Company");
    private By newsLetter_ChkBx = By.id("Newsletter");
    private By email_txt = By.id("Email");
    private By error_wrongEmail = By.id("Email-error");
    private By password_txt = By.id("Password");
    private By error_passwordFormat = By.id("Password-error");
    private By error_passwordDoNotMatch = By.id("ConfirmPassword-error");
    private By confirmPassword_txtBox = By.id("ConfirmPassword");
    private By register_Btn = By.cssSelector("button#register-button.button-1.register-next-step-button");
    private By register_Link = By.cssSelector("a.ico-register");
    private By continue_Btn = By.cssSelector("a.button-1.register-continue-button");
    private By logout_Link = By.linkText("Log out");

    public static By register_SuccessMessage() {
        return By.cssSelector("div.result");
    }

    /////////////////////////////////////////////////////////////////
    //////////////////  Business Actions ////////////////////////////
    /////////////////////////////////////////////////////////////////

    @Step("Choose Gender: [ {gender} ]")
    public P2_Register_Page chooseGender_RdBtn(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            ElementActions.click(driver, maleGender_RdBtn);
        } else if (gender.equalsIgnoreCase("female")) {
            ElementActions.click(driver, femaleGender_RdBtn);
        }
        return this;
    }

    @Step("Enter First Name: [ {firstName} ]")
    public P2_Register_Page enterFirstName_TxtFd(String firstName) {
        ElementActions.type(driver, firstName_txtBox, firstName);
        return this;
    }

    @Step("3.Enter Last Name: [ {lastName} ]")
    public P2_Register_Page enterLastName_TxtFd(String lastName) {
        ElementActions.type(driver, lastName_TxtBox, lastName);
        return this;
    }

    @Step("4.Select the Birthday [{day} / {month} / {year}]")
    public P2_Register_Page chooseBirthDay_DpDn(String day, String month, String year) {
        ElementActions.select(driver, dayList_DpDn, day);
        ElementActions.select(driver, monthList_DpDn, month);
        ElementActions.select(driver, yearList_DpDn, year);
        return this;
    }


    @Step("5.Enter Email: [ {email} ]")
    public P2_Register_Page enterEmail_TxtFd(String email) {
        ElementActions.type(driver, email_txt, email);
        return this;
    }


    @Step("6.Enter Company Name: [ {company} ]")
    public P2_Register_Page enterCompany_TxtFd(String company) {
        ElementActions.type(driver, companyName_TxtBox, company);
        return this;
    }

    @Step("7.Select the News Letter: [ {state} ]")
    public P2_Register_Page newsLetterOptions_ChkBx(String state) {
        if (state.equalsIgnoreCase("uncheck")
                && driver.findElement(newsLetter_ChkBx).isSelected()) {
            ElementActions.click(driver, newsLetter_ChkBx);

        } else if (state.equalsIgnoreCase("check")
                && !driver.findElement(newsLetter_ChkBx).isSelected()) {
            ElementActions.click(driver, newsLetter_ChkBx);
        }
        return this;
    }

    @Step("8.Enter Password: [ {password} ]")
    public P2_Register_Page enterPassword_TxtFd(String password) {
        ElementActions.type(driver, password_txt, password);
        return this;
    }

    @Step("9.Enter Confirm Password: [ {password} ]")
    public P2_Register_Page enterConfirmPassword_TxtFd(String password) {
        ElementActions.type(driver, confirmPassword_txtBox, password);
        return this;
    }

    @Step("10.Click On Register Button")
    public P2_Register_Page clickOn_RegisterButton() {
        ElementActions.click(driver, register_Btn);
        return this;
    }

    @Step("User logout")
    public P2_Register_Page clickOn_LogOut() {
        ElementActions.click(driver, logout_Link);
        return new P2_Register_Page(driver);
    }


    @Step("Get the text of Register After logout")
    public String getRegisterLink() {
        return ElementActions.getText(driver, register_Link);
    }

    @Step("Get the Error Message when enter wrong Email")
    public String getErrorFirstNameRequired() {
        return ElementActions.getText(driver, error_firstNameRequired);
    }

    @Step("Get the Error Email when enter wrong Email")
    public String getErrorMessageEmail() {
        return ElementActions.getText(driver, error_wrongEmail);
    }

    @Step("Get the Error Password when enter wrong Password")
    public String getErrorPassword() {
        return ElementActions.getText(driver, error_passwordFormat);
    }

    @Step("Get the Error of Password when enter passwordDonotMatch")
    public String getErrorPasswordDontMatch() {
        return ElementActions.getText(driver, error_passwordDoNotMatch);
    }
}

