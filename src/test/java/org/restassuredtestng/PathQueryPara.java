package org.restassuredtestng;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PathQueryPara {

    @Test(priority = 1)
    public void PathParameter() {
        Response res = given().pathParam("id", 5).when().get("https://jsonplaceholder.typicode.com/users/{id}");
        System.out.println("Print response body :" + res);
        System.out.println("Print response body :" + res.asPrettyString());

    }

     @Test(priority = 2)
    public void QueryParameter() {
        Response res = given().queryParam("username","Bret").when().get("https://jsonplaceholder.typicode.com/users");
        System.out.println("Print response body :" + res);
        System.out.println("Print response body :" + res.asPrettyString());

    }

}
