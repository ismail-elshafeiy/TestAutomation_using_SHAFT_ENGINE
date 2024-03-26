package nopCommerce.tests;

import io.qameta.allure.*;
import gui.nopCommerce.pages.HomePage;
import gui.nopCommerce.pages.LoginPage;
import gui.nopCommerce.pages.MyAccountPage;
import nopCommerce.tests.BaseTest;
import org.testng.annotations.Test;

@Epic("EP1_User Module")
@Feature("GUI")
public class MyAccount_test extends BaseTest {

    @Story("S3_As a user, I want to Edit My Account")
    @Test(description = "MA_001_Verify the User can Change password")
    @Description("Given the browser is open, When Registered user navigate to MyAccount Page" +
            "And navigate to Change password page, And Add New My account data, Then navigate to Home page Again")
    @Severity(SeverityLevel.MINOR)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void MA_001_user_changeMyPassword() {
        String newPassword = register_TD.getTestData("NewPassword");
        String expectedResult_ChangeMyPassword = myAccount_TD.getTestData("ExpectedResult_ChangeMyPassword");
        new HomePage(driver).navigateTo_HomePage()
                .openLogin_Page()
                .loginViaEmail(email, password);
        new HomePage(driver).navigateTo_HomePage()
                .openMyAccount_Page()
                .openChangeMyPassword_Page()
                .enterOLdPassword_TxtFd(password)
                .enterNewPassword_TxtFd(newPassword)
                .enterConfirmPassword_TxtFd(newPassword);
       driver.verifyThat().element( MyAccountPage.passwordWasChanged())
                .text().contains(expectedResult_ChangeMyPassword)
                .withCustomReportMessage("Assert that the user logged in And Get My account text")
                .perform();
    }

    @Story("S3_As a user, I want to Edit My Account")
    @Test(dependsOnMethods = "MA_001_user_changeMyPassword",
            description = "MA_002_Verify the User can Login via newPassword after changed it")
    @Description("Given the browser is open, When Registered user navigate to Login Page" +
            "And logging via New Password data, Then navigate to Home page Again")
    @Severity(SeverityLevel.MINOR)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void MA_002_UserLogin_viaNewPassword() {
        String newPassword = register_TD.getTestData("NewPassword");
        String expectedResult_LoginProcess = login_TD.getTestData("ExpectedResult_LoginProcess");
        new HomePage(driver).navigateTo_HomePage()
                .openLogin_Page()
                .loginViaEmail(email, newPassword);
        driver.verifyThat().element( LoginPage.myAccount_txt()).text()
                .contains(expectedResult_LoginProcess)
                .withCustomReportMessage("Assert that the user logged in And Get My account text")
                .perform();
    }
}
