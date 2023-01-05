package gui.nopCommerce.pages;

import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P9_EmailFriendPage {
    // driver
    private WebDriver driver;

    // Constructor
    public P9_EmailFriendPage(WebDriver driver) {
        this.driver = driver;
    }

    // Elements Locators
    private By friendEmail_Txt = By.xpath("//input[@id='FriendEmail']");
    private By personalMessage_Txt = By.xpath("//textarea[@id='PersonalMessage']");
    private By sendEmail_Btn = By.name("send-email");

    public static By messageSuccess_Txt() {
        return By.xpath("//div[@class='result']");
    }

    /////////////////////////////////////////////////////////////////
    //////////////////  Business Actions ////////////////////////////
    /////////////////////////////////////////////////////////////////

    @Step("2.Enter Email Friend: [ {friendEmail} ]")
    public P9_EmailFriendPage enterFriendEmail_TxtFd(String friendEmail) {
        ElementActions.type(driver, friendEmail_Txt, friendEmail);
        return this;
    }

    @Step("2.Enter personal Message: [ {personalMessage} ]")
    public P9_EmailFriendPage enterPersonalMessage_TxtFd(String personalMessage) {
        ElementActions.type(driver, personalMessage_Txt, personalMessage);
        return this;
    }

    @Step("Click on send Button")
    public P9_EmailFriendPage clickOn_SendButton() {
        ElementActions.click(driver, sendEmail_Btn);
        return new P9_EmailFriendPage(driver);
    }

}
