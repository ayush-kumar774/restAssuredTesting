package org.example;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
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
                statusCode(200);
//                .
//                log().all();
    }

    @Test
    public void post()
    {
        JSONObject request = new JSONObject() ;
        request.put("firstName", "Gautam");
        request.put("lastName", "Rana");
        request.put("subjectID", 2);

        baseURI = "http://localhost:3000" ;
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).log().all();
    }

    @Test
    public void put()
    {
        JSONObject request = new JSONObject();
        request.put("firstName" , "Jack");
        request.put("lastName", "Pitt");
        request.put("subjectID" , 1);

        baseURI = "http://localhost:3000";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                    put("/users/4").
                then().
                    statusCode(200).log().all();
    }

    @Test
    public void patch()
    {
        JSONObject request = new JSONObject();

        request.put("lastName" , "Torreto");

        baseURI = "http://localhost:3000";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                    patch("/users/4").
                then().
                statusCode(200).log().all();
    }
    @Test
    public void delete()
    {
        // json-server --watch db.json to start json server
        baseURI = "http://localhost:3000" ;
        when().delete("/users/2").then().statusCode(200).log().all();
    }
}
