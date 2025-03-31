package com.RetFullBooker.AllCases.CRUDOPerationAPI.CRUDF;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FullIntegration {


    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    String bookingId;

    // Create a Token
    public String getToken() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        // Given - Request Spec
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(payload);

        // When - Response
        response = requestSpecification.when().post();

        // Then - ValidatableResponse
        validatableResponse = response.then();
        validatableResponse.statusCode(200);

        // Extract the token
        token = response.jsonPath().getString("token");
        System.out.println("Token: " + token);
        return token;
    }

    // Create a Booking
    public String getBookingId() {
        String payloadPost = "{\n" +
                "    \"firstname\" : \"Tony\",\n" +
                "    \"lastname\" : \"Kumar\",\n" +
                "    \"totalprice\" : 1112,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-02\",\n" +
                "        \"checkout\" : \"2024-01-03\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payloadPost).log().all();

        response = requestSpecification.when().post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200); // Expecting a successful booking creation

        bookingId = response.jsonPath().getString("bookingid");
        System.out.println("Booking ID: " + bookingId);

        return bookingId;
    }

    @Test (priority = 1)
    public void testUpdateRequestPut() {
        token = getToken();
        bookingId = getBookingId();
        // Additional code for PUT request can be added here
    }

    @Test (priority = 2)
    public void testUpdateGetRequestGet() {
        System.out.println(bookingId);
        // Code for GET request to verify the update can be added here
    }

    @Test (priority = 3)
    public void testDeleteBooking() {

        System.out.println(bookingId);
        System.out.println(token);
        // Code for DELETE request to remove the booking can be added here
    }

    @Test(priority = 4)
    public void testAfterDeleteRequestGet() {
        System.out.println(bookingId);
        // Code for GET request to verify the booking has been deleted can be added here
    }
}