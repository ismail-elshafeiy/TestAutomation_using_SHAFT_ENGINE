package gui.automationExecrise;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CategoriesBarPage {
    private SHAFT.GUI.WebDriver driver;

    public By getCategoryLinkLocator_link(String categoryType) {
        return By.xpath("//a[@href='#" + categoryType + "']");
    }

    public By getSubCategoryLinkLocator_link(String categoryType, String subCategoryType) {
        return By.xpath("//div[@id='" + categoryType + "']//a[contains(text(),'" + subCategoryType + "')]");
    }

    public CategoriesBarPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("click On Category Link")
    public CategoriesBarPage clickOnCategoryLink(String categoryType) {
        driver.element().click(getCategoryLinkLocator_link(categoryType));
        GoogleAlert.dismissAlert(driver,getCategoryLinkLocator_link(categoryType));
        return this;
    }

    @Step("click On SubCategory Link")
    public CategoriesBarPage clickOnSubCategoryLink(String categoryType, String subCategoryType) {
        driver.element().click(getSubCategoryLinkLocator_link(categoryType, subCategoryType));
        GoogleAlert.dismissAlert(driver,getSubCategoryLinkLocator_link(categoryType, subCategoryType));
        return this;
    }
}
