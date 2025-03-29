package com.RetFullBooker.AllCases.CRUDOPerationAPI.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyleGET {
    static  RequestSpecification r= RestAssured.given();
    public static void main(String[] args) {

        r.baseUri("https://api.zippopotam.us/");

        test_nonbdd1();
        test_nonbdd2();
    }
    // -Ve TestCase
    private static void test_nonbdd1() {
        r.basePath("IN/560038");
        r.when().get();
        r.then().log().all().statusCode(200);
    }
    // +Ve Test Case
    private static void test_nonbdd2() {
        r.basePath("IN/560037");
        r.when().get();
        r.then().log().all().statusCode(200);

    }
}
