package gui.nopCommerce.pages;

import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P8_ProductDetails_Page {
    // driver
    private WebDriver driver;

    // Constructor
    public P8_ProductDetails_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Elements Locators
    public static By productName_details() {
        return By.xpath("//div[@class='product-name']");
    }

    public By productNameInProductDetails(String searchKeyWord) {
        return By.xpath("//h1[contains(text(),'" + searchKeyWord + "')]");
    }

    private By addToCart_Btn = By.xpath("//button[@id='add-to-cart-button-16']");

    private By addToWishlist_Btn = By.id("add-to-wishlist-button-16");
    private By addToCompareList_Btn = By.xpath("//button[@class='button-2 add-to-compare-list-button']");
    private By emailFriend_Btn = By.xpath("//button[@class='button-2 email-a-friend-button']");
    public static By addToCart_SuccessMessage = By.xpath("//div[contains(@class,'bar-notification success')][contains(.,'The product has been added to y')]");
    public static By addToWishlist_SuccessMessage = By.xpath("//div[contains(@class,'bar-notification success')][contains(.,'The product has been added to your')]");

    /////////////////////////////////////////////////////////////////
    //////////////////  Business Actions ////////////////////////////
    /////////////////////////////////////////////////////////////////

    @Step("Add product to Shopping Cart")
    public P11_ShoppingCart_Page addProduct_ToCart() {
        ElementActions.click(driver, addToCart_Btn);
        return new P11_ShoppingCart_Page(driver);
    }

    @Step("Add product to Wishlist")
    public P12_Wishlist_Page addProduct_ToWishlist() {
        ElementActions.click(driver, addToWishlist_Btn);
        return new P12_Wishlist_Page(driver);
    }

    @Step("Add product to Compare List")
    public P13_CompareList_Page addProduct_ToCompareList() {
        ElementActions.click(driver, addToCompareList_Btn);
        return new P13_CompareList_Page(driver);
    }

    @Step("Navigate Email a friend Page")
    public P9_EmailFriendPage openEmailFriend_Page() {
        ElementActions.click(driver, emailFriend_Btn);
        return new P9_EmailFriendPage(driver);
    }
}