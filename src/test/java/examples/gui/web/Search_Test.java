package examples.gui.web;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import gui.examples.Google_Page;
import gui.examples.SearchResults_Page;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Search_Test extends BaseTests {

	@Test(groups = "Chrome")
	public void verifySearch_ResizeWindow () {
		driver.browser().setWindowSize(600, 466);
		new Google_Page(driver).navigateTo_googlePage()
				.searchByTextAndIndexList("Selenium WebDriver");
		By searchResult_txt = By.xpath("//div[@id='result-stats']");
		var getSearchResults = driver.getDriver().findElement(searchResult_txt).getText();
		System.out.println("Search results --> " + getSearchResults);
		Assert.assertNotEquals(getSearchResults, "");
	}

	@Test(groups = "Firefox")
	public void searchForFourthResult_RunTest_FireFox () {

		String searchKeyword = excelFileTestDataReader.getCellData("sheet2","search","Data2");
		String indexInList = "1";
		String indexInPage = "4";
		String expectedResult_searchResult = "TestNG Tutorial";
		new Google_Page(driver).navigateTo_googlePage()
				.searchByTextAndIndexList(searchKeyword, indexInList);

		Validations.assertThat().element(driver.getDriver(),
						SearchResults_Page.getSearchResultsNumber(indexInPage)).text()
				.contains(expectedResult_searchResult)
				.perform();
	}

	private SHAFT.TestData.EXCEL excelFileTestDataReader;

	@BeforeClass
	public void beforeClass () {
		excelFileTestDataReader = new SHAFT.TestData.EXCEL(System.getProperty("testDataFolderPath") + "testData.xlsx");
	}

}
