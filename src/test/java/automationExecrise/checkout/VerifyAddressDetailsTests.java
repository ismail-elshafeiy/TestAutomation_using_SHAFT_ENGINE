package automationExecrise.checkout;


import api.Apis;
import api.ApisAccountManagement;
import com.shaft.driver.SHAFT;
import gui.automationExecrise.*;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Automation Exercise")
@Feature("Checkout Process")
@Story("Verify Address Details on Checkout Page")
public class VerifyAddressDetailsTests {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.API api;
    private SHAFT.TestData.JSON testData;
    private String timeStamp;

    // Test Cases
    @TmsLink("55512505")
    @Test(description = "Verify address details in checkout page")
    @Description("Given I open Automation Exercise home, And I Verify that home page is visible successfully, And I Click 'Signup / Login' button, And I Fill all details in Signup and create account, And I Verify 'ACCOUNT CREATED!' and click 'Continue' button, And I Verify ' Logged in as username' at top, And I Add products to cart, And I Click 'Cart' button, And I Verify that cart page is displayed, And I Click Proceed To Checkout, And I Verify that the delivery address is same address filled at the time registration of account, And I Verify that the billing address is same address filled at the time registration of account, Click 'Delete Account' button, Then Addresses should be the same as the time of registration, And Account should be deleted successfully")
    public void verifyAddressDetailsInCheckoutPage() {
        new NavigationBarPage(driver)
                .clickOnSignupLoginLink();
        new SignupLoginPage(driver)
                .validateOnSignUpVisibility(testData.getTestData("Messages.Signup"))
                .newUserSignup(testData.getTestData("RegisterData.UserName"), testData.getTestData("RegisterData.UserMail") + timeStamp + "@gizasystems.com");
        new SignupPage(driver)
                .validateOnAccountInfoPage(testData.getTestData("Messages.AccountInfo"))
                .enterAccountInformation(testData.getTestData("RegisterData.Gender"), testData.getTestData("RegisterData.UserPassword"), testData.getTestData("RegisterData.UserFirstName"), testData.getTestData("RegisterData.UserLastName"), testData.getTestData("RegisterData.UserBirthDay"), testData.getTestData("RegisterData.UserBirthMonth"), testData.getTestData("RegisterData.UserBirthYear"))
                .enterAddressInformation(testData.getTestData("RegisterData.UserAddress1"), testData.getTestData("RegisterData.UserCountry"), testData.getTestData("RegisterData.UserState"), testData.getTestData("RegisterData.UserCity"), testData.getTestData("RegisterData.UserZipCode"), testData.getTestData("RegisterData.UserMobile"))
                .validateOnAccountCreated(testData.getTestData("Messages.AccountCreated"))
                .clickOnContinueButton();
        new NavigationBarPage(driver)
                .validateTheLoggedInUser(testData.getTestData("RegisterData.UserName"));
        new ProductQuantityPage(driver)
                .clickOnViewProduct()
                .addProductToCart()
                .clickOnCart()
                .refreshCartPage();
        new CartPage(driver)
                .proceedToCheckOut();
        new CheckOutPage(driver)
                .verifyDeliveryAddressDetails(testData.getTestData("RegisterData.UserState"), testData.getTestData("RegisterData.UserCity"), testData.getTestData("RegisterData.UserZipCode"))
                .verifyBillingAddressDetails(testData.getTestData("RegisterData.UserState"), testData.getTestData("RegisterData.UserCity"), testData.getTestData("RegisterData.UserZipCode"));
        new NavigationBarPage(driver)
                .clickOnDeleteAccountLink();
        new DeleteAccountPage(driver)
                .validateAccountDeleted(testData.getTestData("Messages.AccountDeleted"));
    }

    @TmsLink("55512505")
    @Test(description = "Verify address details in checkout page - APIs")
    @Description("Given a user account is created with specific address details and verified through API, When the user logs in and navigates through adding a product to the cart and proceeding to checkout, Then the delivery and billing address details are verified on the checkout page to match the registered information. Finally, the user account is deleted via API, ensuring the account's deletion is validated and the user is no longer found.")
    public void verifyAddressDetailsInCheckoutPageApis() {
        new ApisAccountManagement(api)
                .createRegisterUserAccount(testData.getTestData("RegisterData.UserName"), testData.getTestData("RegisterData.UserMailApi") + timeStamp + "@gizasystems.com", testData.getTestData("RegisterData.UserPassword"), testData.getTestData("RegisterData.UserFirstName"), testData.getTestData("RegisterData.UserLastName"), testData.getTestData("RegisterData.UserZipCode"), testData.getTestData("RegisterData.UserState"), testData.getTestData("RegisterData.UserCity"))
                .validateUserCreatedRegistered();
        new NavigationBarPage(driver)
                .clickOnSignupLoginLink();
        new SignupLoginPage(driver)
                .registeredUserLogin(testData.getTestData("RegisterData.UserMailApi") + timeStamp + "@gizasystems.com", testData.getTestData("RegisterData.UserPassword"));
        new NavigationBarPage(driver)
                .validateTheLoggedInUser(testData.getTestData("RegisterData.UserName"));
        new ProductQuantityPage(driver)
                .clickOnViewProduct()
                .addProductToCart()
                .clickOnCart()
                .refreshCartPage();
        new CartPage(driver)
                .proceedToCheckOut();
        new CheckOutPage(driver)
                .verifyDeliveryAddressDetails(testData.getTestData("RegisterData.UserState"), testData.getTestData("RegisterData.UserCity"), testData.getTestData("RegisterData.UserZipCode"))
                .verifyBillingAddressDetails(testData.getTestData("RegisterData.UserState"), testData.getTestData("RegisterData.UserCity"), testData.getTestData("RegisterData.UserZipCode"));
        new ApisAccountManagement(api)
                .deleteUserAccount(testData.getTestData("RegisterData.UserMailApi") + timeStamp + "@gizasystems.com", testData.getTestData("RegisterData.UserPassword"))
                .validateDeleteUser()
                .validateUserNotFound(testData.getTestData("RegisterData.UserMailApi") + timeStamp + "@gizasystems.com");
    }

    //////////////////// Configurations \\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("VerifyAddressDetailsTestsTestData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        api = new SHAFT.API(Apis.apisBaseUrl);
        driver = new SHAFT.GUI.WebDriver();
        new HomePage(driver)
                .navigate()
                .validateOnVisibilityOfHomePage();
        timeStamp = String.valueOf(System.currentTimeMillis());
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}

