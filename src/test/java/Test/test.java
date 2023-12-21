package Test;

import com.shaft.driver.SHAFT;
import gui.examples.Google_Page;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test {
    public ThreadLocal<SHAFT.GUI.WebDriver> driver = new ThreadLocal<>();
    public ThreadLocal<SHAFT.TestData.EXCEL> excelReader = new ThreadLocal<>();
    @Test(groups = "Chrome")
    public void verifySearch_ResizeWindow () {
        driver.get().browser().setWindowSize(600, 466);
        new Google_Page(driver.get()).navigateTo_googlePage()
                .searchByTextAndIndexList("Selenium WebDriver");
        By searchResult_txt = By.xpath("//div[@id='result-stats']");
        var getSearchResults = driver.get().getDriver().findElement(searchResult_txt).getText();
        System.out.println("Search results --> " + getSearchResults);
        Assert.assertNotEquals(getSearchResults, "");
    }
    @Test(groups = "Chrome")
    public void verifySearch_ResizeWindow2 () {
        driver.get().browser().setWindowSize(600, 466);
        new Google_Page(driver.get()).navigateTo_googlePage()
                .searchByTextAndIndexList("Selenium WebDriver");
        By searchResult_txt = By.xpath("//div[@id='result-stats']");
        var getSearchResults = driver.get().getDriver().findElement(searchResult_txt).getText();
        System.out.println("Search results --> " + getSearchResults);
        Assert.assertNotEquals(getSearchResults, "");
    }
    @Test(groups = "Chrome")
    public void verifySearch_ResizeWindo3 () {
        driver.get().browser().setWindowSize(600, 466);
        new Google_Page(driver.get()).navigateTo_googlePage()
                .searchByTextAndIndexList("Selenium WebDriver");
        By searchResult_txt = By.xpath("//div[@id='result-stats']");
        var getSearchResults = driver.get().getDriver().findElement(searchResult_txt).getText();
        System.out.println("Search results --> " + getSearchResults);
        Assert.assertNotEquals(getSearchResults, "");
    }
    @Test(groups = "Chrome")
    public void verifySearch_ResizeWindo4 () {
        driver.get().browser().setWindowSize(600, 466);
        new Google_Page(driver.get()).navigateTo_googlePage()
                .searchByTextAndIndexList("Selenium WebDriver");
        By searchResult_txt = By.xpath("//div[@id='result-stats']");
        var getSearchResults = driver.get().getDriver().findElement(searchResult_txt).getText();
        System.out.println("Search results --> " + getSearchResults);
        Assert.assertNotEquals(getSearchResults, "");
    }


    @BeforeMethod
    public void setUp() {
        driver.set(new SHAFT.GUI.WebDriver());
//		excelReader = new SHAFT.TestData.EXCEL(System.getProperty("testDataFolderPath")+"");

    }

    @AfterMethod
    public void tearDown() {
        driver.get().quit();
    }
}
