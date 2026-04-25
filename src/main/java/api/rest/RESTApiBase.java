package api.rest;

import com.shaft.api.RestActions;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class RESTApiBase {
    private final RestActions restActions;

    public static final String BASE_URL = System.getProperty("restfulBaseUrl");
    private final String auth_serviceName = System.getProperty("authService");

    public enum StatusCode {
        SUCCESS(200), SUCCESS_DELETE(201), NotFound(404), BadRequest(400), Unauthorized(401);
        private int code;

        StatusCode(int code) {
            this.code = code;
        }

        int getCode() {
            return code;
        }
    }

    public enum status {
        SUCCESS("Success"), FAIL("Fail");
        private String status;

        status(String status) {
            this.status = status;
        }

        private String getStatus() {
            return status;
        }
    }

    public RESTApiBase(RestActions restActions) {
        this.restActions = restActions;
    }

    @Step("Login with Username: {username} and Password: {password}")
    public void login(String username, String password) {
        try {
            JSONObject authentication = new JSONObject();
            authentication.put("username", username);
            authentication.put("password", password);
            Response createToken = restActions.buildNewRequest(auth_serviceName, RestActions.RequestType.POST).setRequestBody(authentication).setContentType(ContentType.JSON).performRequest().getResponse();
            String token = RestActions.getResponseJSONValue(createToken, "token");
            restActions.addHeaderVariable("Cookie", "token=" + token);
        } catch (org.json.JSONException e) {
            throw new RuntimeException("Failed to build authentication request body", e);
        }
    }
}




