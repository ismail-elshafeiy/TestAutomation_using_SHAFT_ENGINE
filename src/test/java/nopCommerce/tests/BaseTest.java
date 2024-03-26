package nopCommerce.tests;

import com.shaft.cli.FileActions;
import com.shaft.cli.TerminalActions;
import com.shaft.driver.DriverFactory;
import com.shaft.driver.SHAFT;
import gui.nopCommerce.pages.HomePage;
import org.testng.annotations.*;
import utils.FakerData;

public class BaseTest {
    public SHAFT.GUI.WebDriver driver;
    public SHAFT.TestData.JSON home_TD;
    public SHAFT.TestData.JSON register_TD;
    public SHAFT.TestData.JSON login_TD;
    public SHAFT.TestData.JSON myAccount_TD;
    public SHAFT.TestData.JSON contactUs_TD;
    public SHAFT.TestData.JSON productDetails_TD;
    public SHAFT.TestData.JSON checkout_TD;
    public static String email, password;

    @BeforeSuite(description = "Before Suite - Register via new user")
    public void registerNewUser() {
        driver = new SHAFT.GUI.WebDriver(DriverFactory.DriverType.CHROME);
        email = FakerData.getEmail();
        password = FakerData.getPassword();
        new HomePage(driver)
                .navigateTo_HomePage()
                .openRegister_Page()
                .registerWithRequired(email, password);
        driver.quit();
    }

    @BeforeClass(description = "Before Class - Setup test data")
    public void readTestBaseData() {
        home_TD = new SHAFT.TestData.JSON(System.getProperty("homeJson"));
        register_TD = new SHAFT.TestData.JSON(System.getProperty("registerUserJson"));
        login_TD = new SHAFT.TestData.JSON(System.getProperty("loginJson"));
        myAccount_TD = new SHAFT.TestData.JSON(System.getProperty("myAccountJson"));
        contactUs_TD = new SHAFT.TestData.JSON(System.getProperty("contactUsJson"));
        productDetails_TD = new SHAFT.TestData.JSON(System.getProperty("productDetailsJson"));
        checkout_TD = new SHAFT.TestData.JSON(System.getProperty("checkoutJson"));
    }

    @BeforeMethod(description = "Before Method - Initialize browser")
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver(DriverFactory.DriverType.CHROME);
    }

    @AfterMethod(description = "After Method - Close browser")
    public void tearDown() {
        //SHAFT.Properties.performance.set().isEnabled(true);
        driver.browser().capturePageSnapshot();
        driver.browser().captureSnapshot();
        driver.quit();
    }

    @AfterSuite(description = "After Suite - Close browser")
    public void generateAllureReportHTM() {
        // TerminalActions.getInstance().performTerminalCommand("allure generate --single-file allure-results -o allure-report");
        // TerminalActions.getInstance().performTerminalCommand("allure serve allure-results");
    }
}
