package automationExecrise.login;

import api.Apis;
import api.ApisAccountManagement;
import com.shaft.driver.SHAFT;
import gui.automationExecrise.HomePage;
import gui.automationExecrise.NavigationBarPage;
import gui.automationExecrise.SignupLoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Automation Exercise")
@Feature("User Management")
@Story("Login")
public class LoginWithCorrectEmailAndPasswordTests {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.API api;
    private SHAFT.TestData.JSON testData;
    private String timeStamp;

    // Test Cases
    @TmsLink("55512292")
    @Test(description = "Login With Correct Email and Password Test - Register and Delete user with APIs ")
    @Description("Given that I am a registered user, When I enter correct email, And Correct Password , And I Clicked on Login button And I clicked on delete user, Then I should be Logged in successfully to the system, And user be deleted from the system")
    public void loginWithCorrectEmailAndPassword() {
        new ApisAccountManagement(api)
                .createRegisterUserAccount(testData.getTestData("UserName"), testData.getTestData("UserMail.ApiTimeStamp") + timeStamp + "@gizasystems.com", testData.getTestData("UserPassword"), testData.getTestData("UserFirstName"), testData.getTestData("UserLastName"))
                .validateUserCreatedRegistered();
        new NavigationBarPage(driver)
                .clickOnSignupLoginLink();
        new SignupLoginPage(driver)
                .validateOnLoginVisibility(testData.getTestData("Messages.Login"))
                .registeredUserLogin(testData.getTestData("UserMail.ApiTimeStamp") + timeStamp + "@gizasystems.com", testData.getTestData("UserPassword"));
        new NavigationBarPage(driver)
                .validateTheLoggedInUser(testData.getTestData("UserName"));
        new ApisAccountManagement(api)
                .deleteUserAccount(testData.getTestData("UserMail.ApiTimeStamp") + timeStamp + "@gizasystems.com", testData.getTestData("UserPassword"))
                .validateDeleteUser()
                .validateUserNotFound(testData.getTestData("UserMail.ApiTimeStamp") + timeStamp + "@gizasystems.com");
    }

    //////////////////// Configurations \\\\\\\\\\\\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("LoginWithCorrectEmailAndPasswordTestsTestData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        timeStamp = String.valueOf(System.currentTimeMillis());
        api = new SHAFT.API(Apis.apisBaseUrl);
        driver = new SHAFT.GUI.WebDriver();
        new HomePage(driver)
                .navigate()
                .validateOnVisibilityOfHomePage();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
