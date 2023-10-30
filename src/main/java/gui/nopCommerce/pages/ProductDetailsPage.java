package gui.nopCommerce.pages;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductDetailsPage {
    private SHAFT.GUI.WebDriver driver;

    public ProductDetailsPage(SHAFT.GUI.WebDriver driver) {
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
    public ShoppingCartPage addProduct_ToCart() {
        driver.element().click(addToCart_Btn);
        return new ShoppingCartPage(driver);
    }
    @Step("Add product to Wishlist")
    public WishlistPage addProduct_ToWishlist() {
        driver.element().click( addToWishlist_Btn);
        return new WishlistPage(driver);
    }

    @Step("Add product to Compare List")
    public CompareListPage addProduct_ToCompareList() {
        driver.element().click(addToCompareList_Btn);
        return new CompareListPage(driver);
    }

    @Step("Navigate Email a friend Page")
    public EmailFriendPage openEmailFriend_Page() {
        driver.element().click(emailFriend_Btn);
        return new EmailFriendPage(driver);
    }
}