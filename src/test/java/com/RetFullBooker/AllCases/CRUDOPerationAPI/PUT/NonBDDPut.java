package com.RetFullBooker.AllCases.CRUDOPerationAPI.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDPut {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

// TC - Result should  be forbidden Case
    // 6118
    // Token -  Token?
    // Payload - {
    //    "firstname" : "Pramod",
    //    "lastname" : "Brown",
    //    "totalprice" : 111,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2018-01-01",
    //        "checkout" : "2019-01-01"
    //    },
    //    "additionalneeds" : "Breakfast"
    //}


    // POST - Auth - token
    // POST - Booking ID
    // PUT - token and BookingID
    //"firstname" :"James"
    //"lastname" : "Brown"


    @Test
    public void test_put_Positive_TC(){

        String  Token="67c80908d9e9471";
        String bookingid="3361";

        String PayloadPut="{\n" +
                "    \"firstname\" : \"Tony\",\n" +
                "    \"lastname\" : \"Kumar name\",\n" +
                "    \"totalprice\" : 1112,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-02\",\n" +
                "        \"checkout\" : \"2020-01-03\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch in\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("Token",Token);
        requestSpecification.body(PayloadPut).log().all();

        Response response=requestSpecification.when().put();
        validatableResponse =response.then().log().all();
        validatableResponse.statusCode(403);





    }


}
