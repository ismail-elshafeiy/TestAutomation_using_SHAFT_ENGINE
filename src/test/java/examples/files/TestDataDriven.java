package examples.files;

import com.shaft.driver.SHAFT;
import examples.gui.web.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestDataDriven extends BaseTests {
	private By usernameField = By.id("username");
	private By passwordField = By.id("password");
	private By loginButton = By.cssSelector("#login button");

	@Test (groups = "approach1")
	public void login_readDataFromExcelFile () {
		driver.browser().navigateToURL("https://the-internet.herokuapp.com/login");
		driver.element().type(usernameField, excelReader.getCellData("Login Data2","email1","email"));
		driver.element().type(passwordField, excelReader.getCellData("Login Data2","email1","password"));
		driver.element().click(loginButton);
	}
	@BeforeClass
	public void setTestData () {
		excelReader = new SHAFT.TestData.EXCEL(System.getProperty("testDataFolderPath")+"LoginData.xlsx");
	}
}
