package examples.gui.web;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
	//public ThreadLocal<SHAFT.GUI.WebDriver> driver = new ThreadLocal<>();
	public SHAFT.GUI.WebDriver driver;
	public SHAFT.TestData.EXCEL excelReader;
	public SHAFT.TestData.JSON jsonReader;


	@BeforeMethod
	public void setUp () {

		driver = new SHAFT.GUI.WebDriver();
//		excelReader = new SHAFT.TestData.EXCEL(System.getProperty("testDataFolderPath")+"");

	}

	@AfterMethod
	public void tearDown () {
		driver.quit();
	}
}
