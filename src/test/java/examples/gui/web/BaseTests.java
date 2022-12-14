package examples.gui.web;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
	public SHAFT.GUI.WebDriver driver;

	@BeforeMethod
	public void setUp () {
		driver = new SHAFT.GUI.WebDriver();
	}

	@AfterMethod
	public void tearDown () {
		driver.quit();
	}
}
