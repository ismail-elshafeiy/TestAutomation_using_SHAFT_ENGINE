package examples.files;

import com.shaft.api.RestActions;
import com.shaft.cli.FileActions;
import com.shaft.driver.DriverFactory;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.restassured.builder.ResponseBuilder;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonActionsTests {
    @Test
    public void f() throws IOException, JSONException {
        String expectedResponse = new String(
                Files.readAllBytes(Paths.get(SHAFT.Properties.paths.testData() + "JsonFileTest2.json")));
        String actualResponse = new String(
                Files.readAllBytes(Paths.get(SHAFT.Properties.paths.testData() + "JsonFileTest.json")));

        JSONObject expectedJsonObject = new JSONObject(expectedResponse);
        JSONObject actualJsonObject = new JSONObject(actualResponse);

        String expectedJSONString = expectedJsonObject.toString();
        String actualJSONString = actualJsonObject.toString();

        JSONCompareResult result = JSONCompare.compareJSON(expectedJSONString, actualJSONString, JSONCompareMode.LENIENT);
        boolean finalResult = result.passed();
        Assert.assertTrue(finalResult);
    }

    @Test
    public void f2() throws IOException, JSONException {
        String expectedResponse = new String(Files.readAllBytes(Paths.get(SHAFT.Properties.paths.testData() + "JsonFileTest2.json")));
        String actualResponse = new String(Files.readAllBytes(Paths.get(SHAFT.Properties.paths.testData() + "JsonFileTest.json")));

        JSONObject expectedJsonObject = new JSONObject(expectedResponse);
        JSONObject actualJsonObject = new JSONObject(actualResponse);

        String expectedJSONString = expectedJsonObject.toString();
        String actualJSONString = actualJsonObject.toString();

        JSONCompareResult result = JSONCompare.compareJSON(expectedJSONString, actualJSONString,
                JSONCompareMode.LENIENT);
        boolean finalResult = result.passed();
        Assert.assertTrue(finalResult);
    }

    @Test
    public void specialCharacters() {
        String referenceJsonFilePath = SHAFT.Properties.paths.testData() + "specialCharacters.json";
        Response response = (new ResponseBuilder()).setBody(FileActions.getInstance().readFile(referenceJsonFilePath))
                .setStatusCode(200).build();
        Validations.verifyThat().response(response).isEqualToFileContent(referenceJsonFilePath).perform();
    }

    @Test
    public void specialCharacters_assertion() {
        String referenceJsonFilePath = SHAFT.Properties.paths.testData() + "specialCharacters.json";
        Response response = (new ResponseBuilder()).setBody(FileActions.getInstance().readFile(referenceJsonFilePath))
                .setStatusCode(200).build();
        Validations.assertThat().response(response).containsFileContent(referenceJsonFilePath)
                .withCustomReportMessage("trying out the log message")
                .perform();
    }

    @Test
    public void checkAPI_ResponseSchema() {
        Response response = DriverFactory.getAPIDriver("http://api.zippopotam.us/")
                .buildNewRequest("us/90210", RestActions.RequestType.GET)
                .performRequest().getResponse();
        Validations.assertThat()
                .response(response)
                .matchesSchema(SHAFT.Properties.paths.testData() + "schema.json")
                .perform();

    }
}
