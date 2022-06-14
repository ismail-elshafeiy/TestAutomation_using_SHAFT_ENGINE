package testcases;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.*;
import nopCommerce.pages.gui.P1_HomeList_Page;
import nopCommerce.pages.gui.P3_Login_Page;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("EP1_User Module")
@Feature("GUI")
public class T2_Login_test {
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> login_TD = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> register_TD = new ThreadLocal<>();

    @BeforeMethod
    public void setUp_BeforeMethod() {
        driver.set(DriverFactory.getDriver());
        register_TD.set(new JSONFileManager(System.getProperty("registerUserJson")));
        login_TD.set(new JSONFileManager(System.getProperty("loginJson")));
    }

    @AfterMethod
    public void tearDown_AfterMethod(ITestResult result) {
        BrowserActions.closeCurrentWindow(driver.get());
    }

    @Story("S2_As a User, I want to Login via Email")
    @Test(description = "LO_001_Verify the User can Login via Valid data")
    @Description("Given the browser is open, When the user navigate to Home Page, And click on Login linkText" +
            "And navigate to Login page, And Add Login data, Then navigate to Home page Again")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void LO_001_UserLogin_viaValidEmail() {
        String email = register_TD.get().getTestData("Email");
        String password = register_TD.get().getTestData("Password");
        String state = login_TD.get().getTestData("RememberMe");
        String expectedResult_LoginProcess = login_TD.get().getTestData("ExpectedResult_LoginProcess");
        new P1_HomeList_Page(driver.get()).navigateTo_HomePage()
                .openLogin_Page()
                .selectRememberMe_ChkBx(state)
                .loginViaEmail(email, password);
        Validations.assertThat().element(driver.get(), P3_Login_Page.myAccount_txt()).text()
                .contains(expectedResult_LoginProcess)
                .withCustomReportMessage("Assert that the user logged in By Get My account text")
                .perform();
    }
}