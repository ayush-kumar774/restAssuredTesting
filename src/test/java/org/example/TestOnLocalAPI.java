package org.example;

import org.testng.annotations.Test;
import  static io.restassured.RestAssured.*;

public class TestOnLocalAPI {
    @Test
    public void get()
    {
        baseURI = "http://localhost:3000" ;
        given().
                get("/users").
                    then().
                statusCode(200).
                log().all();
    }
}
