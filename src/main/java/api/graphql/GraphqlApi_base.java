package api.graphql;

import com.shaft.api.RestActions;
import com.shaft.api.RestActions.RequestType;
import com.shaft.driver.DriverFactory;
import com.shaft.validation.Validations;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class GraphqlApi_base {

    // ****variables
    private static final String BASE_URL = System.getProperty("graphql_baseUrl");
    private static final String END_POINT = System.getProperty("graphql_endPoint");
    public static final String SUCCESS_STATUS_CODE = "200";
    public static final String SUCCESS_MESSAGE = "Operation done successfully";
    public static final boolean SUCCESS_BOOLEAN = true;
    static RestActions apiObject = DriverFactory.getAPIDriver(BASE_URL);

    // ****constructor
    public GraphqlApi_base(RestActions apiObject) {
        this.apiObject = apiObject;
    }

    // ****methods

    /**
     * Perform Graphql Request using the "Query or Mutation" and the Variables
     *
     * @param query
     * @param variables
     *
     * @return theResponse
     */
    @SuppressWarnings( "unchecked" )
    public static Response graphqlRequestBuilder(String query, String variables) {

        JSONObject requestBody = new JSONObject();
        requestBody.put("query", query);
        requestBody.put("variables", variables);

        return apiObject.buildNewRequest(END_POINT, RequestType.POST).setRequestBody(requestBody)
                .setContentType(ContentType.JSON).performRequest();
    }

    /**
     * verify that the target status code is correct.
     * this Method was generated because, in some cases, graphql returns 200 even if the request failed, so we can't rely on the default assertion for checking status code
     *
     * @param response
     * @param operationName
     */
    public static void verifyStatusCode(Response response, String operationName) {
        Validations.verifyThat()
                .response(RestActions.getResponseJSONValue(response, "data." + operationName + ".code"))
                .equals(GraphqlApi_base.SUCCESS_STATUS_CODE);
//                isEqualTo("verify that status code is: " + GraphqlApi_base.SUCCESS_STATUS_CODE);
    }

    /**
     * verify that the response message is correct.
     *
     * @param response
     * @param operationName
     */
    public static void verifyResponseMessage(Response response, String operationName) {

        Validations.verifyThat()
                .response(RestActions.getResponseJSONValue(response, "data." + operationName + ".message"))
                .equals(GraphqlApi_base.SUCCESS_MESSAGE);
//                ("verify that response message is: " + GraphqlApi_base.SUCCESS_MESSAGE)
    }

}
