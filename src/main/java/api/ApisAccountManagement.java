package api;

import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApisAccountManagement {

    private SHAFT.API api;

    public ApisAccountManagement(SHAFT.API api) {
        this.api = api;
    }

    private static final String createAccount_serviceName = "/createAccount";
    private static final String loginToAccount_serviceName= "/verifyLogin";
    private static final String deleteAccount_serviceName = "/deleteAccount";
    private static final String getUserDetailByEmail_serviceName = "/getUserDetailByEmail";

    @Step("API Create/Register User Account")
    public ApisAccountManagement createRegisterUserAccount(String username, String email, String pass, String firstName, String lastName, String zipCode, String state, String city) {
        Map<String, Object> formData = new LinkedHashMap<>();
        formData.put("name", username);
        formData.put("email", email);
        formData.put("password", pass);
        formData.put("title", "Mr.");
        formData.put("birth_date", "04");
        formData.put("birth_month", "sep");
        formData.put("birth_year", "1994");
        formData.put("firstname", firstName);
        formData.put("lastname", lastName);
        formData.put("company", "company");
        formData.put("address1", "address1");
        formData.put("address2", "address2");
        formData.put("country", "India");
        formData.put("zipcode", zipCode);
        formData.put("state", state);
        formData.put("city", city);
        formData.put("mobile_number", "01111111");

        api.post(createAccount_serviceName)
                .setParameters(formData, RestActions.ParametersType.FORM)
                .setContentType(ContentType.URLENC)
                .setTargetStatusCode(Apis.SUCCESS)
                .perform();
        return this;
    }

    @Step("Registering A New User Account With The Provided Credentials.")
    public ApisAccountManagement createRegisterUserAccount(String username, String email, String pass, String firstName, String lastName) {
        createRegisterUserAccount(username,  email,  pass,  firstName,  lastName, "zipCode", "state", "city");
        return this;
    }

    @Step("API Log Into User Account")
    public ApisAccountManagement logIntoUserAccount(String email, String pass){
        Map<String, Object> formData = new LinkedHashMap<>();
        formData.put("email", email);
        formData.put("password", pass);

        api.post(loginToAccount_serviceName)
                .setParameters(formData, RestActions.ParametersType.FORM)
                .setContentType(ContentType.URLENC)
                .setTargetStatusCode(Apis.SUCCESS)
                .perform();
        return this;
    }

    @Step("API Delete User Account")
    public ApisAccountManagement deleteUserAccount(String email, String pass) {
        Map<String, Object> formData = new LinkedHashMap<>();
        formData.put("email", email);
        formData.put("password", pass);

        api.delete(deleteAccount_serviceName)
                .setParameters(formData, RestActions.ParametersType.FORM)
                .setContentType(ContentType.URLENC)
                .setTargetStatusCode(Apis.SUCCESS)
                .perform();
        return this;
    }

    @Step("API Get User Detail By Email")
    public ApisAccountManagement getUserDetailByEmail(String email) {
        Map<String, Object> queryParam = new LinkedHashMap<>();
        queryParam.put("email", email);

        api.get(getUserDetailByEmail_serviceName)
                .setParameters(queryParam, RestActions.ParametersType.QUERY)
                .setContentType(ContentType.URLENC)
                .setTargetStatusCode(Apis.SUCCESS)
                .perform();
        return this;
    }

    @Step("Validate User Created/Registered")
    public ApisAccountManagement validateUserCreatedRegistered() {
        api.verifyThatResponse().extractedJsonValue("message").isEqualTo("User created!").perform();
        return this;
    }

    @Step("Validate User Login")
    public ApisAccountManagement validateUserLoggedIn() {
    api.verifyThatResponse().extractedJsonValue("message").isEqualTo("User exists!").perform();
        return this;
    }

    @Step("Validate Account Deleted")
    public ApisAccountManagement validateDeleteUser() {
        api.verifyThatResponse().extractedJsonValue("message").isEqualTo("Account deleted!").perform();
        return this;
    }

    @Step("Validate User Not Found In The System")
    public ApisAccountManagement validateUserNotFound(String email) {
        getUserDetailByEmail(email);
        api.verifyThatResponse().extractedJsonValue("message").isEqualTo("Account not found with this email, try another email!").perform();
        return this;
    }
}