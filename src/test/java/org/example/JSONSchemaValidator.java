package org.example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.*;

public class JSONSchemaValidator {
    @Test
    public void testGet()
    {
        baseURI = "https://reqres.in/api" ;

        given().
                get("/users?page=2").
                then().
                assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
                statusCode(200).
                body("data[4].first_name", equalTo("George")).
                body("data.first_name", hasItems("George", "Rachel"));

    }
}
