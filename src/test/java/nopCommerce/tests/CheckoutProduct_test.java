package nopCommerce.tests;

import io.qameta.allure.*;
import gui.nopCommerce.pages.CheckoutPage;
import gui.nopCommerce.pages.HomePage;
import gui.nopCommerce.pages.RegisterPage;
import gui.nopCommerce.pages.ProductDetailsPage;
import org.testng.annotations.Test;

public class CheckoutProduct_test extends BaseTest {


    @Story("S1_As a guest,I want to Sign Up Via Email")
    @Test(enabled = false, description = "RE_001_Verify the Guest Can Register via Valid Data")
    @Description("Given the browser is open, When the guest navigate to Home Page, And click on sign in linkText" +
            "And navigate to create account page, And Add new account registration data, Then navigate to Home page Again")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("CBV2-2")
    @Issue("CBV2-102")
    public void RE_001_GuestRegister_viaValidEmail() {
        String firstName = register_TD.getTestData("FirstName");
        String lastName = register_TD.getTestData("LastName");
        String email = register_TD.getTestData("Email");
        String newPassword = register_TD.getTestData("NewPassword");
        String expectedResult_RegisterProcess = register_TD.getTestData("ExpectedResult_AlertMessage");
        new HomePage(driver).navigateTo_HomePage()
                .openRegister_Page()
                .enterFirstName_TxtFd(firstName)
                .enterLastName_TxtFd(lastName)
                .enterEmail_TxtFd(email)
                .enterPassword_TxtFd(newPassword)
                .enterConfirmPassword_TxtFd(newPassword)
                .clickOn_RegisterButton();
        driver.verifyThat().element( RegisterPage.register_SuccessMessage()).text()
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
        String productName3 = home_TD.getTestData("ProductName3");
        String numberOfProduct_searchList = home_TD.getTestData("NumberOfProduct");
        String expectedResult_addToCartSuccess = productDetails_TD.getTestData("SuccessMessage_AddToCart");
        new HomePage(driver).navigateTo_HomePage()
                .openLogin_Page()
                .loginViaEmail(email, password)
                .searchOfProduct(productName3)
                .openProductDetails_fromSearchList(numberOfProduct_searchList)
                .addProduct_ToCart();
        driver.verifyThat().element( ProductDetailsPage.addToCart_SuccessMessage).text()
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
        String email = register_TD.getTestData("Email");
        String newPassword = register_TD.getTestData("NewPassword");
        String state = checkout_TD.getTestData("State");
        String country = checkout_TD.getTestData("Country");
        String city = checkout_TD.getTestData("City");
        String address1 = checkout_TD.getTestData("Address1");
        String postalCode = checkout_TD.getTestData("PostalCode");
        String phoneNumber = checkout_TD.getTestData("PhoneNumber");
        int shippingMethod = Integer.parseInt(checkout_TD.getTestData("ShippingOrder"));
        int paymentMethod = Integer.parseInt(checkout_TD.getTestData("PaymentOrder"));
        String expectedResult_CheckoutProcess = checkout_TD.getTestData("ExpectedResult_CheckoutProcess");
        new HomePage(driver).navigateTo_HomePage()
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
        driver.verifyThat()
                .element( CheckoutPage.success_checkoutMessage_txt)
                .text().contains(expectedResult_CheckoutProcess)
                .withCustomReportMessage("")
                .perform();

    }


}
