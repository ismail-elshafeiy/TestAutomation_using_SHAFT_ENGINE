package gui.testcases;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.*;
import gui.nopCommerce.pages.P1_Home_Page;
import gui.nopCommerce.pages.P2_Register_Page;
import gui.nopCommerce.pages.P8_ProductDetails_Page;
import gui.nopCommerce.pages.P9_EmailFriendPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("EP3_ProductDetails")
@Feature("GUI")
public class T6_ProductDetails_test {

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> home_TD = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> productDetails_TD = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> register_TD = new ThreadLocal<>();


    @BeforeMethod
    public void setUp_BeforeMethod() {
        driver.set(DriverFactory.getDriver());
        home_TD.set(new JSONFileManager(System.getProperty("homeJson")));
        productDetails_TD.set(new JSONFileManager(System.getProperty("productDetailsJson")));
        register_TD.set(new JSONFileManager(System.getProperty("registerUserJson")));
    }

    @AfterMethod
    public void tearDown_AfterMethod(ITestResult result) {
        BrowserActions.closeCurrentWindow(driver.get());
    }


    @Story("S1_As a guest, I want to Sign Up Via Email")
    @Test(enabled = false, description = "RE_001_Guest Can Register via Email with Valid Data")
    @Description("Given the browser is open, When the guest navigate to Home Page, And click on sign in linkText" +
            "And navigate to create account page, And Add new account registration data, Then navigate to Home page Again")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
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
    @Test(description = "PD_001_Verify the guest can Add Product to Cart")
    @Description("Given the browser is open, When the guest navigate to Home Page, And Search by product name" +
            "And navigate to product details page, And Add Product to Cart")
    @Severity(SeverityLevel.MINOR)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void PD_001_guestCan_Add_ProductToCart() {
        String productName3 = home_TD.get().getTestData("ProductName3");
        String numberOfProduct_searchList = home_TD.get().getTestData("NumberOfProduct");
        String expectedResult_addToCartSuccess = productDetails_TD.get().getTestData("SuccessMessage_AddToCart");
        new P1_Home_Page(driver.get()).navigateTo_HomePage()
                .searchOfProduct(productName3)
                .openProductDetails_fromSearchList(numberOfProduct_searchList)
                .addProduct_ToCart();
        Validations.assertThat().element(driver.get(), P8_ProductDetails_Page.addToCart_SuccessMessage).text()
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
    public void PD_002_guestCan_Add_ProductToWishlist() {
        String productName3 = home_TD.get().getTestData("ProductName3");
        String numberOfProduct_searchList = home_TD.get().getTestData("NumberOfProduct");
        String expectedResult_addToWishlistSuccess = productDetails_TD.get().getTestData("SuccessMessage_addToWishlist");
        new P1_Home_Page(driver.get()).navigateTo_HomePage()
                .searchOfProduct(productName3)
                .openProductDetails_fromSearchList(numberOfProduct_searchList)
                .addProduct_ToWishlist();
        Validations.assertThat().element(driver.get(), P8_ProductDetails_Page.addToWishlist_SuccessMessage).text()
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
    public void PD_003_UserCan_Send_ProductToFriend() {
        String email = register_TD.get().getTestData("Email");
        String newPassword = register_TD.get().getTestData("NewPassword");
        String productName = home_TD.get().getTestData("ProductName");
        String friendEmail = productDetails_TD.get().getTestData("FriendEmail");
        String personalMessage = productDetails_TD.get().getTestData("PersonalMessage");
        String expectedResult_EmailFriendSuccess = productDetails_TD.get().getTestData("ExpectedResult_EmailFriendSuccess");
        new P1_Home_Page(driver.get()).navigateTo_HomePage()
                .openLogin_Page()
                .loginViaEmail(email, newPassword)
                .searchOfProduct(productName)
                .openSearchResults()
                .openProductDetails_Page();
        new P8_ProductDetails_Page(driver.get())
                .openEmailFriend_Page()
                .enterFriendEmail_TxtFd(friendEmail)
                .enterPersonalMessage_TxtFd(personalMessage)
                .clickOn_SendButton();
        Validations.assertThat().element(driver.get(), P9_EmailFriendPage.messageSuccess_Txt()).text()
                .contains(expectedResult_EmailFriendSuccess)
                .withCustomReportMessage("Assert that the product send to friend By Get Success Message text of '' process")
                .perform();

    }


}
