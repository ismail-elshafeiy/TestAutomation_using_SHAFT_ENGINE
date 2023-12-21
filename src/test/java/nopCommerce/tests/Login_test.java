package nopCommerce.tests;

import io.qameta.allure.*;
import gui.nopCommerce.pages.HomePage;
import gui.nopCommerce.pages.LoginPage;
import nopCommerce.tests.BaseTest;
import org.testng.annotations.Test;

@Epic("EP1_User Module")
@Feature("GUI")
public class Login_test extends BaseTest {


    @Story("S2_As a User, I want to Login via Email")
    @Test(description = "LO_001_Verify the User can Login via Valid data")
    @Description("Given the browser is open, When the user navigate to Home Page, And click on Login linkText" +
            "And navigate to Login page, And Add Login data, Then navigate to Home page Again")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void LO_001_UserLogin_viaValidEmail() {
        String email = register_TD.getTestData("Email");
        String password = register_TD.getTestData("Password");
        String state = login_TD.getTestData("RememberMe");
        String expectedResult_LoginProcess = login_TD.getTestData("ExpectedResult_LoginProcess");
        new HomePage(driver).navigateTo_HomePage()
                .openLogin_Page()
                .selectRememberMe_ChkBx(state)
                .loginViaEmail(email, password);
       driver.verifyThat()
                .element( LoginPage.myAccount_txt()).text()
                .contains(expectedResult_LoginProcess)
                .withCustomReportMessage("Assert that the user logged in By Get My account text")
                .perform();
    }
}