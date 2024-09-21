package examples.gui.web;

import com.shaft.driver.DriverFactory;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTests {
    public ThreadLocal<SHAFT.GUI.WebDriver> driver = new ThreadLocal<>();

    //public SHAFT.GUI.WebDriver driver;
    public ThreadLocal<SHAFT.TestData.EXCEL> excelReader = new ThreadLocal<>();
    public ThreadLocal<SHAFT.TestData.JSON> jsonReader = new ThreadLocal<>();

    @BeforeSuite
    public void beforeSuite() {
        SHAFT.Properties.web.set().headlessExecution(false);
        SHAFT.Properties.timeouts.set().defaultElementIdentificationTimeout(30);
        SHAFT.Properties.allure.set()
                .automaticallyOpen(true)
                .customTitle("Test Automation Report");
        SHAFT.Properties.reporting.set().disableLogging(false);
        SHAFT.Properties.visuals.set()
                .videoParamsRecordVideo(false)
                .createAnimatedGif(false);
        SHAFT.Properties.flags.set()
                .retryMaximumNumberOfAttempts(0)
                .enableTrueNativeMode(true)
                .autoCloseDriverInstance(true);
        SHAFT.Properties.platform.set()
                .enableBiDi(false);
//                .driverProxySettings(true)
//                .jvmProxySettings(true);
    }

    @BeforeMethod
    public void setUp() {
        driver.set(new SHAFT.GUI.WebDriver(DriverFactory.DriverType.CHROME));
//		excelReader = new SHAFT.TestData.EXCEL(System.getProperty("testDataFolderPath")+"");

    }

    @AfterMethod
    public void tearDown() {
        driver.get().quit();
    }
}
