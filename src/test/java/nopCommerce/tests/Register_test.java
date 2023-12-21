package nopCommerce.tests;

import io.qameta.allure.*;
import gui.nopCommerce.pages.HomePage;
import gui.nopCommerce.pages.RegisterPage;
import nopCommerce.tests.BaseTest;
import org.testng.annotations.Test;

@Epic("EP1_User Module")
@Feature("GUI")
public class Register_test extends BaseTest {

    @Story("S1_As a guest, I want to Sign Up Via Email")
    @Test(description = "RE_001_Verify the Guest Can Register via Valid Data")
    @Description("Given the browser is open, When the guest navigate to Home Page, And click on sign in linkText" +
            "And navigate to create account page, And Add new account registration data, Then navigate to Home page Again")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("CBV2-2")
    @Issue("CBV2-102")
    public void RE_001_GuestRegister_viaValidEmail() {
        String gender = register_TD.getTestData("Gender");
        String firstName = register_TD.getTestData("FirstName");
        String lastName = register_TD.getTestData("LastName");
        String day = register_TD.getTestData("Day");
        String month = register_TD.getTestData("Month");
        String year = register_TD.getTestData("Year");
        String email = register_TD.getTestData("Email");
        String password = register_TD.getTestData("Password");
        String company = register_TD.getTestData("Company");
        String checkBoxNewsLetter = register_TD.getTestData("NewsLetter");
        String expectedResult_RegisterProcess = register_TD.getTestData("ExpectedResult_AlertMessage");
        new HomePage(driver).navigateTo_HomePage()
                .openRegister_Page()
                .chooseGender_RdBtn(gender)
                .enterFirstName_TxtFd(firstName)
                .enterLastName_TxtFd(lastName)
                .chooseBirthDay_DpDn(day, month, year)
                .enterEmail_TxtFd(email)
                .enterCompany_TxtFd(company)
                .newsLetterOptions_ChkBx(checkBoxNewsLetter)
                .enterPassword_TxtFd(password)
                .enterConfirmPassword_TxtFd(password)
                .clickOn_RegisterButton();
        driver.verifyThat()
                .element( RegisterPage.register_SuccessMessage()).text()
                .contains(expectedResult_RegisterProcess)
                .withCustomReportMessage("Assert that the new account created By Get Success Message text of 'Register' process")
                .perform();
    }

    @Story("S1_As a guest, I want to Sign Up Via Email")
    @Test(description = "RE_001_Verify the Guest Can Register via Valid Data")
    @Description("Given the browser is open, When the guest navigate to Home Page, And click on sign in linkText" +
            "And navigate to create account page, And Add new account registration data, Then navigate to Home page Again")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("CBV2-2")
    @Issue("CBV2-102")
    public void RE_001_GuestRegister_viaValidEmail1() {
        String gender = register_TD.getTestData("Gender");
        String firstName = register_TD.getTestData("FirstName");
        String lastName = register_TD.getTestData("LastName");
        String day = register_TD.getTestData("Day");
        String month = register_TD.getTestData("Month");
        String year = register_TD.getTestData("Year");
        String email1 = register_TD.getTestData("Email1");
        String password = register_TD.getTestData("Password");
        String company = register_TD.getTestData("Company");
        String checkBoxNewsLetter = register_TD.getTestData("NewsLetter");
        String expectedResult_RegisterProcess = register_TD.getTestData("ExpectedResult_AlertMessage");
        new HomePage(driver).navigateTo_HomePage()
                .openRegister_Page()
                .chooseGender_RdBtn(gender)
                .enterFirstName_TxtFd(firstName)
                .enterLastName_TxtFd(lastName)
                .chooseBirthDay_DpDn(day, month, year)
                .enterEmail_TxtFd(email1)
                .enterCompany_TxtFd(company)
                .newsLetterOptions_ChkBx(checkBoxNewsLetter)
                .enterPassword_TxtFd(password)
                .enterConfirmPassword_TxtFd(password)
                .clickOn_RegisterButton();
        driver.verifyThat()
                .element(RegisterPage.register_SuccessMessage()).text()
                .contains(expectedResult_RegisterProcess)
                .withCustomReportMessage("Assert that the new account created By Get Success Message text of 'Register' process")
                .perform();
    }

