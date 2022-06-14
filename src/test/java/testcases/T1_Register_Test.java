package testcases;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.*;
import nopCommerce.pages.gui.P1_HomeList_Page;
import nopCommerce.pages.gui.P2_Register_Page;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Helper;

@Epic("EP1_User Module")
@Feature("GUI")
public class T1_Register_Test {
    // check
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> register_TD = new ThreadLocal<>();

    private String currentTime = Helper.getCurrentTime("ddMMyyHHmmssSS");

    @BeforeMethod
    public void setUp_BeforeMethod() {
        driver.set(DriverFactory.getDriver());
        register_TD.set(new JSONFileManager(System.getProperty("registerUserJson")));
    }

    @AfterMethod
    public void tearDown_AfterMethod(ITestResult result) {
        BrowserActions.closeCurrentWindow(driver.get());

    }


    @Story("S1_As a guest, I want to Sign Up Via Email")
    @Test(description = "RE_001_Verify the Guest Can Register via Valid Data")
    @Description("Given the browser is open, When the guest navigate to Home Page, And click on sign in linkText" +
            "And navigate to create account page, And Add new account registration data, Then navigate to Home page Again")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("CBV2-2")
    @Issue("CBV2-102")
    public void RE_001_GuestRegister_viaValidEmail() {
        String gender = register_TD.get().getTestData("Gender");
        String firstName = register_TD.get().getTestData("FirstName");
        String lastName = register_TD.get().getTestData("LastName");
        String day = register_TD.get().getTestData("Day");
        String month = register_TD.get().getTestData("Month");
        String year = register_TD.get().getTestData("Year");
        String email = register_TD.get().getTestData("Email");
        String password = register_TD.get().getTestData("Password");
        String company = register_TD.get().getTestData("Company");
        String checkBoxNewsLetter = register_TD.get().getTestData("NewsLetter");
        String expectedResult_RegisterProcess = register_TD.get().getTestData("ExpectedResult_AlertMessage");

        new P1_HomeList_Page(driver.get()).navigateTo_HomePage()
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
        Validations.assertThat()
                .element(driver.get(), P2_Register_Page.register_SuccessMessage()).text()
                .contains(expectedResult_RegisterProcess)
                .withCustomReportMessage("Assert that the new account created By Get Success Message text of 'Register' process")
                .perform();
    }

    @Story("S1_As a guest, I want to Sign Up Via Email")
    @Test( description = "RE_001_Verify the Guest Can Register via Valid Data")
    @Description("Given the browser is open, When the guest navigate to Home Page, And click on sign in linkText" +
            "And navigate to create account page, And Add new account registration data, Then navigate to Home page Again")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("CBV2-2")
    @Issue("CBV2-102")
    public void RE_001_GuestRegister_viaValidEmail1() {
        String gender = register_TD.get().getTestData("Gender");
        String firstName = register_TD.get().getTestData("FirstName");
        String lastName = register_TD.get().getTestData("LastName");
        String day = register_TD.get().getTestData("Day");
        String month = register_TD.get().getTestData("Month");
        String year = register_TD.get().getTestData("Year");
        String email1 = register_TD.get().getTestData("Email1");
        String password = register_TD.get().getTestData("Password");
        String company = register_TD.get().getTestData("Company");
        String checkBoxNewsLetter = register_TD.get().getTestData("NewsLetter");
        String expectedResult_RegisterProcess = register_TD.get().getTestData("ExpectedResult_AlertMessage");
        new P1_HomeList_Page(driver.get()).navigateTo_HomePage()
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
        Validations.assertThat()
                .element(driver.get(), P2_Register_Page.register_SuccessMessage()).text()
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
        String gender = register_TD.get().getTestData("Gender");
        String firstName = register_TD.get().getTestData("FirstName");
        String lastName = register_TD.get().getTestData("LastName");
        String day = register_TD.get().getTestData("Day");
        String month = register_TD.get().getTestData("Month");
        String year = register_TD.get().getTestData("Year");
        String email2 = register_TD.get().getTestData("Email2");
        String password = register_TD.get().getTestData("Password");
        String company = register_TD.get().getTestData("Company");
        String checkBoxNewsLetter = register_TD.get().getTestData("NewsLetter");
        String expectedResult_RegisterProcess = register_TD.get().getTestData("ExpectedResult_AlertMessage");
        new P1_HomeList_Page(driver.get()).navigateTo_HomePage()
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
        Validations.assertThat()
                .element(driver.get(), P2_Register_Page.register_SuccessMessage()).text()
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
        String gender = register_TD.get().getTestData("Gender");
        String firstName = register_TD.get().getTestData("FirstName");
        String lastName = register_TD.get().getTestData("LastName");
        String day = register_TD.get().getTestData("Day");
        String month = register_TD.get().getTestData("Month");
        String year = register_TD.get().getTestData("Year");
        String email3 = register_TD.get().getTestData("Email3");
        String password = register_TD.get().getTestData("Password");
        String company = register_TD.get().getTestData("Company");
        String checkBoxNewsLetter = register_TD.get().getTestData("NewsLetter");
        String expectedResult_RegisterProcess = register_TD.get().getTestData("ExpectedResult_AlertMessage");
        new P1_HomeList_Page(driver.get()).navigateTo_HomePage()
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
        Validations.assertThat()
                .element(driver.get(), P2_Register_Page.register_SuccessMessage()).text()
                .contains(expectedResult_RegisterProcess)
                .withCustomReportMessage("Assert that the new account created By Get Success Message text of 'Register' process")
                .perform();
    }

}
