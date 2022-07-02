package gui.practices;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementActions_Test {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @AfterMethod(enabled = false)
    public void tearDown_fireFox(ITestResult result) {
        BrowserActions.closeCurrentWindow(driver);
    }

    @Test
    public void dragAndDrop() {
        BrowserActions.navigateToURL(driver, "https://jqueryui.com/resources/demos/droppable/default.html");
        By sourceElement = By.id("draggable");    // Locator to the element you want to drag
        int xPos = 180;
        int yPos = 30;
        ElementActions.dragAndDropByOffset(driver, sourceElement, xPos, yPos);
    }

    @Test
    public void getValueOfElement() {
        BrowserActions.navigateToURL(driver, "https://www.google.com/");
        //The locator to your element
        By googleSearchBox = By.cssSelector(".gLFyf.gsfi");
        //get the value of the 'name' attribute
        String elementName = ElementActions.getAttribute(driver, googleSearchBox, "name");
        System.out.println("The name attribute of the element is: " + elementName);
        ElementActions.getCSSProperty(driver, googleSearchBox, "width");
        ElementActions.getCSSProperty(driver, googleSearchBox, "color");
        ElementActions.getCSSProperty(driver, googleSearchBox, "font-size");
        ElementActions.getCSSProperty(driver, googleSearchBox, "font-family");
        ElementActions.getCSSProperty(driver, googleSearchBox, "font-weight");
        ElementActions.getCSSProperty(driver, googleSearchBox, "font-style");
        ElementActions.getCSSProperty(driver, googleSearchBox, "text-decoration");
        ElementActions.getCSSProperty(driver, googleSearchBox, "text-align");
        ElementActions.getCSSProperty(driver, googleSearchBox, "text-indent");

        ElementActions.getSize(driver, googleSearchBox);

    }

    @Test
    public void type() {
        BrowserActions.navigateToURL(driver, "https://the-internet.herokuapp.com/tinymce");
        By textField = By.id("tinymce");
        By textIFrame = By.id("mce_0_ifr");

        // switch focus to IFrame containing the text field
        ElementActions.switchToIframe(driver, textIFrame);
        //append text to the end
        ElementActions.typeAppend(driver, textField, "this is added text");
        // copy the whole paragraph
        ElementActions.clipboardActions(driver, textField, "select all");
        ElementActions.clipboardActions(driver, textField, "copy");
        //replace original text using type
        ElementActions.type(driver, textField, "new text that overrides old content , ");
        //paste previously copied paragraph
        ElementActions.clipboardActions(driver, textField, "paste");

    }

    @Test
    public void selectDropDown() {
        BrowserActions.navigateToURL(driver, "https://the-internet.herokuapp.com/dropdown");
        By dropDown = By.id("dropdown");
        ElementActions.getSelectedText(driver, dropDown);
        ElementActions.select(driver, dropDown, "Option 1");

        Validations.verifyThat().element(driver,dropDown).text().isEqualTo("Option 1").perform();
        ElementActions.getSelectedText(driver, dropDown);
    }


}
