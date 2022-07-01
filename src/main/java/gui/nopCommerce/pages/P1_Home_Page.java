package gui.nopCommerce.pages;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class P1_Home_Page {
    // driver
    private WebDriver driver;

    // Constructor
    public P1_Home_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Home URL  ...
    private final String baseUrl = System.getProperty("homeUrl");
    // Elements Locators
    private By register_linkTxt = By.cssSelector("a.ico-register");
    private final By login_linkTxt = By.linkText("Log in");
    private final By wishlist_linkTxt = By.linkText("Wishlist");
    private final By shoppingCart_linkTxt = By.linkText("Shopping cart");
    private By myAccount_linkTxt = By.cssSelector("a.ico-account");
    private By search_txt = By.xpath("//*[@id='small-searchterms']");
    private By search_btn = By.cssSelector("button.button-1.search-box-button");
    private By productsList_list = By.tagName("span");
    private By contactUs_link = By.xpath("//a[contains(text(),'Contact us')]");

    public static By categoryName_pageTitle() {
        return By.xpath("//div[@class='page-title']");
    }

    private By inputSearchKeyWord(String searchResult) {
        return By.xpath("//span[contains(text(),'" + searchResult + "')]");
    }

    private By inputNumberOfProduct_SearchList(String arrangeNumber) {
        return By.xpath("//li[contains(@class,'ui-menu-item')][" + arrangeNumber + "]");
    }

    private By currency_dropDown = By.id("customerCurrency");

/*    private By category_list(String category) {
        return By.xpath("//ul[contains(@class,'top-menu notmobile')]['" + category + "']");
    }

    private By subCategory_list(String subCategory) {
        return By.xpath("//ul[contains(@class,'sublist first-level')]['" + subCategory + "']");
    }*/

    private By category_menu = By.linkText("Computers");

    private By subCategory_menu = By.linkText("Notebooks");
    /////////////////////////////////////////////////////////////////
    //////////////////  Business Actions ////////////////////////////
    /////////////////////////////////////////////////////////////////

    /**
     * Navigate to Home Page
     *
     * @return self reference
     */
    @Step("Navigate to Home Page")
    public P1_Home_Page navigateTo_HomePage() {
        BrowserActions.navigateToURL(driver, baseUrl);
        
        return this;
    }


    @Step("Navigate to Register Page")
    public P2_Register_Page openRegister_Page() {
        ElementActions.click(driver, register_linkTxt);
        return new P2_Register_Page(driver);
    }

    @Step("Navigate to Login Page")
    public P3_Login_Page openLogin_Page() {
        ElementActions.click(driver, login_linkTxt);
        return new P3_Login_Page(driver);
    }

    @Step("Navigate to Wishlist Page")
    public P12_Wishlist_Page openWishlist_Page() {
        ElementActions.click(driver, wishlist_linkTxt);
        return new P12_Wishlist_Page(driver);
    }

    @Step("Navigate to Shopping cart Page")
    public P11_ShoppingCart_Page openShoppingCart_Page() {
        ElementActions.click(driver, shoppingCart_linkTxt);
        return new P11_ShoppingCart_Page(driver);
    }

    @Step("Navigate to My account Page")
    public P4_MyAccount_Page openMyAccount_Page() {
        ElementActions.click(driver, myAccount_linkTxt);
        return new P4_MyAccount_Page(driver);
    }

    @Step("Get the text of Register After logout")
    public String getRegisterLink() {
        return ElementActions.getText(driver, register_linkTxt);
    }

    @Step("Search of product Name [{productName}]")
    public P1_Home_Page searchOfProduct(String productName) {
        ElementActions.type(driver, search_txt, productName);
        return this;
    }

    @Step("Open product Name --> [{searchKeyWord}] from List of Search")
    public P8_ProductDetails_Page openProductDetails_fromSearch(String searchKeyWord) {
        ElementActions.click(driver, inputSearchKeyWord(searchKeyWord));
        return new P8_ProductDetails_Page(driver);
    }

    @Step("Open product order --> [{arrangeNumber}] in the list")
    public P8_ProductDetails_Page openProductDetails_fromSearchList(String arrangeNumber) {
        ElementActions.click(driver, inputNumberOfProduct_SearchList(arrangeNumber));
        return new P8_ProductDetails_Page(driver);
    }

    @Step("click on Search Button")
    public P5_ProductsList_Page openSearchResults() {
        ElementActions.click(driver, search_btn);
        return new P5_ProductsList_Page(driver);
    }

    @Step("Navigate to Contact Us Page")
    public P7_ContactUsPage navigateToContactUs_Page() {
        ElementActions.click(driver, contactUs_link);
        return new P7_ContactUsPage(driver);
    }

    @Step("Change Currency from Home Page: --> [{currencyName}]")
    public P1_Home_Page changeCurrency(String currencyName) {
        ElementActions.select(driver, currency_dropDown, currencyName);
        return this;
    }

    @Step("Hover of the Category from Menu")
    public P1_Home_Page selectCategoryFromMenuAndClickOn() {
        /*        ElementActions.hover(driver, category_list(category));*/
        ElementActions.hoverAndClick(driver, category_menu, subCategory_menu);
        return this;
    }

}

