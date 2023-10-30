package testcases.web;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import gui.nopCommerce.pages.HomePage;
import gui.nopCommerce.pages.RegisterPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public SHAFT.GUI.WebDriver driver;
    public SHAFT.TestData.JSON home_TD;
    public SHAFT.TestData.JSON register_TD;
    public SHAFT.TestData.JSON login_TD;
    public SHAFT.TestData.JSON myAccount_TD;
    public SHAFT.TestData.JSON contactUs_TD;
    public SHAFT.TestData.JSON productDetails_TD;
    public SHAFT.TestData.JSON checkout_TD;

    @BeforeClass(description = "Before Suite - Setup test data")
    public void readTestBaseData() {
        home_TD = new SHAFT.TestData.JSON(System.getProperty("homeJson"));
        register_TD = new SHAFT.TestData.JSON(System.getProperty("registerUserJson"));
        login_TD = new SHAFT.TestData.JSON(System.getProperty("loginJson"));
        myAccount_TD = new SHAFT.TestData.JSON(System.getProperty("myAccountJson"));
        contactUs_TD=new SHAFT.TestData.JSON(System.getProperty("contactUsJson"));
        productDetails_TD=new SHAFT.TestData.JSON(System.getProperty("productDetailsJson"));
        checkout_TD=new SHAFT.TestData.JSON(System.getProperty("checkoutJson"));
    }

    @BeforeMethod(description = "Before Method - Initialize browser")
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @AfterMethod(description = "After Method - Close browser")
    public void tearDown() {
        driver.browser().capturePageSnapshot();
        driver.browser().captureSnapshot();
        driver.quit();
    }
}
