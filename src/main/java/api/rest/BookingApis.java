package api.rest;

import com.shaft.driver.SHAFT;
import org.json.simple.JSONObject;
import com.shaft.api.RestActions;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookingApis {

    private RestActions restActions;


    // Services Name
    // Services Names
    private String booking_serviceName = System.getProperty("booking_serviceName");
//    private String booking_serviceName = "booking/";


    // Constructor
    public BookingApis(RestActions restActions) {
        this.restActions = restActions;
    }


    //////////////////////////////////////////////////////
    /////////////      Business Actions      /////////////
    //////////////////////////////////////////////////////


    @Step("Get All Booking Ids")
    public Response getAllBookingIds() {
        return restActions.buildNewRequest(booking_serviceName, RestActions.RequestType.GET).performRequest().getResponse();
    }

    @Step("Get and Filter the booking Ids by [{firstName}] and [{lastName}] ")
    public Response getBookingId(String firstName, String lastName) {
        return restActions
                .buildNewRequest(booking_serviceName, RestActions.RequestType.GET)
                .setUrlArguments("firstname=" + firstName + "&lastname=" + lastName)
                .performRequest().getResponse();

    }

    @Step("Get A booking details by the booking Id: [{bookingId]")
    public Response getBooking(String bookingId) {
        return restActions
                .buildNewRequest(booking_serviceName + bookingId, RestActions.RequestType.GET)
                .performRequest().getResponse();
    }

    @Step("Create Booking")
    public Response createBooking(String firstName, String lastName, int totalPrice, boolean depositePaid,
                                  String checkIn, String checkOut, String additionalNeeds) {
        return restActions.buildNewRequest(booking_serviceName, RestActions.RequestType.POST)
                .setRequestBody(createBookingBody(firstName, lastName, totalPrice, depositePaid, checkIn, checkOut, additionalNeeds))
                .setContentType(ContentType.JSON)
                .performRequest().getResponse();
    }

    @Step("Delete A Booking By: Id: [{bookingId}]")
    public Response deleteBooking(String bookingId) {
        return restActions
                .buildNewRequest(booking_serviceName + bookingId, RestActions.RequestType.DELETE)
                .setTargetStatusCode(RESTApiBase.StatusCode.SUCCESS_DELETE.getCode())
                .performRequest().getResponse();
    }

    //////////////////////////////////////////////////////
    /////////////      JSON Object     /////////////
    //////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    private JSONObject createBookingBody(String firstName,
                                         String lastName,
                                         int totalPrice,
                                         boolean depositePaid,
                                         String checkIn,
                                         String checkOut,
                                         String additionalNeeds) {
        JSONObject createBookingBody = new JSONObject();
        createBookingBody.put("firstname", firstName);
        createBookingBody.put("lastname", lastName);
        createBookingBody.put("totalprice", totalPrice);
        createBookingBody.put("depositpaid", depositePaid);
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", checkIn);
        bookingDates.put("checkout", checkOut);
        createBookingBody.put("bookingdates", bookingDates);
        createBookingBody.put("additionalneeds", additionalNeeds);

        return createBookingBody;


    }
}