    @Story("S1_As a guest, I want to Sign Up Via Email")
    @Test(description = "RE_001_Verify the Guest Can Register via Valid Data")
    @Description("Given the browser is open, When the guest navigate to Home Page, And click on sign in linkText" +
            "And navigate to create account page, And Add new account registration data, Then navigate to Home page Again")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("CBV2-2")
    @Issue("CBV2-102")
    public void RE_001_GuestRegister_viaValidEmail2() {
        String gender = register_TD.getTestData("Gender");
        String firstName = register_TD.getTestData("FirstName");
        String lastName = register_TD.getTestData("LastName");
        String day = register_TD.getTestData("Day");
        String month = register_TD.getTestData("Month");
        String year = register_TD.getTestData("Year");
        String email2 = register_TD.getTestData("Email2");
        String password = register_TD.getTestData("Password");
        String company = register_TD.getTestData("Company");
        String checkBoxNewsLetter = register_TD.getTestData("NewsLetter");
        String expectedResult_RegisterProcess = register_TD.getTestData("ExpectedResult_AlertMessage");
        new HomePage(driver).navigateTo_HomePage()
                .openRegister_Page()
                .chooseGender_RdBtn(gender)
                .enterFirstName_TxtFd(firstName)
                .enterLastName_TxtFd(lastName)
                .chooseBirthDay_DpDn(day, month, year)
                .enterEmail_TxtFd(email2)
                .enterCompany_TxtFd(company)
                .newsLetterOptions_ChkBx(checkBoxNewsLetter)
                .enterPassword_TxtFd(password)
                .enterConfirmPassword_TxtFd(password)
                .clickOn_RegisterButton();
        driver.verifyThat()
                .element( RegisterPage.register_SuccessMessage()).text()
                .contains(expectedResult_RegisterProcess)
                .withCustomReportMessage("Assert that the new account created By Get Success Message text of 'Register' process")
                .perform();
    }

    @Story("S1_As a guest, I want to Sign Up Via Email")
    @Test(description = "RE_001_Verify the Guest Can Register via Valid Data")
    @Description("Given the browser is open, When the guest navigate to Home Page, And click on sign in linkText" +
            "And navigate to create account page, And Add new account registration data, Then navigate to Home page Again")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("CBV2-2")
    @Issue("CBV2-102")
    public void RE_001_GuestRegister_viaValidEmail3() {
        String gender = register_TD.getTestData("Gender");
        String firstName = register_TD.getTestData("FirstName");
        String lastName = register_TD.getTestData("LastName");
        String day = register_TD.getTestData("Day");
        String month = register_TD.getTestData("Month");
        String year = register_TD.getTestData("Year");
        String email3 = register_TD.getTestData("Email3");
        String password = register_TD.getTestData("Password");
        String company = register_TD.getTestData("Company");
        String checkBoxNewsLetter = register_TD.getTestData("NewsLetter");
        String expectedResult_RegisterProcess = register_TD.getTestData("ExpectedResult_AlertMessage");
        new HomePage(driver).navigateTo_HomePage()
                .openRegister_Page()
                .chooseGender_RdBtn(gender)
                .enterFirstName_TxtFd(firstName)
                .enterLastName_TxtFd(lastName)
                .chooseBirthDay_DpDn(day, month, year)
                .enterEmail_TxtFd(email3)
                .enterCompany_TxtFd(company)
                .newsLetterOptions_ChkBx(checkBoxNewsLetter)
                .enterPassword_TxtFd(password)
                .enterConfirmPassword_TxtFd(password)
                .clickOn_RegisterButton();
        driver.verifyThat()
                .element( RegisterPage.register_SuccessMessage()).text()
                .contains(expectedResult_RegisterProcess)
                .withCustomReportMessage("Assert that the new account created By Get Success Message text of 'Register' process")
                .perform();
    }
}
