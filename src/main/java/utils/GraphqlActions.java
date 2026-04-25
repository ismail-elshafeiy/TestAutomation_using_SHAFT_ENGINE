package utils;
import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import com.shaft.validation.Validations;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Until class for all common methods to be used across the projects
 */
public final class GraphqlActions {

    //TODO use system property for the BASE_URL and END_POINT instead of hard coded
    private static final String BASE_URL = System.getProperty("BASE_URL");
    private static final String END_POINT = System.getProperty("END_POINT");
    static RestActions apiObject = DriverFactory.getAPIDriver(BASE_URL);

    private GraphqlActions(RestActions apiObject) {
        this.apiObject = apiObject;
    }


    /**
     * Perform Graphql Request using the "Query or Mutation" only
     *
     * @param query
     * @return Graphql Response
     */
    public static Response sendGraphqlRequest(String query) {

        JSONObject requestBody = new JSONObject();
        try {
            requestBody.put("query", query);
        } catch (JSONException e) {
            throw new RuntimeException("Failed to build GraphQL request body", e);
        }

        return apiObject.buildNewRequest(END_POINT, RestActions.RequestType.POST).setRequestBody(requestBody).setContentType(ContentType.JSON).performRequest().getResponse();
    }

    /**
     * Perform Graphql Request using the "Query or Mutation" and the Variables
     *
     * @param query
     * @param variables
     * @return Graphql Response
     */
    public static Response sendGraphqlRequest(String query, String variables) {

        JSONObject requestBody = new JSONObject();
        try {
            requestBody.put("query", query);
            requestBody.put("variables", variables);
        } catch (JSONException e) {
            throw new RuntimeException("Failed to build GraphQL request body", e);
        }

        return apiObject.buildNewRequest(END_POINT, RestActions.RequestType.POST).setRequestBody(requestBody).setContentType(ContentType.JSON).performRequest().getResponse();
    }

    /**
     * Perform Graphql Request using the "Query or Mutation", Variables, and Fragments
     *
     * @param query
     * @param variables
     * @param fragments
     * @return Graphql Response
     */
    public static Response sendGraphqlRequest(String query, String variables, String fragments) {

        JSONObject requestBody = new JSONObject();
        try {
            requestBody.put("query", query);
            requestBody.put("variables", variables);
            requestBody.put("fragments", fragments);
        } catch (JSONException e) {
            throw new RuntimeException("Failed to build GraphQL request body", e);
        }

        return apiObject.buildNewRequest(END_POINT, RestActions.RequestType.POST).setRequestBody(requestBody).setContentType(ContentType.JSON).performRequest().getResponse();
    }


    /**
     * verify that the actual results matches the expected results
     * If failed, the code will CONTINUE executing to the next verification. and the test case will be failed.
     *
     * @param response
     * @param actualResults_jsonPath
     * @param expectedResults
     */
    public static void verifyGraphqlResponse(Response response, String actualResults_jsonPath, String expectedResults) {
        Validations.verifyThat().object(RestActions.getResponseJSONValue(response, actualResults_jsonPath)).isEqualTo(expectedResults).withCustomReportMessage("verify that, " + actualResults_jsonPath + " is equal to: " + expectedResults).perform();
    }


    /**
     * verify that the actual results matches the expected results
     * If failed, the code will STOP executing to the next verification. and the test case will be failed
     *
     * @param response
     * @param actualResults_jsonPath
     * @param expectedResults
     */
    public static void assertGraphqlResponse(Response response, String actualResults_jsonPath, String expectedResults) {
        Validations.assertThat().object((RestActions.getResponseJSONValue(response, actualResults_jsonPath))).isEqualTo(expectedResults).withCustomReportMessage("verify that, " + actualResults_jsonPath + " is equal to: " + expectedResults).perform();

    }
}
