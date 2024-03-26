package examples.files;

import com.shaft.driver.SHAFT;
import examples.gui.web.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TestDataDriven extends BaseTests {
	private By usernameField = By.id("username");
	private By passwordField = By.id("password");
	private By loginButton = By.cssSelector("#login button");

	@Test (groups = "approach1")
	public void login_readDataFromExcelFile () {
		driver.get().browser().navigateToURL("https://the-internet.herokuapp.com/login");
		driver.get().element().type(usernameField, excelReader.get().getCellData("Login Data2","email1","email"));
		driver.get().element().type(passwordField, excelReader.get().getCellData("Login Data2","email1","password"));
		driver.get().element().click(loginButton);
	}
	@BeforeClass
	public void setTestData () {
		excelReader.set(new SHAFT.TestData.EXCEL(System.getProperty("testDataFolderPath")+"LoginData.xlsx"));
	}
}
