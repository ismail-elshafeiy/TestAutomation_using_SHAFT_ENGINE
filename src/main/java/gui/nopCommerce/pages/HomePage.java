package gui.nopCommerce.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class HomePage {
    private final SHAFT.GUI.WebDriver driver;

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Home URL  ...
    private final String baseUrl = System.getProperty("nopCommerceBaseUrl");
    // Elements Locators
    private final By register_linkTxt = By.cssSelector("a.ico-register");
    private final By login_linkTxt = By.linkText("Log in");
    private final By wishlist_linkTxt = By.linkText("Wishlist");
    private final By shoppingCart_linkTxt = By.linkText("Shopping cart");
    private final By myAccount_linkTxt = By.cssSelector("a.ico-account");
    private final By search_txt = By.xpath("//*[@id='small-searchterms']");
    private final By search_btn = By.cssSelector("button.button-1.search-box-button");
    private final By productsList_list = By.tagName("span");
    private final By contactUs_link = By.xpath("//a[contains(text(),'Contact us')]");

    public static By categoryName_pageTitle() {
        return By.xpath("//div[@class='page-title']");
    }

    private By inputSearchKeyWord(String searchResult) {
        return By.xpath("//span[contains(text(),'" + searchResult + "')]");
    }

    private By inputNumberOfProduct_SearchList(String arrangeNumber) {
        return By.xpath("//li[contains(@class,'ui-menu-item')][" + arrangeNumber + "]");
    }

    private final By currency_dropDown = By.id("customerCurrency");

/*    private By category_list(String category) {
        return By.xpath("//ul[contains(@class,'top-menu notmobile')]['" + category + "']");
    }

    private By subCategory_list(String subCategory) {
        return By.xpath("//ul[contains(@class,'sublist first-level')]['" + subCategory + "']");
    }*/

    private final By category_menu = By.linkText("Computers");

    private final By subCategory_menu = By.linkText("Notebooks");
    /////////////////////////////////////////////////////////////////
    //////////////////  Business Actions ////////////////////////////
    /////////////////////////////////////////////////////////////////

    /**
     * Navigate to Home Page
     *
     * @return self reference
     */
    @Step("Navigate to Home Page")
    public HomePage navigateTo_HomePage() {
        driver.browser().navigateToURL(baseUrl);
        return this;
    }


    @Step("Navigate to Register Page")
    public RegisterPage openRegister_Page() {
        driver.element().click(register_linkTxt);
        return new RegisterPage(driver);
    }

    @Step("Navigate to Login Page")
    public LoginPage openLogin_Page() {
        driver.element().click(login_linkTxt);
        return new LoginPage(driver);
    }


    @Step("Navigate to Shopping cart Page")
    public ShoppingCartPage openShoppingCart_Page() {
        driver.element().click(shoppingCart_linkTxt);
        return new ShoppingCartPage(driver);
    }

    @Step("Navigate to My account Page")
    public MyAccountPage openMyAccount_Page() {
        driver.element().click(myAccount_linkTxt);
        return new MyAccountPage(driver);
    }

    @Step("Get the text of Register After logout")
    public String getRegisterLink() {
        return driver.element().getText(register_linkTxt);
    }

    @Step("Search of product Name [{productName}]")
    public HomePage searchOfProduct(String productName) {
        driver.element().type(search_txt, productName);
        return this;
    }

    @Step("Open product Name --> [{searchKeyWord}] from List of Search")
    public ProductDetailsPage openProductDetails_fromSearch(String searchKeyWord) {
        driver.element().click(inputSearchKeyWord(searchKeyWord));
        return new ProductDetailsPage(driver);
    }

    @Step("Open product order --> [{arrangeNumber}] in the list")
    public ProductDetailsPage openProductDetails_fromSearchList(String arrangeNumber) {
        driver.element().click(inputNumberOfProduct_SearchList(arrangeNumber));
        return new ProductDetailsPage(driver);
    }

    @Step("click on Search Button")
    public ProductsListPage openSearchResults() {
        driver.element().click(search_btn);
        return new ProductsListPage(driver);
    }

    @Step("Navigate to Contact Us Page")
    public ContactUsPage navigateToContactUs_Page() {
        driver.element().click(contactUs_link);
        return new ContactUsPage(driver);
    }

    @Step("Change Currency from Home Page: --> [{currencyName}]")
    public HomePage changeCurrency(String currencyName) {
        driver.element().select(currency_dropDown, currencyName);
        return this;
    }

    @Step("Hover of the Category from Menu")
    public HomePage selectCategoryFromMenuAndClickOn() {
        /*        driver.element().hover(driver, category_list(category));*/
        driver.element().hover(category_menu)
                .click(subCategory_menu);
        return this;
    }

}

