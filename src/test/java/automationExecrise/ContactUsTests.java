package automationExecrise;

import com.shaft.driver.SHAFT;
import gui.automationExecrise.ContactUsPage;
import gui.automationExecrise.HomePage;
import gui.automationExecrise.NavigationBarPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Automation Exercise")
@Feature("Contact Us Functionality")
@Story("Submit Contact Us Form")
public class ContactUsTests {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    // Test Cases
    @TmsLink("55512348")
    @Test(description = "Verify the functionality of the Contact Us form")
    @Description("Given that I click on contact Us Link, When I enter valid data, And press Submit , Then The message submitted")
    public void contactUs() {
        new NavigationBarPage(driver)
                .clickOnContactUsLink();
        new ContactUsPage(driver)
                .validateOnContactUsPage()
                .enterContactUsInformation(testData.getTestData("Name"),testData.getTestData("Email"),testData.getTestData("Subject"),testData.getTestData("MessageTxt"),"src/test/resources/filesTobeUploaded/customerInfo.docx")
                .clickOnSubmitButton()
                .validateOnContactInfoSubmitted(testData.getTestData("Messages.SubmittedMsg"));
    }

    //////////////////// Configurations \\\\\\\\\\\\\\\\\\\\
    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        new HomePage(driver)
                .navigate()
                .validateOnVisibilityOfHomePage();
    }

    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("ContactUsTestsTestData.json");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
