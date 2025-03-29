package com.RetFullBooker.AllCases.CRUDOPerationAPI.MultiTestCaseUSINGTestNg;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TESTNG01 {
    @Test
    public void test_Get1(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("IN/560037")
                .when().log().all().get()
                .then().log().all().statusCode(200);
}
}


