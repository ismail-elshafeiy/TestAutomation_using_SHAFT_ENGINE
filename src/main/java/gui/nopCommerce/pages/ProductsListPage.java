package gui.nopCommerce.pages;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsListPage {
    // driver
    private SHAFT.GUI.WebDriver driver;

    public ProductsListPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    // Elements Locators
    private By product_searchResult = By.xpath("//*[@href='/apple-icam'and@title='Show details for Apple iCam']");

    /////////////////////////////////////////////////////////////////
    //////////////////  Business Actions ////////////////////////////
    /////////////////////////////////////////////////////////////////
    @Step("Open Product details")
    public WishlistPage openProductDetails_Page() {
        driver.element().click( product_searchResult);
        return new WishlistPage(driver);
    }


}
