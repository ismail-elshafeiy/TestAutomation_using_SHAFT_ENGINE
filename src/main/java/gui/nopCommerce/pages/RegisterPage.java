package gui.nopCommerce.pages;

import com.shaft.driver.SHAFT;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.FakerData;

public class RegisterPage {
    // driver
    private SHAFT.GUI.WebDriver driver;

    // Constructor
    public RegisterPage(SHAFT.GUI.WebDriver driver) {
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
    public RegisterPage chooseGender_RdBtn(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driver.element().click(maleGender_RdBtn);
        } else if (gender.equalsIgnoreCase("female")) {
            driver.element().click(femaleGender_RdBtn);
        }
        return this;
    }

    @Step("Enter First Name: [ {firstName} ]")
    public RegisterPage enterFirstName_TxtFd(String firstName) {
        driver.element().type(firstName_txtBox, firstName);
        return this;
    }

    @Step("3.Enter Last Name: [ {lastName} ]")
    public RegisterPage enterLastName_TxtFd(String lastName) {
        driver.element().type(lastName_TxtBox, lastName);
        return this;
    }

    @Step("4.Select the Birthday [{day} / {month} / {year}]")
    public RegisterPage chooseBirthDay_DpDn(String day, String month, String year) {
        driver.element().select(dayList_DpDn, day);
        driver.element().select(monthList_DpDn, month);
        driver.element().select(yearList_DpDn, year);
        return this;
    }


    @Step("5.Enter Email: [ {email} ]")
    public RegisterPage enterEmail_TxtFd(String email) {
        driver.element().type(email_txt, email);
        return this;
    }


    @Step("6.Enter Company Name: [ {company} ]")
    public RegisterPage enterCompany_TxtFd(String company) {
        driver.element().type(companyName_TxtBox, company);
        return this;
    }

    @Step("7.Select the News Letter: [ {state} ]")
    public RegisterPage newsLetterOptions_ChkBx(String state) {
        if (state.equalsIgnoreCase("uncheck")) {
            driver.element().click(newsLetter_ChkBx);

        } else if (state.equalsIgnoreCase("check")) {
            driver.element().click(newsLetter_ChkBx);
        }
        return this;
    }

    @Step("8.Enter Password: [ {password} ]")
    public RegisterPage enterPassword_TxtFd(String password) {
        driver.element().type(password_txt, password);
        return this;
    }

    @Step("9.Enter Confirm Password: [ {password} ]")
    public RegisterPage enterConfirmPassword_TxtFd(String password) {
        driver.element().type(confirmPassword_txtBox, password);
        return this;
    }

    @Step("10.Click On Register Button")
    public RegisterPage clickOn_RegisterButton() {
        driver.element().click(register_Btn);
        return this;
    }

    @Step("User logout")
    public RegisterPage clickOn_LogOut() {
        driver.element().click(logout_Link);
        return new RegisterPage(driver);
    }


    @Step("Get the text of Register After logout")
    public String getRegisterLink() {
        return driver.element().getText(register_Link);
    }

    @Step("Get the Error Message when enter wrong Email")
    public String getErrorFirstNameRequired() {
        return driver.element().getText(error_firstNameRequired);
    }

    @Step("Get the Error Email when enter wrong Email")
    public String getErrorMessageEmail() {
        return driver.element().getText(error_wrongEmail);
    }

    @Step("Get the Error Password when enter wrong Password")
    public String getErrorPassword() {
        return driver.element().getText(error_passwordFormat);
    }

    @Step("Get the Error of Password when enter passwordDonotMatch")
    public String getErrorPasswordDontMatch() {
        return driver.element().getText(error_passwordDoNotMatch);
    }

    @Step("Register with required data")
    public RegisterPage registerWithRequired(String email, String password) {
        enterFirstName_TxtFd(FakerData.getFirstName());
        enterLastName_TxtFd(FakerData.getLastName());
        enterEmail_TxtFd(email);
        enterPassword_TxtFd(password);
        enterConfirmPassword_TxtFd(password);
        clickOn_RegisterButton();
        return this;

    }
}

