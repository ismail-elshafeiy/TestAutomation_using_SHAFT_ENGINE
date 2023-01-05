package gui.nopCommerce.pages;

import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P5_ProductsList_Page {
    // driver
    private WebDriver driver;

    // Constructor
    public P5_ProductsList_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Elements Locators
    private By product_searchResult = By.xpath("//*[@href='/apple-icam'and@title='Show details for Apple iCam']");

    /////////////////////////////////////////////////////////////////
    //////////////////  Business Actions ////////////////////////////
    /////////////////////////////////////////////////////////////////

    @Step("Open Product details")
    public P12_Wishlist_Page openProductDetails_Page() {
        ElementActions.click(driver, product_searchResult);
        return new P12_Wishlist_Page(driver);
    }
}
