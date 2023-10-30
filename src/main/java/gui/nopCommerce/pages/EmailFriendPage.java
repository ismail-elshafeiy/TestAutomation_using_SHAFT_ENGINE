package gui.nopCommerce.pages;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailFriendPage {
    private SHAFT.GUI.WebDriver driver;

    public EmailFriendPage(SHAFT.GUI.WebDriver driver) {
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
    public EmailFriendPage enterFriendEmail_TxtFd(String friendEmail) {
        driver.element().type(friendEmail_Txt, friendEmail);
        return this;
    }

    @Step("2.Enter personal Message: [ {personalMessage} ]")
    public EmailFriendPage enterPersonalMessage_TxtFd(String personalMessage) {
        driver.element().type(personalMessage_Txt, personalMessage);
        return this;
    }

    @Step("Click on send Button")
    public EmailFriendPage clickOn_SendButton() {
        driver.element().click(sendEmail_Btn);
        return new EmailFriendPage(driver);
    }
}
