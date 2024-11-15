package automationExecrise;

import com.shaft.driver.SHAFT;
import gui.automationExecrise.CategoriesBarPage;
import gui.automationExecrise.HomePage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Automation Exercise")
@Feature("Category Products")
@Story("View Category Products")
public class ViewCategoryProductsTests {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    // Test Cases
    @Issue("16")
    @TmsLink("55512457")
    @Test(description = "View Category Products")
    @Description("Given that user want to view main Category and subcategory Products, When user click on main Category and select subcategory, Then user should be navigated to that subcategory page")
    public void viewCategoryProductsTestGui() {
        new CategoriesBarPage(driver)
                .clickOnCategoryLink(testData.getTestData("MainCategory.womanCategory"))
                .clickOnSubCategoryLink(testData.getTestData("MainCategory.womanCategory"), testData.getTestData("SubCategories.womanSubCategory"));
        new HomePage(driver)
                .validateOnVisibilityOfCategoryTitle(testData.getTestData("womanCategoryTitle"));
        new CategoriesBarPage(driver)
                .clickOnCategoryLink(testData.getTestData("MainCategory.menCategory"))
                .clickOnSubCategoryLink(testData.getTestData("MainCategory.menCategory"), testData.getTestData("SubCategories.menSubCategory"));
        new HomePage(driver)
                .validateOnVisibilityOfCategoryTitle(testData.getTestData("menCategoryTitle"));
    }

    //////////////////// Configurations \\\\\\\\\\\\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("ViewCategoryProductsTestsTestData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        new HomePage(driver)
                .navigate()
                .validateOnVisibilityOfHomePage();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}