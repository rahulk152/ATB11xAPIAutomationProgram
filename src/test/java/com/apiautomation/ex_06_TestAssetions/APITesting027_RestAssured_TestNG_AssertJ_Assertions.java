package com.apiautomation.ex_06_TestAssetions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_POST() {

        String payload_POST = "{\n" +
                "    \"firstname\" : \"Rahul\",\n" +
                "    \"lastname\" : \"Kumar\",\n" +
                "    \"totalprice\" : 123,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

        Response response = requestSpecification.when().post();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers;
        // Matchers.equalto()

        validatableResponse.body("booking.firstname", Matchers.equalTo("Rahul"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Kumar"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(false));
        validatableResponse.body("bookingid", Matchers.notNullValue());

        // TestNG - Extract the details of the firstname, bookingId, lastname from Response.

        //bookingId = response.then().extract().path("bookingid");


    }
}
