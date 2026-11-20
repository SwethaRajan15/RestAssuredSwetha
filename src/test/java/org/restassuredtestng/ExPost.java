package org.restassuredtestng;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ExPost {
    //https://jsonplaceholder.typicode.com/posts

     @Test(priority=1)
    public void getUserDetails() {
        Response res = given().when().get("https://jsonplaceholder.typicode.com/posts");
        System.out.println("Print response body :" + res);
        System.out.println("Print response body :" + res.asPrettyString());

    }

    @Test(priority = 2)
    public void getUserDetail1() {
        Response res = given().when().get("https://jsonplaceholder.typicode.com/posts/1");
        System.out.println("Print response body :" + res);
        System.out.println("Print response body :" + res.asPrettyString());

    }

    @Test(priority = 3)
    public void CreateUser() {
        String requestbody = """
                    {
                         "name" : "swetha",
                          "userId" : "15",
                         "userEmail" : "Swe@253"
                   }

                """;
        Response res = given().contentType(ContentType.JSON).body(requestbody).when()
                .post("https://jsonplaceholder.typicode.com/posts");
        System.out.println("Post Response :");
        System.out.println(res.asPrettyString());
        System.out.println("Status Code : " + res.statusCode());
    }

    @Test(priority = 4)
    public void UpdateUserDetails() {
        String requestbody = """
                    {
                        "title" : "Patch"
                   }

                """;
        Response res = given().contentType(ContentType.JSON).body(requestbody).when()
                .patch("https://jsonplaceholder.typicode.com/posts/1");

        System.out.println("Patch Response :");
        System.out.println(res.asPrettyString());
        System.out.println("Status Code : " + res.statusCode());
    }
}
