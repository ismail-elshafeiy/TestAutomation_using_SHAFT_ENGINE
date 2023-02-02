package examples.gui.web.validations;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import examples.gui.web.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class FileValidations extends BaseTests {
	@Test
	public void testValidationsExists() {
		//make assertion
		Validations.assertThat().file("src/test/resources/testDataFiles/","bookingApis.json").exists().perform();
	}
	@Test
	public void testValidationsDoesNotExist() {
		//make assertion
		Validations.assertThat().file("src/test/resources/testDataFiles/","bookingApis2.json").doesNotExist().perform();
	}
	@Test
	public void testValidationsContent() {
		Object file = jsonReader.getTestData("booking");
		//make assertion
		Validations.assertThat().file("src/test/resources/testDataFiles/","bookingApis2.json").content().isEqualTo(file).perform();
	}
	@BeforeClass
	public void beforeClass() {
		jsonReader = new SHAFT.TestData.JSON(System.getProperty("testDataFolderPath")+"bookingApis.json");
	}
}
