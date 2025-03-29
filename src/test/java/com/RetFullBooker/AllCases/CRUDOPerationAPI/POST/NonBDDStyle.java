package com.RetFullBooker.AllCases.CRUDOPerationAPI.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyle {
    public static void main(String[] args) {

        String Payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

   // Given
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(Payload);
        //When
             Response response=r.when().post();
             // Validation

        //Then
        ValidatableResponse validatableResponse=response.then();
        validatableResponse.log().all();
        validatableResponse.statusCode(200);



    }
}
