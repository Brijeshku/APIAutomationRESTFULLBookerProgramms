package com.RetFullBooker.AllCases.CRUDOPerationAPI.VerificationERtoAR;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.http.util.Asserts;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
public class Validation {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    String bookingId;

    @Test
    public void test_post(){

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

// Set up the request specification
        requestSpecification = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .cookie("token", token)
                .body(payloadPost)
                .log().all();

// Send the POST request and capture the response
        response = requestSpecification.when().post();
        validatableResponse = response.then().log().all();

// Assert that the response status code is 200 (successful booking creation)
        validatableResponse.statusCode(200);

// Extract booking ID and first name from the response
 String bookingId = response.jsonPath().getString("bookingid");
   String firstname = response.jsonPath().getString("booking.firstname");
//
//// Perform assertions
//        Assert.assertNotNull(bookingId, "Booking ID should not be null");
//        Assert.assertEquals(firstname, "Tony", "First name should be Tony");

// Optional: Additional assertions for other fields
//        validatableResponse.body("booking.lastname", Matchers.equalTo("Kumar"));
//        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
//        validatableResponse.body("bookingid", Matchers.notNullValue());

        assertThat(bookingId).isNotNull().isNotNull().isPrintable();
        assertThat(firstname).isEqualTo("Tony").isNotEmpty().isNotBlank();

        String s="";
        String s2=" ";


    }



}
