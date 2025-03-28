package com.RetFullBooker;

import io.restassured.RestAssured;

public class GetRequestforInfo {
    public static void main(String[] args) {

        System.out.println("Rest Assured Test case ");

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/1").log().all()
                .when()
                .get()
                .then().log().all()
                .statusCode(200);



    }
}
