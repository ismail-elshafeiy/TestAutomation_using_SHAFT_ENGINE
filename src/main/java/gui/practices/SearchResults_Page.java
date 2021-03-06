package gui.practices;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResults_Page {
    // driver
    private static WebDriver driver;

    // Constructor
    public SearchResults_Page(WebDriver driver) {
        this.driver = driver;
    }

    //////////////////////////// Elements Locators ////////////////////////////
    public static By getSearchResultsNumber(String index) {
        return By.xpath("(//div[@data-header-feature=0]//h3)[" + index + "]");

    }
/*
	public static By getSearchResultsNumber(String index) {
		return By.xpath("(//div[@class='v7W49e']//div[contains(@class,'g')]//h3)[" + index + "]");
	}

	public static By getSearchResultsNumber(String index) {
		return By.xpath("//div[@class='g tF2Cxc']//div[@class='yuRUbf']//h3[" + index + "]");
	}
*/


    //////////////////////////// Business Actions ////////////////////////////

    /**
     * get text By index
     *
     * @param index*
     * @return self reference
     */

    public static String getTextSearchResults(String index) {
        return ElementActions.getText(driver, getSearchResultsNumber(index));
    }

    /**
     * Navigate to Page index
     *
     * @param index*
     * @return self reference
     */
    public SearchResults_Page navigateTo_cucumberSearchResult(String index) {
        ElementActions.click(driver, getSearchResultsNumber(index));
        return this;
    }


    @Step("Get Current Page URL")
    public static String getCurrentPage_Url() {
        return BrowserActions.getCurrentURL(driver);
    }

}
