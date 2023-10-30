package gui.nopCommerce.pages;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewPage {
    private SHAFT.GUI.WebDriver driver;

    public ReviewPage(SHAFT.GUI.WebDriver driver) {
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
    public ReviewPage enterReviewTitle(String reviewTitle) {
        driver.element().type(reviewTitle_txtBx, reviewTitle);
        return this;
    }

    @Step("Enter the Review text: --> [{reviewText}]")
    public ReviewPage enterReviewText(String reviewText) {
        driver.element().type(reviewTxt_txtBx, reviewText);
        return this;
    }

    @Step("Enter the Rating")
    public ReviewPage rateProduct(String ratingNumber) {
        driver.element().click(stars(ratingNumber));
        return this;
    }

    @Step("Click On [Add Review] Button")
    public ReviewPage clickOnAddReviewBtn() {
        driver.element().click(addReview_Btn);
        return this;
    }

    @Step("get the Result")
    public String getText_successMessage() {
        return driver.element().getText(successProcess);
    }

}
