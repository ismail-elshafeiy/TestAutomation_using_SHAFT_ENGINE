package examples.gui.web;

import com.shaft.driver.DriverFactory;
import com.shaft.driver.SHAFT;
import com.shaft.enums.internal.ClipboardAction;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ReportManager;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class ElementActions_Test {
    public ThreadLocal<SHAFT.GUI.WebDriver> driver = new ThreadLocal<>();

    //public SHAFT.GUI.WebDriver driver;
    public ThreadLocal<SHAFT.TestData.EXCEL> excelReader = new ThreadLocal<>();
    public ThreadLocal<SHAFT.TestData.JSON> jsonReader = new ThreadLocal<>();


    @BeforeMethod
    public void setUp() {
        driver.set(new SHAFT.GUI.WebDriver(DriverFactory.DriverType.CHROME));
//		excelReader = new SHAFT.TestData.EXCEL(System.getProperty("testDataFolderPath")+"");
    }

    @AfterMethod
    public void tearDown() {
        driver.get().quit();
    }

    @Test
    @Description("""
             Using Actions Class to perform a Click on element and Hold it
             	then goes to specific location or and Release the Hold button
            	Mainly used in horizontal bars , Draw something in Canvas
            """)
    public void ClickAndHoldByLocator() {
        driver.get().browser().navigateToURL("https://the-internet.herokuapp.com/horizontal_slider");
        driver.get().element().clickAndHold(By.xpath("//input[@type='range']"));
    }


    @Test
    public void hoverAndHoverThenClick() {
        List<By> hoverLocators = new ArrayList<By>();
        By car = By.linkText("Car");
        hoverLocators.add(By.linkText("Popular Toys"));
        hoverLocators.add(By.xpath("//a[contains(text(),'Video Games ') ] "));
        driver.get().browser().navigateToURL("https://phppot.com/demo/multilevel-dropdown-menu-with-pure-css/");
        driver.get().element().hoverAndClick(hoverLocators, car);
    }

    @Test
    public void DoubleClick() {
        By box = By.id("message");
        driver.get().browser().navigateToURL("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
        driver.get().element().getCSSProperty(box, "background-color");
        driver.get().verifyThat().element(box)
                .cssProperty("background-color").isEqualTo("rgba(0, 0, 255, 1)");
        driver.get().element().doubleClick(box);
        driver.get().verifyThat().element(box)
                .cssProperty("background-color").isEqualTo("rgba(255, 255, 0, 1)");
    }

    @Test
    public void dragAndDropByOffset() {
        driver.get().browser().navigateToURL("https://jqueryui.com/resources/demos/droppable/default.html");
        By sourceElement = By.id("draggable");    // Locator to the element you want to drag
        int xPos = 180;
        int yPos = 30;
        driver.get().element().dragAndDropByOffset(sourceElement, xPos, yPos);
    }

    @Test
    public void dragAndDropByLocator() {
        driver.get().browser().navigateToURL("https://jqueryui.com/resources/demos/droppable/default.html");
        By source = By.id("draggable");
        By target = By.id("droppable");
        driver.get().element().dragAndDrop(source, target);
    }

//    @Test
//    public void getValueOfElement() {
//        driver.get().browser().navigateToURL("https://www.google.com/");
//        //The locator to your element
//        By googleSearchBox = By.cssSelector(".gLFyf.gsfi");
//        //get the value of the 'name' attribute
//       // String elementName = driver.get().element().getAttribute(googleSearchBox, "name");
//       // System.out.println("The name attribute of the element is: " + elementName);
//        driver.get().element().getCSSProperty(googleSearchBox, "width");
//        driver.get().element().getCSSProperty(googleSearchBox, "color");
//        driver.get().element().getCSSProperty(googleSearchBox, "font-size");
//        driver.get().element().getCSSProperty(googleSearchBox, "font-family");
//        driver.get().element().getCSSProperty(googleSearchBox, "font-weight");
//        driver.get().element().getCSSProperty(googleSearchBox, "font-style");
//        driver.get().element().getCSSProperty(googleSearchBox, "text-decoration");
//        driver.get().element().getCSSProperty(googleSearchBox, "text-align");
//        driver.get().element().getCSSProperty(googleSearchBox, "text-indent");
//        driver.get().browser().getWindowSize();
//    }


    @Test
    void clipboardActions() {
        By textField = By.id("tinymce");
        By textIFrame = By.id("mce_0_ifr");
        driver.get().browser().navigateToURL("https://the-internet.herokuapp.com/tinymce");
        // switch focus to IFrame containing the text field
        driver.get().element().switchToIframe(textIFrame);
        //append text to the end
        driver.get().element().typeAppend(textField, "this is added text");
        // copy the whole paragraph
        driver.get().element().clipboardActions(textField, ClipboardAction.SELECT_ALL);
        driver.get().element().clipboardActions(textField, ClipboardAction.COPY);
        //replace original text using type
        driver.get().element().type(textField, "new text that overrides old content , ");
        //paste previously copied paragraph
        driver.get().element().clipboardActions(textField, ClipboardAction.PASTE);
    }

    @Test
    public void selectDropDown() {
        By dropDown = By.id("dropdown");
        driver.get().browser().navigateToURL("https://the-internet.herokuapp.com/dropdown");
        driver.get().element().select(dropDown, "Option 1");
        driver.get().element().select(dropDown, "Option 2");
    }


}

