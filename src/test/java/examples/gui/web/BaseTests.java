package examples.gui.web;

import com.shaft.driver.DriverFactory;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    public ThreadLocal<SHAFT.GUI.WebDriver> driver = new ThreadLocal<>();

    //public SHAFT.GUI.WebDriver driver;
    public ThreadLocal<SHAFT.TestData.EXCEL> excelReader = new ThreadLocal<>();
    public ThreadLocal<SHAFT.TestData.JSON> jsonReader = new ThreadLocal<>();


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
