package com.apiautomation.ex_01_RestAssured_Basic;

import io.restassured.RestAssured;

import java.util.Scanner;

public class APITesting_Lab02_RA {
    public static void main(String[] args) {


        // Gherkins Syntax
        // Given() -> Pre Req. - URL, Headers, Auth, Body....
        // When() -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
        // Then() -> Validation -> 200 oK, firstname == PRAMOD

        // Full URL - https://api.zippopotam.us/IN/560016
        // base URI - https://api.zippopotam.us
        // bath Path - /IN/560016

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Pincode : ");
        String pincode = scanner.next();

        RestAssured.given()
                        .baseUri("https://api.zippopotam.us")
                        .basePath("/IN/" + pincode)
                   .when()
                        .get()
                   .then()
                        .log().all()
                        .statusCode(200);

    }
}
