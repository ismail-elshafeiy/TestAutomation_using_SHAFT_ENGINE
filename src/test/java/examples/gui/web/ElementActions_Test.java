package examples.gui.web;

import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ReportManager;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class ElementActions_Test extends BaseTests {
	@Test
	@Description("""
			 Using Actions Class to perform a Click on element and Hold it
			 	then goes to specific location or and Release the Hold button
				Mainly used in horizontal bars , Draw something in Canvas
			""")
	public void ClickAndHoldByLocator () {
		driver.browser().navigateToURL("https://the-internet.herokuapp.com/horizontal_slider");
		driver.element().clickAndHold(By.xpath("//input[@type='range']"));
	}


	@Test
	public void hoverAndHoverThenClick () {
		List<By> hoverLocators = new ArrayList<By>();
		By car = By.linkText("Car");
		hoverLocators.add(By.linkText("Popular Toys"));
		hoverLocators.add(By.xpath("//a[contains(text(),'Video Games ') ] "));
		driver.browser().navigateToURL("https://phppot.com/demo/multilevel-dropdown-menu-with-pure-css/");
		driver.element().hoverAndClick(hoverLocators, car);
	}

	@Test
	public void DoubleClick () {
		By box = By.id("message");
		driver.browser().navigateToURL("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
		driver.element().getCSSProperty(box, "background-color");
		driver.verifyThat().element(box)
				.cssProperty("background-color").isEqualTo("rgba(0, 0, 255, 1)");
		driver.element().doubleClick(box);
		driver.verifyThat().element(box)
				.cssProperty("background-color").isEqualTo("rgba(255, 255, 0, 1)");
	}

	@Test
	public void dragAndDropByOffset () {
		driver.browser().navigateToURL("https://jqueryui.com/resources/demos/droppable/default.html");
		By sourceElement = By.id("draggable");    // Locator to the element you want to drag
		int xPos = 180;
		int yPos = 30;
		driver.element().dragAndDropByOffset(sourceElement, xPos, yPos);
	}

	@Test
	public void dragAndDropByLocator () {
		driver.browser().navigateToURL("https://jqueryui.com/resources/demos/droppable/default.html");
		By source = By.id("draggable");
		By target = By.id("droppable");
		driver.element().dragAndDrop(source, target);
	}

	@Test
	public void getValueOfElement () {
		driver.browser().navigateToURL("https://www.google.com/");
		//The locator to your element
		By googleSearchBox = By.cssSelector(".gLFyf.gsfi");
		//get the value of the 'name' attribute
		String elementName = driver.element().getAttribute(googleSearchBox, "name");
		System.out.println("The name attribute of the element is: " + elementName);
		driver.element().getCSSProperty(googleSearchBox, "width");
		driver.element().getCSSProperty(googleSearchBox, "color");
		driver.element().getCSSProperty(googleSearchBox, "font-size");
		driver.element().getCSSProperty(googleSearchBox, "font-family");
		driver.element().getCSSProperty(googleSearchBox, "font-weight");
		driver.element().getCSSProperty(googleSearchBox, "font-style");
		driver.element().getCSSProperty(googleSearchBox, "text-decoration");
		driver.element().getCSSProperty(googleSearchBox, "text-align");
		driver.element().getCSSProperty(googleSearchBox, "text-indent");
		ElementActions.getSize(driver.getDriver(), googleSearchBox);
	}


	@Test
	void clipboardActions () {
		By textField = By.id("tinymce");
		By textIFrame = By.id("mce_0_ifr");
		driver.browser().navigateToURL("https://the-internet.herokuapp.com/tinymce");
		// switch focus to IFrame containing the text field
		driver.element().switchToIframe(textIFrame);
		//append text to the end
		driver.element().typeAppend(textField, "this is added text");
		// copy the whole paragraph
		driver.element().clipboardActions(textField, "select all");
		driver.element().clipboardActions(textField, "copy");
		//replace original text using type
		driver.element().type(textField, "new text that overrides old content , ");
		//paste previously copied paragraph
		driver.element().clipboardActions(textField, "paste");
	}

	@Test
	public void selectDropDown () {
		By dropDown = By.id("dropdown");
		driver.browser().navigateToURL("https://the-internet.herokuapp.com/dropdown");
		driver.element().select(dropDown, "Option 1");
		driver.element().select(dropDown, "Option 2");
	}


	@Test
	public void alternate() {
		By textField=By.xpath("//form[@id='input-example']/input");
		By changeState=By.xpath("//form[@id='input-example']/button");
		driver.browser().navigateToURL( "https://the-internet.herokuapp.com/dynamic_controls");
		//--1-- check that initially the text box is not clickable
		ReportManager.log(String.valueOf(ElementActions.isElementClickable(driver.getDriver(), textField)));
		//--2-- press the button to enable the text box
		driver.element().click(changeState);
		//--3-- check again whether the text box is clickable
		ReportManager.log(String.valueOf(ElementActions.isElementClickable(driver.getDriver(), textField)));
		//--4-- attempt to click on the text box
		driver.element().click(textField);
		//--5-- finally verify the state of the check box
		ReportManager.log(String.valueOf(ElementActions.isElementClickable(driver.getDriver(), textField)));
		driver.element().type( textField, "SHAFT is awesome !");
	}
}

