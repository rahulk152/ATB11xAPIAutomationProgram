package com.apiautomation.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_GET_NonBDDStyle {

    RequestSpecification r; //Given
    Response response; //When
    ValidatableResponse vr; //Then

    @Test
    public void test_GET_NonBDD(){
        String pincode =  "560066";
        //Given
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        //When
        response = r.when().log().all().get();

        //Then
        vr = response.then().log().all();
        vr.statusCode(200);
    }
    @Test
    public void test_GET_NonBDD_Neagtive(){

        String pincode =  "@";
        // GIVEN
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        // WHEN
        response = r.when().log().all().get();

        System.out.println(response.asString());

        // THEN
        vr = response.then().log().all();
        vr.statusCode(404);


    }

}
