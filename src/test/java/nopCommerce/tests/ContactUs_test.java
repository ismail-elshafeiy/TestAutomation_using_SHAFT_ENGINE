package nopCommerce.tests;

import io.qameta.allure.*;
import gui.nopCommerce.pages.HomePage;
import gui.nopCommerce.pages.ContactUsPage;
import nopCommerce.tests.BaseTest;
import org.testng.annotations.Test;

@Epic("EP2_HomeList Module")
@Feature("GUI")
public class ContactUs_test extends BaseTest {

    @Story("S5_As a guest, I want to Contact with Admin")
    @Test(description = "CO_001_Verify the Guest can Contact with Admin")
    @Description("Given the browser is open, When the guest navigate to Home Page, And click on contact us" +
            "And navigate to contact us page, And Add user data, Then navigate to Home page Again")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void CO_001_guestCanContactWithAdmin() {
        String fullName = contactUs_TD.getTestData("FullName");
        String email = contactUs_TD.getTestData("Email");
        String enquiry = contactUs_TD.getTestData("Enquiry");
        String expectedResult_successMessage = contactUs_TD.getTestData("ExpectedResult_successMessage");
        new HomePage(driver).navigateTo_HomePage()
                .navigateToContactUs_Page()
                .enterFullName_TxtFd(fullName)
                .enterEmail_TxtFd(email)
                .enterEnquiry_TxtFd(enquiry)
                .clickOn_SubmitButton();
        driver.verifyThat().element(ContactUsPage.successMessage_contactUsProcess()).text()
                .contains(expectedResult_successMessage)
                .withCustomReportMessage("Assert that the guest contact Admin By Get success message text of contactUs process")
                .perform();
    }

}