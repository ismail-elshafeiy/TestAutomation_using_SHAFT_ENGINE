package nopCommerce.tests;

import io.qameta.allure.*;
import gui.nopCommerce.pages.HomePage;
import gui.nopCommerce.pages.ProductDetailsPage;
import nopCommerce.tests.BaseTest;
import org.testng.annotations.Test;

@Epic("EP2_HomeList Module")
@Feature("GUI")
public class HomeList_test extends BaseTest {

    @Story("S1_As a guest, I want to Hover of Category from Menu")
    @Test(description = "Verify the guest can hover of SubCategory from Menu")
    @Description("Given the browser is open, When the guest navigate to Home Page, And Hover on Category Menu" +
            "And Click on SubCategory, And Add Login data, Then navigate to Products list of the sub category")
    @Severity(SeverityLevel.MINOR)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void HL_001_UserCan_Hover_SubCategoryFromMenu() {
        String subCategoryName = home_TD.getTestData("SubCategoryName");
        new HomePage(driver).navigateTo_HomePage()
                .selectCategoryFromMenuAndClickOn();
        driver.verifyThat().element(HomePage.categoryName_pageTitle())
                .text().contains(subCategoryName)
                .withCustomReportMessage("Assert that the guest opened category And Get subcategory text")
                .perform();
    }

    @Story("S2_As a guest, I Want to Search of Product")
    @Test(description = "HL_002_Verify the guest can Search of specific Product name By name")
    @Description("Given the browser is open, When the guest navigate to Home Page, And Hover on Category Menu" +
            "And Click on SubCategory, And Add Login data, Then navigate to Products list of the sub category")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void HL_002_searchOfProductName_specificProduct() {
        String productName = home_TD.getTestData("ProductName");
        new HomePage(driver).navigateTo_HomePage()
                .searchOfProduct(productName)
                .openSearchResults()
                .openProductDetails_Page();
        driver.verifyThat().element(ProductDetailsPage.productName_details())
                .text().contains(productName)
                .withCustomReportMessage("Assert that the guest opened category By Get subcategory text")
                .perform();
    }

    @Story("S2_As a guest, I Want to Search of Product")
    @Test(dependsOnMethods = "HL_002_searchOfProductName_specificProduct",
            description = "HL_003_Verify the guest can Search of Product name By Auto Complete and select one")
    @Description("Given the browser is open, When the guest navigate to Home Page, And Search of product" +
            "And select by name, Then navigate to Products Details page")
    @Severity(SeverityLevel.MINOR)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void HL_003_searchOfProductName_AutoComplete() {
        String productName2 = home_TD.getTestData("ProductName2");
        new HomePage(driver).navigateTo_HomePage()
                .searchOfProduct(productName2)
                .openProductDetails_fromSearch(productName2);
        driver.verifyThat().element(ProductDetailsPage.productName_details())
                .text().contains(productName2)
                .withCustomReportMessage("Assert that the guest opened product details By Get Product name text")
                .perform();
    }

    @Story("S2_As a guest, I Want to Search of Product")
    @Test(dependsOnMethods = "HL_003_searchOfProductName_AutoComplete",
            description = "HL_004_Verify the guest can Search of Product name via Arrangement of the Search result list")
    @Description("Given the browser is open, When the guest navigate to Home Page, And Search of product" +
            "And select by order list, Then navigate to Products Details page")
    @Severity(SeverityLevel.MINOR)
    @Link("https://demo.nopcommerce.com/")
    @TmsLink("Tc_002")
    @Issue("Bug_002")
    public void HL_004_searchOfProductName_Arrangement() {
        String productName3 = home_TD.getTestData("ProductName3");
        String numberOfProduct_searchList = home_TD.getTestData("NumberOfProduct");
        new HomePage(driver).navigateTo_HomePage()
                .searchOfProduct(productName3)
                .openProductDetails_fromSearchList(numberOfProduct_searchList);
        driver.verifyThat().element(ProductDetailsPage.productName_details())
                .text().contains(productName3)
                .withCustomReportMessage("Assert that the guest opened product details By Get Product name text")
                .perform();

    }


}

