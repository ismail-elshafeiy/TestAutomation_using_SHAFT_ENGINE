package examples.gui.web.validations;

import com.shaft.cli.FileActions;
import com.shaft.driver.DriverFactory;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DownloadFile {
    public SHAFT.GUI.WebDriver driver;
    private static Map<String, Object> getStringObjectMap() {
        Map<String, Object> prefs = new HashMap<>();
        //prefs.put("download.default_directory", downloadFilepath);
        //prefs.put("download.prompt_for_download", false);
        return prefs;
    }
    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = getStringObjectMap();
        options.setExperimentalOption("prefs", prefs);
        driver = new SHAFT.GUI.WebDriver(DriverFactory.DriverType.CHROME, options);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void downloadFile() throws InterruptedException {
        driver.browser().navigateToURL("https://the-internet.herokuapp.com/download");
        driver.element().click(By.linkText("upload.txt"));
        Thread.sleep(10000);
        FileActions.getInstance().doesFileExist("src/test/resources/downloadFiles/" + "upload.txt");
    }
}
