package examples.api.rest;


import api.rest.BookingApis;
import api.rest.RESTApiBase;
import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import com.shaft.validation.Validations;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookingTestApis {

    private RESTApiBase restApiBase;
    private BookingApis bookingApis;

    @BeforeClass
    public void setUp() {
        RestActions restActions = DriverFactory.getAPIDriver(RESTApiBase.BASE_URL);
        restApiBase = new RESTApiBase(restActions);
        bookingApis = new BookingApis(restActions);
        restApiBase.login("admin", "password123");
    }

    @Test
    public void getBookingIds() {
        bookingApis.getAllBookingIds();
    }

    @Test
    public void getBooking() {
        bookingApis.getBooking("1");
    }

    @Test
    public void createBooking() {
        // Create Booking
        Response createBookingRes = bookingApis.createBooking(
                "ismail", "ElShafeiy",
                1000, true, "2022-07-01",
                "2022-07-10", "IceCream");
        // Get the created booking id
        String bookingId = RestActions.getResponseJSONValue(createBookingRes, "bookingid");

        // Get the created booking parameters values
        Response getBookingRes = bookingApis.getBooking(bookingId);
        String firstName = RestActions.getResponseJSONValue(getBookingRes, "firstname");
        String lastName = RestActions.getResponseJSONValue(getBookingRes, "lastname");
        String checkin = RestActions.getResponseJSONValue(getBookingRes, "bookingdates.checkin");
        String checkout = RestActions.getResponseJSONValue(getBookingRes, "bookingdates.checkout");
        String totalprice = RestActions.getResponseJSONValue(getBookingRes, "totalprice");

        // Validations 1
        Validations.verifyThat().object(firstName).isEqualTo("ismail").perform();
        Validations.verifyThat().object(lastName).isEqualTo("ElShafeiy").perform();
        Validations.verifyThat().object(checkin).isEqualTo("2022-07-01").perform();
        Validations.verifyThat().object(checkout).isEqualTo("2022-07-10").perform();
        Validations.verifyThat().object(totalprice).isEqualTo("1000").perform();
        // Validations 2
        Validations.verifyThat().response(getBookingRes).extractedJsonValue("firstname").isEqualTo("ismail").perform();
        Validations.verifyThat().response(getBookingRes).extractedJsonValue("lastname").isEqualTo("ElShafeiy").perform();
        Validations.verifyThat().response(getBookingRes).extractedJsonValue("bookingdates.checkin").isEqualTo("2022-07-01").perform();
        Validations.verifyThat().response(getBookingRes).extractedJsonValue("bookingdates.checkout").isEqualTo("2022-07-10").perform();
        Validations.verifyThat().response(getBookingRes).extractedJsonValue("totalprice").isEqualTo("1000").perform();
//        // Validations 3
//        Validations.verifyThat().response(getBookingRes)
//                .isEqualToFileContent(System.getProperty("src/test/resources/testDataFiles/bookingApis.json"))
//                .perform();
    }

    @Test(dependsOnMethods = "createBooking")
    public void deleteBooking() {
        Response getBookingId = bookingApis.getBookingId("ismail", "ElShafeiy");
        String bookingId = RestActions.getResponseJSONValue(getBookingId, "bookingid[0]");

        Response deleteBooking = bookingApis.deleteBooking(bookingId);
        String deleteBookingBody = RestActions.getResponseBody(deleteBooking);

        Validations.assertThat().object(deleteBookingBody).isEqualTo("Created").perform();
    }

}
