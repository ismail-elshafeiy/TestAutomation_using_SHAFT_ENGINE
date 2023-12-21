package nopCommerce.tests;

import io.qameta.allure.*;
import gui.nopCommerce.pages.HomePage;
import gui.nopCommerce.pages.RegisterPage;
import gui.nopCommerce.pages.ProductDetailsPage;
import gui.nopCommerce.pages.EmailFriendPage;
import nopCommerce.tests.BaseTest;
import org.testng.annotations.Test;

@Epic("EP3_ProductDetails")
@Feature("GUI")
public class ProductDetails_test extends BaseTest {


    @Story("S1_As a guest, I want to Sign Up Via Email")
    @Test( description = "RE_001_Guest Can Register via Email with Valid Data")
    @Description("Given the browser is open, When the guest navigate to Home Page, And click on sign in linkText" +
            "And navigate to create account page, And Add new account registration data, Then navigate to Home page Again")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void guestRegister_viaValidEmail() {
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
        driver.verifyThat()
                .element(RegisterPage.register_SuccessMessage()).text()
                .contains(expectedResult_RegisterProcess)
                .withCustomReportMessage("Assert that the new account created By Get Success Message text of 'Register' process")
                .perform();
    }


    @Story("S3_As a guest, I want to Add Product to cart")
    @Test(description = "PD_001_Verify the guest can Add Product to Cart")
    @Description("Given the browser is open, When the guest navigate to Home Page, And Search by product name" +
            "And navigate to product details page, And Add Product to Cart")
    @Severity(SeverityLevel.MINOR)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void guestCan_Add_ProductToCart() {
        String productName3 = home_TD.getTestData("ProductName3");
        String numberOfProduct_searchList = home_TD.getTestData("NumberOfProduct");
        String expectedResult_addToCartSuccess = productDetails_TD.getTestData("SuccessMessage_AddToCart");
        new HomePage(driver).navigateTo_HomePage()
                .searchOfProduct(productName3)
                .openProductDetails_fromSearchList(numberOfProduct_searchList)
                .addProduct_ToCart();
        driver.verifyThat().element(ProductDetailsPage.addToCart_SuccessMessage).text()
                .contains(expectedResult_addToCartSuccess)
                .withCustomReportMessage("Assert that the new product Added to cart By Get Success Message text of 'Add Product' process")
                .perform();

    }

    @Story("S3_As a guest, I want to Add Product to Wishlist")
    @Test(description = "PD_002_Verify the guest can Add Product to Wishlist")
    @Description("Given the browser is open, When the guest navigate to Home Page, And click on sign in linkText" +
            "And navigate to create account page, And Add new account registration data, Then navigate to Home page Again")
    @Severity(SeverityLevel.MINOR)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void guestCan_Add_ProductToWishlist() {
        String productName3 = home_TD.getTestData("ProductName3");
        String numberOfProduct_searchList = home_TD.getTestData("NumberOfProduct");
        String expectedResult_addToWishlistSuccess = productDetails_TD.getTestData("SuccessMessage_addToWishlist");
        new HomePage(driver).navigateTo_HomePage()
                .searchOfProduct(productName3)
                .openProductDetails_fromSearchList(numberOfProduct_searchList)
                .addProduct_ToWishlist();
        driver.verifyThat().element(ProductDetailsPage.addToWishlist_SuccessMessage).text()
                .contains(expectedResult_addToWishlistSuccess)
                .withCustomReportMessage("Assert that the new product Added to wishlist By Get Success Message text of 'Add wishlist' process")
                .perform();

    }

    @Story("S5_As a user, I Want to Send Product to my friend via Email")
    @Test(description = "PD_003_Verify the User can Send the Product By Email to his friend")
    @Description("Given the browser is open, And the User Logged in, When the user navigate to Product Details Page, And click on Email a friend" +
            "And Send Email to Friend, Then Friend receive email contain this Product")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void userCan_Send_ProductToFriend() {
        String email = register_TD.getTestData("Email");
        String newPassword = register_TD.getTestData("NewPassword");
        String productName = home_TD.getTestData("ProductName");
        String friendEmail = productDetails_TD.getTestData("FriendEmail");
        String personalMessage = productDetails_TD.getTestData("PersonalMessage");
        String expectedResult_EmailFriendSuccess = productDetails_TD.getTestData("ExpectedResult_EmailFriendSuccess");
        new HomePage(driver).navigateTo_HomePage()
                .openLogin_Page()
                .loginViaEmail(email, newPassword)
                .searchOfProduct(productName)
                .openSearchResults()
                .openProductDetails_Page();
        new ProductDetailsPage(driver)
                .openEmailFriend_Page()
                .enterFriendEmail_TxtFd(friendEmail)
                .enterPersonalMessage_TxtFd(personalMessage)
                .clickOn_SendButton();
        driver.verifyThat().element(EmailFriendPage.messageSuccess_Txt()).text()
                .contains(expectedResult_EmailFriendSuccess)
                .withCustomReportMessage("Assert that the product send to friend By Get Success Message text of '' process")
                .perform();

    }


}
