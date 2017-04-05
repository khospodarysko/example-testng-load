package com.kostia;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestApi {
    private static final Logger logger = LoggerFactory.getLogger(TestApi.class);

    @Test
    public void testApiCall1() {
        logger.info("Running testApiCall1");

        given()
            .baseUri("http://fakerestapi.azurewebsites.net")
        .when()
            .get("/api/Users")
        .then()
            // .log().body()
            .body("UserName", hasItem("User 2"));
    }

    @Test
    public void testApiCall2() {
        logger.info("Running testApiCall2");

        given()
            .baseUri("http://fakerestapi.azurewebsites.net")
        .when()
            .get("/api/Books/1")
        .then()
            // .log().body()
            .body("Title", contains("Does Not Exist"));
    }
}
