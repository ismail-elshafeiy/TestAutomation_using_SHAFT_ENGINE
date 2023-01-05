package testcases.web;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.*;
import gui.nopCommerce.pages.P14_Checkout_Page;
import gui.nopCommerce.pages.P1_Home_Page;
import gui.nopCommerce.pages.P2_Register_Page;
import gui.nopCommerce.pages.P8_ProductDetails_Page;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T7_CheckoutProduct_Test {
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> home_TD = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> register_TD = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> productDetails_TD = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> checkout_TD = new ThreadLocal<>();

    @BeforeMethod
    public void setUp_BeforeMethod() {
        driver.set(DriverFactory.getDriver());
        home_TD.set(new JSONFileManager(System.getProperty("homeJson")));
        register_TD.set(new JSONFileManager(System.getProperty("registerUserJson")));
        productDetails_TD.set(new JSONFileManager(System.getProperty("productDetailsJson")));
        checkout_TD.set(new JSONFileManager(System.getProperty("checkoutJson")));

    }

    @AfterMethod
    public void tearDown_AfterMethod(ITestResult result) {
        BrowserActions.closeCurrentWindow(driver.get());
    }

    @Story("S1_As a guest,I want to Sign Up Via Email")
    @Test(enabled = false, description = "RE_001_Verify the Guest Can Register via Valid Data")
    @Description("Given the browser is open, When the guest navigate to Home Page, And click on sign in linkText" +
            "And navigate to create account page, And Add new account registration data, Then navigate to Home page Again")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("CBV2-2")
    @Issue("CBV2-102")
    public void RE_001_GuestRegister_viaValidEmail() {
        String firstName = register_TD.get().getTestData("FirstName");
        String lastName = register_TD.get().getTestData("LastName");
        String email = register_TD.get().getTestData("Email");
        String newPassword = register_TD.get().getTestData("NewPassword");
        String expectedResult_RegisterProcess = register_TD.get().getTestData("ExpectedResult_AlertMessage");
        new P1_Home_Page(driver.get()).navigateTo_HomePage()
                .openRegister_Page()
                .enterFirstName_TxtFd(firstName)
                .enterLastName_TxtFd(lastName)
                .enterEmail_TxtFd(email)
                .enterPassword_TxtFd(newPassword)
                .enterConfirmPassword_TxtFd(newPassword)
                .clickOn_RegisterButton();
        Validations.assertThat()
                .element(driver.get(), P2_Register_Page.register_SuccessMessage()).text()
                .contains(expectedResult_RegisterProcess)
                .withCustomReportMessage("Assert that the new account created By Get Success Message text of 'Register' process")
                .perform();
    }

    @Story("S3_As a guest, I want to Add Product to cart")
    @Test(description = "SE_005_Verify the guest can Add Product to Cart")
    @Description("Given the browser is open, When the guest navigate to Home Page, And Search by product name" +
            "And navigate to product details page, And Add Product to Cart")
    @Severity(SeverityLevel.MINOR)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void PD_001_UserCan_Add_ProductToCart() {
        String email = register_TD.get().getTestData("Email");
        String newPassword = register_TD.get().getTestData("NewPassword");
        String productName3 = home_TD.get().getTestData("ProductName3");
        String numberOfProduct_searchList = home_TD.get().getTestData("NumberOfProduct");
        String expectedResult_addToCartSuccess = productDetails_TD.get().getTestData("SuccessMessage_AddToCart");
        new P1_Home_Page(driver.get()).navigateTo_HomePage()
                .openLogin_Page()
                .loginViaEmail(email, newPassword)
                .searchOfProduct(productName3)
                .openProductDetails_fromSearchList(numberOfProduct_searchList)
                .addProduct_ToCart();
        Validations.assertThat().element(driver.get(), P8_ProductDetails_Page.addToCart_SuccessMessage).text()
                .contains(expectedResult_addToCartSuccess)
                .withCustomReportMessage("Assert that the new account created By Get Success Message text of 'Register' process")
                .perform();

    }

    @Story("S6_As a User, I want to Checkout of a Product")
    @Test(dependsOnMethods = "PD_001_UserCan_Add_ProductToCart",
            description = "SE_005_User can Checkout Product")
    @Description("user can Checkout Product")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void Ch_001_UserCan_Checkout_Product_from_Cart() {
        String email = register_TD.get().getTestData("Email");
        String newPassword = register_TD.get().getTestData("NewPassword");
        String state = checkout_TD.get().getTestData("State");
        String country = checkout_TD.get().getTestData("Country");
        String city = checkout_TD.get().getTestData("City");
        String address1 = checkout_TD.get().getTestData("Address1");
        String postalCode = checkout_TD.get().getTestData("PostalCode");
        String phoneNumber = checkout_TD.get().getTestData("PhoneNumber");
        int shippingMethod = Integer.parseInt(checkout_TD.get().getTestData("ShippingOrder"));
        int paymentMethod = Integer.parseInt(checkout_TD.get().getTestData("PaymentOrder"));
        String expectedResult_CheckoutProcess = checkout_TD.get().getTestData("ExpectedResult_CheckoutProcess");
        new P1_Home_Page(driver.get()).navigateTo_HomePage()
                .openLogin_Page()
                .loginViaEmail(email, newPassword)
                .openShoppingCart_Page()
                .checkAgreeTermsService_ChkBx(state)
                .clickOn_checkOutButton()
                .enterAddress(country, city, address1, postalCode)
                .enterPhoneNumber(phoneNumber)
                .clickOn_ContinueButton_address()
//                .clickOn_groundRadio()
//                .setOrderNumber_ShippingMethodList(shippingMethod)
                .clickOn_ContinueButton_Shipping()
//                .setOrderNumber_paymentMethodList(paymentMethod)
                .clickOn_ContinueButton_payment()
                .clickOn_ContinueButton_info()
                .clickOn_ConfirmOrderButton();
        Validations.assertThat()
                .element(driver.get(), P14_Checkout_Page.success_checkoutMessage_txt)
                .text().contains(expectedResult_CheckoutProcess)
                .withCustomReportMessage("")
                .perform();

    }


}
