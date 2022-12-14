package testcases.web;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.*;
import gui.nopCommerce.pages.P1_Home_Page;
import gui.nopCommerce.pages.P7_ContactUsPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("EP2_HomeList Module")
@Feature("GUI")
public class T5_ContactUs_test {
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> contactUs_TD = new ThreadLocal<>();

    @BeforeMethod
    public void setUp_BeforeMethod() {
        driver.set(DriverFactory.getDriver());
        contactUs_TD.set(new JSONFileManager(System.getProperty("contactUsJson")));
    }

    @AfterMethod
    public void tearDown_AfterMethod(ITestResult result) {BrowserActions.closeCurrentWindow(driver.get());}

    @Story("S5_As a guest, I want to Contact with Admin")
    @Test(description = "CO_001_Verify the Guest can Contact with Admin")
    @Description("Given the browser is open, When the guest navigate to Home Page, And click on contact us" +
            "And navigate to contact us page, And Add user data, Then navigate to Home page Again")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void CO_001_guestCanContactWithAdmin() {
        String fullName = contactUs_TD.get().getTestData("FullName");
         String email = contactUs_TD.get().getTestData("Email");
         String  enquiry = contactUs_TD.get().getTestData("Enquiry");
         String expectedResult_successMessage = contactUs_TD.get().getTestData("ExpectedResult_successMessage");
        new P1_Home_Page(driver.get()).navigateTo_HomePage()
                .navigateToContactUs_Page()
                .enterFullName_TxtFd(fullName)
                .enterEmail_TxtFd(email)
                .enterEnquiry_TxtFd(enquiry)
                .clickOn_SubmitButton();
        Validations.assertThat().element(driver.get(), P7_ContactUsPage.successMessage_contactUsProcess()).text()
                .contains(expectedResult_successMessage)
                .withCustomReportMessage("Assert that the guest contact Admin By Get success message text of contactUs process")
                .perform();
    }

}