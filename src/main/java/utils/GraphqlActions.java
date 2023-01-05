package utils;


import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import com.shaft.validation.Validations;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

/**
 * Until class for all common methods to be used across the projects
 */
public final class GraphqlActions {

    //************ variables ************//

    //TODO use system property for the BASE_URL and END_POINT instead of hard coded
    private static final String BASE_URL = System.getProperty("BASE_URL");
    private static final String END_POINT = System.getProperty("END_POINT");
    static RestActions apiObject = DriverFactory.getAPIDriver(BASE_URL);

    //************ constructor ************//
    private GraphqlActions(RestActions apiObject) {
        this.apiObject = apiObject;
    }

    //************ Request Related methods ************//

    /**
     * Perform Graphql Request using the "Query or Mutation" only
     *
     * @param query
     * @return Graphql Response
     */
    @SuppressWarnings("unchecked")
    public static Response sendGraphqlRequest(String query) {

        JSONObject requestBody = new JSONObject();
        requestBody.put("query", query);

        return apiObject.buildNewRequest(END_POINT, RestActions.RequestType.POST).setRequestBody(requestBody)
                .setContentType(ContentType.JSON).performRequest();
    }

    /**
     * Perform Graphql Request using the "Query or Mutation" and the Variables
     *
     * @param query
     * @param variables
     * @return Graphql Response
     */
    @SuppressWarnings("unchecked")
    public static Response sendGraphqlRequest(String query, String variables) {

        JSONObject requestBody = new JSONObject();
        requestBody.put("query", query);
        requestBody.put("variables", variables);

        return apiObject.buildNewRequest(END_POINT, RestActions.RequestType.POST).setRequestBody(requestBody)
                .setContentType(ContentType.JSON).performRequest();
    }

    /**
     * Perform Graphql Request using the "Query or Mutation", Variables, and Fragments
     *
     * @param query
     * @param variables
     * @param fragments
     * @return Graphql Response
     */
    @SuppressWarnings("unchecked")
    public static Response sendGraphqlRequest(String query, String variables, String fragments) {

        JSONObject requestBody = new JSONObject();
        requestBody.put("query", query);
        requestBody.put("variables", variables);
        requestBody.put("fragments", fragments);

        return apiObject.buildNewRequest(END_POINT, RestActions.RequestType.POST).setRequestBody(requestBody)
                .setContentType(ContentType.JSON).performRequest();
    }


    //************ Response Related methods ************//

    /**
     * verify that the actual results matches the expected results
     * If failed, the code will CONTINUE executing to the next verification. and the test case will be failed.
     *
     * @param response
     * @param actualResults_jsonPath
     * @param expectedResults
     */
    public static void verifyGraphqlResponse(Response response, String actualResults_jsonPath, String expectedResults) {

        Validations.verifyThat().object(RestActions.getResponseJSONValue(response, actualResults_jsonPath))
                .isEqualTo(expectedResults)
                .withCustomReportMessage("verify that, " + actualResults_jsonPath + " is equal to: " + expectedResults)
                .perform();


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


        Validations.assertThat().object((RestActions.getResponseJSONValue(response, actualResults_jsonPath)))
                .isEqualTo(expectedResults)
                .withCustomReportMessage("verify that, " + actualResults_jsonPath + " is equal to: " + expectedResults)
                .perform();

    }

}

