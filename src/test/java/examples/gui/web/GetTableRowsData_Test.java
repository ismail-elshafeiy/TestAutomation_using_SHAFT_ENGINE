package examples.gui.web;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class GetTableRowsData_Test {
    SHAFT.GUI.WebDriver driver;
    // locator is the locator of the table element
    // <table id="example" class="display datatable">
    By tableLocator = By.id("example");

    @Test
    public void getAllTableData(){
        for (int i=0; i<driver.element().getTableRowsData(tableLocator).size(); i++){
            Map<String, String> row = driver.element().getTableRowsData(tableLocator).get(i);
            System.out.println("-------------------Row :"+i +"--------------------" );
            for (Map.Entry<String, String> entry : row.entrySet()) {
                System.out.println("Key = "+entry.getKey() + " : " +"Value = "+ entry.getValue());
            }
        }
    }
    @Test
    public void getFirstRow(){
        Map<String, String> firstRow = driver.element().getTableRowsData(tableLocator).get(0);
        for (Map.Entry<String, String> entry : firstRow.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        Assert.assertEquals(firstRow.get("Name"),"Airi Satou");
        Assert.assertEquals(firstRow.get("Age"), "33");
        Assert.assertEquals(firstRow.get("Start date"), "2008-11-28");
    }
    @BeforeMethod(description = "Setup Browser instance.")
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://datatables.net/examples/basic_init/zero_configuration.html");
    }

    @AfterMethod(description = "Teardown Browser instance.")
    public void afterMethod() {
        driver.quit();
    }
}
