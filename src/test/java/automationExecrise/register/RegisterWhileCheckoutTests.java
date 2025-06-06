package automationExecrise.register;
import com.shaft.driver.SHAFT;
import gui.automationExecrise.*;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Automation")
@Feature("Place Order")
@Story("Register while checkout")
public class RegisterWhileCheckoutTests {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    private String timeStamp;

    // Test Cases
    @TmsLink("55512419")
    @Test(description = "Verify placing an order with registration during checkout")
    @Description("Given I open Automation Exercise home, When I navigate to Recommended Products, And I add Product to Cart, And I click on Cart button , And I proceed to checkout, And I click on Register /Login button, And I Fill all data and Create account, And I Verify Account is created, And I Verify ' Logged in as username' at top, And I .Click 'Cart' button, And I Click 'Proceed To Checkout' button, And I Verify Address Details and Review Your Order, And I Enter description in comment text area and click 'Place Order' , And I Enter payment details: Name on Card, Card Number, CVC, Expiration date, And I Click 'Pay and Confirm Order' button, And I Verify success message 'Order Placed!', And I Click 'Delete Account' button, And I Verify 'ACCOUNT DELETED!', And click 'Continue' button")
    public void registerWhileCheckoutTest() {
        new RecommendedSectionPage(driver)
                .openRecommendedSection()
                .verifyRecommendedSectionVisibility()
                .addToCart(testData.getTestData("ProductDetails.productName"))
                .verifyProductAddedToCart(testData.getTestData("Messages.ProductAddedMessage"));
        new CartPage(driver)
                .openCart()
                .verifyCartPageIsLoaded()
                .verifyProductAddedToCart(testData.getTestData("ProductDetails.productName"))
                .proceedToCheckOut();
        new RegisterWhileCheckoutPage(driver)
                .verifyCheckoutPopUpDisplayed(testData.getTestData("Messages.CheckoutBodyMessage"))
                .clickOnRegisterLoginBtn();
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
                .validateTheLoggedInUser(testData.getTestData("RegisterData.UserName"))
                .navigateToCartPage();
        new CartPage(driver)
                .verifyCartPageIsLoaded()
                .proceedToCheckOut();
        new RegisterWhileCheckoutPage(driver)
                .verifyCheckoutFullAddressDetails(testData.getTestData("RegisterData.UserAddress1"), testData.getTestData("RegisterData.UserState"), testData.getTestData("RegisterData.UserZipCode"))
                .verifyUserPhoneNumber(testData.getTestData("RegisterData.UserMobile"))
                .scrollToReviewOrderSection()
                .reviewCartProducts(testData.getTestData("ProductDetails.productName"))
                .typeOrderComments(testData.getTestData("OrderComment"))
                .clickOnPlaceOrderBtn();
        new PaymentPage(driver)
                .fillPaymentInformation(testData.getTestData("PaymentData.NameOnCard"),testData.getTestData("PaymentData.CardNumber"),testData.getTestData("PaymentData.CVC"),testData.getTestData("PaymentData.ExpiryMonth"),testData.getTestData("PaymentData.ExpiryYear"))
                .clickOnPayAndConfirmBtn()
                .verifySuccessMessage(testData.getTestData("Messages.OrderConfirmed"));
        new NavigationBarPage(driver)
                .clickOnDeleteAccountLink();
        new DeleteAccountPage(driver)
                .validateAccountDeleted(testData.getTestData("Messages.AccountDeleted"))
                .clickOnContinueBtn();
    }

    //////////////////// Configurations \\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("RegisterWhileCheckoutTestsTestData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
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
