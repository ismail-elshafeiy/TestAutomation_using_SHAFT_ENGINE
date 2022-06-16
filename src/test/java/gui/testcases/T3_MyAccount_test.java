package gui.testcases;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.*;
import nopCommerce.pages.gui.P1_HomeList_Page;
import nopCommerce.pages.gui.P3_Login_Page;
import nopCommerce.pages.gui.P4_MyAccount_Page;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("EP1_User Module")
@Feature("GUI")
public class T3_MyAccount_test {
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> login_TD = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> register_TD = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> myAccount_TD = new ThreadLocal<>();

    @BeforeMethod
    public void setUp_BeforeMethod() {
        driver.set(DriverFactory.getDriver());
        register_TD.set(new JSONFileManager(System.getProperty("registerUserJson")));
        login_TD.set(new JSONFileManager(System.getProperty("loginJson")));
        myAccount_TD.set(new JSONFileManager(System.getProperty("myAccountJson")));

    }

    @AfterMethod
    public void tearDown_AfterMethod(ITestResult result) {
        BrowserActions.closeCurrentWindow(driver.get());
    }

    @Story("S3_As a user, I want to Edit My Account")
    @Test(description = "MA_001_Verify the User can Change password")
    @Description("Given the browser is open, When Registered user navigate to MyAccount Page" +
            "And navigate to Change password page, And Add New My account data, Then navigate to Home page Again")
    @Severity(SeverityLevel.MINOR)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void MA_001_user_changeMyPassword() {
        String email = register_TD.get().getTestData("Email");
        String password = register_TD.get().getTestData("Password");
        String newPassword = register_TD.get().getTestData("NewPassword");
        String expectedResult_ChangeMyPassword = myAccount_TD.get().getTestData("ExpectedResult_ChangeMyPassword");
        new P1_HomeList_Page(driver.get()).navigateTo_HomePage()
                .openLogin_Page()
                .loginViaEmail(email, password);
        new P1_HomeList_Page(driver.get()).navigateTo_HomePage()
                .openMyAccount_Page()
                .openChangeMyPassword_Page()
                .enterOLdPassword_TxtFd(password)
                .enterNewPassword_TxtFd(newPassword)
                .enterConfirmPassword_TxtFd(newPassword);
        Validations.assertThat().element(driver.get(), P4_MyAccount_Page.passwordWasChanged())
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
        String email = register_TD.get().getTestData("Email");
        String newPassword = register_TD.get().getTestData("NewPassword");
        String expectedResult_LoginProcess = login_TD.get().getTestData("ExpectedResult_LoginProcess");
        new P1_HomeList_Page(driver.get()).navigateTo_HomePage()
                .openLogin_Page()
                .loginViaEmail(email, newPassword);
        Validations.assertThat().element(driver.get(), P3_Login_Page.myAccount_txt()).text()
                .contains(expectedResult_LoginProcess)
                .withCustomReportMessage("Assert that the user logged in And Get My account text")
                .perform();
    }
}
