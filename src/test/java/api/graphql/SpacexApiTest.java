package api.graphql;

import com.shaft.api.RestActions;
import com.shaft.tools.io.JSONFileManager;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.GraphqlActions;

public class SpacexApiTest {

    // ******* variables and instances *******//
    RestActions apiObject;
    SpacexApiObjectModel spacexApiObjectModel;
    JSONFileManager jsonFile;

    @BeforeClass
    public void beforeClass() {
        spacexApiObjectModel = new SpacexApiObjectModel(apiObject);
    }

    @Test
    public void testPatLaunches_checkRocketName_shouldBeFalcon9() {

        Response response = spacexApiObjectModel.getPastLaunches();
        GraphqlActions.assertGraphqlResponse(response, "data.launchesPast[0].rocket.rocket_name", "Falcon 9");
    }

    @Test
    public void insertUser_checkuserName_shouldBeTheSame() {

        Response response = spacexApiObjectModel.insertUser("ismail elshafeiy", "ismail's rocket");
        GraphqlActions.assertGraphqlResponse(response, "data.insert_users.returning[0].name", "ismail elshafeiy");
        GraphqlActions.assertGraphqlResponse(response, "data.insert_users.returning[0].rocket", "ismail's rocket");

    }

}
