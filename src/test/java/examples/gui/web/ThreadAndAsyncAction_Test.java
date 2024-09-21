package examples.gui.web;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ThreadAndAsyncAction_Test extends BaseTests {
    @Test
    public void asyncForm(){
        driver.get().browser().navigateToURL("https://www.phptravels.net/signup");
        driver.get().async().element()
                .type(By.cssSelector("#firstname"),"John")
                .type(By.cssSelector("#lastname"),"Doe")
                .type(By.cssSelector("#phonenumber"),"01005111998")
                .type(By.cssSelector("#user_email"),"ismail@gmail.com")
                .type(By.cssSelector("#password"),"123456")
                .synchronize();
    }

}
