package examples.gui.web;

import com.shaft.tools.io.ReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;

import javax.swing.*;

public class ChatBotAi_Test extends BaseTests {
    final By promptTxtArea = By.cssSelector("#prompt-textarea");
    final By chatAiResponse = By.xpath("//div[@data-testid='instant-answer-message-header'][last()]");

    @Test
    public void testChatBotAi() {
        driver.get().browser().navigateToURL("https://chat.openai.com/");
        driver.get().element().type(promptTxtArea, "What is the capital of France?"+ Keys.ENTER);
        String response = driver.get().element().get().text(chatAiResponse);
        ReportManager.log("ChatBot AI response: " + response);
    }
}
