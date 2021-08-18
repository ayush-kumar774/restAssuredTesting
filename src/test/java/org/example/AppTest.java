package org.example;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AppTest {
    @Test
    public void test_1() {
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test_2() {
        // ValidatableResponse body = given().
        //                get("/users?page=2").
        //                then().
        //                statusCode(200).
        //                body("data[1].id", equalTo(9));
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
                then().
                statusCode(200).
                body("data[1].id", equalTo(8))
                .log().all();
    }
}
