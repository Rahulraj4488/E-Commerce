package com.sdet.api;

import com.sdet.utils.TestContext;
import com.sdet.utils.TestContext.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserApi {
    private static final String base_url = "https://api.demoblaze.com";

    public void createUser() {
        String userName = "sdet_user_" + System.currentTimeMillis();
        String password = "Test@123";

        String requestBody =
                """
                        {
                        "username": "%s",
                        "password": "%s"
                        }
                        """.formatted(userName, password);


        Response response = RestAssured
                .given()
                    .baseUri(base_url)
                    .header("content-Type", "application/json")
                    .body(requestBody)
                .when()
                    .post("/signup")
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        //Print Status code
        System.out.println("Status code: " + response.getStatusCode());

        //Print response body
        System.out.println("Response body: " + response.getBody().asString());
        System.out.println("User Added Successfully");
        System.out.println("Now User will be logging in successfully");

        //Save username in TestContext
        TestContext.setUsername(userName);

        //Save password in TestContext
        TestContext.setpassword(password);

    }
}

