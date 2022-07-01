package gui.practices;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActions_Test {
    private WebDriver driver;

    @BeforeMethod(onlyForGroups = "Firefox")
    public void setUp_fireFox() {
        driver = DriverFactory.getDriver(DriverFactory.DriverType.DESKTOP_FIREFOX);
    }

    @BeforeMethod(onlyForGroups = "Chrome")
    public void setUp_BeforeMethod() {
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void tearDown_fireFox(ITestResult result) {
        BrowserActions.closeCurrentWindow(driver);
    }


    @Test(groups = "Chrome")
    public void verifySearch_ResizeWindow() {
        BrowserActions.setWindowSize(driver, 600, 466);
        new Google_Page(driver).navigateTo_googlePage()
                .searchByTextAndIndexList("Selenium WebDriver");
        By searchResult_txt = By.xpath("//div[@id='result-stats']");
        var getSearchResults = driver.findElement(searchResult_txt).getText();
        System.out.println("Search results --> " + getSearchResults);
        Assert.assertNotEquals(getSearchResults, "");
    }

    @Test(groups = "Firefox")
    public void searchForFourthResult_RunTest_FireFox() {

        String searchKeyword = "TestNG";
        String indexInList = "1";
        String indexInPage = "4";
        String expectedResult_searchResult = "TestNG Tutorial";
        new Google_Page(driver).navigateTo_googlePage()
                .searchByTextAndIndexList(searchKeyword, indexInList);
        Validations.assertThat().element(driver,
                        SearchResults_Page.getSearchResultsNumber(indexInPage)).text()
                .contains(expectedResult_searchResult)
                .perform();
    }


}
