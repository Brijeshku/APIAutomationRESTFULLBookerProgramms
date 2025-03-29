package com.RetFullBooker.AllCases.CRUDOPerationAPI.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BDDStyle {
    public static void main(String[] args) {
        String Payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("auth")
                .contentType(ContentType.JSON).log().all().body(Payload)
                .when().post()
                .then().log().all().statusCode(200);
    }
}
