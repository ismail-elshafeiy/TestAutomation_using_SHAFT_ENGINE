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
    public void verifySearch_ResizeWindow() {
        driver.get().browser().setWindowSize(600, 466);
        new Google_Page(driver.get()).navigateTo_googlePage()
                .searchByTextAndIndexList("Selenium WebDriver.get(");
        By searchResult_txt = By.xpath("//div[@id='result-stats']");
        var getSearchResults = driver.get().element().getText(searchResult_txt);
        System.out.println("Search results --> " + getSearchResults);
        Assert.assertNotEquals(getSearchResults, "");
    }

    @Test(groups = "Firefox")
    public void searchForFourthResult_RunTest_FireFox() {

        String searchKeyword = excelFileTestDataReader.get().getCellData("sheet2", "search", "Data2");
        String indexInList = "1";
        String indexInPage = "4";
        String expectedResult_searchResult = "TestNG Tutorial";
        new Google_Page(driver.get()).navigateTo_googlePage()
                .searchByTextAndIndexList(searchKeyword, indexInList);
//Validations.assertThat().element(
//						SearchResults_Page.getSearchResultsNumber(indexInPage)).text()
//				.contains(expectedResult_searchResult)
//				.perform();
//        Validations.assertThat().element(driver.get().getDriver.get((),
//                        SearchResults_Page.getSearchResultsNumber(indexInPage)).text()
//                .contains(expectedResult_searchResult)
//                .perform();
    }

    private ThreadLocal<SHAFT.TestData.EXCEL> excelFileTestDataReader = new ThreadLocal<>();

    @BeforeClass
    public void beforeClass() {
        excelFileTestDataReader.set(new SHAFT.TestData.EXCEL(System.getProperty("testDataFolderPath") + "testData.xlsx"));
    }

}
