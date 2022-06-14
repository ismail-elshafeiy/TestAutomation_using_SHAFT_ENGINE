package nopCommerce.pages.gui;

import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P10_ReviewPage {
    private WebDriver driver;

    public P10_ReviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private By reviewTitle_txtBx = By.xpath("//input[@id='AddProductReview_Title']");
    private By reviewTxt_txtBx = By.xpath("//textarea[@id='AddProductReview_ReviewText']");
    private By rating_RadioBtn = By.id("addproductrating_4");

    private By stars(String rating) {
        return By.xpath("//input[contains(@value,'" + rating + "')][@type='radio']");
    }

    private By addReview_Btn = By.name("add-review");
    private By successProcess = By.xpath("//div[@class='result']");


    /////////////////////////////////////////////////////////////////
    //////////////////////////// Actions ////////////////////////////
    /////////////////////////////////////////////////////////////////

    @Step("Enter the Review Title: --> [{reviewTitle}]")
    public P10_ReviewPage enterReviewTitle(String reviewTitle) {
        ElementActions.type(driver, reviewTitle_txtBx, reviewTitle);
        return this;
    }

    @Step("Enter the Review text: --> [{reviewText}]")
    public P10_ReviewPage enterReviewText(String reviewText) {
        ElementActions.type(driver, reviewTxt_txtBx, reviewText);
        return this;
    }

    @Step("Enter the Rating")
    public P10_ReviewPage rateProduct(String ratingNumber) {
        ElementActions.click(driver, stars(ratingNumber));
        return this;
    }

    @Step("Click On [Add Review] Button")
    public P10_ReviewPage clickOnAddReviewBtn() {
        ElementActions.click(driver, addReview_Btn);
        return this;
    }

    @Step("get the Result")
    public String getText_successMessage() {
        return ElementActions.getText(driver, successProcess);
    }

}
