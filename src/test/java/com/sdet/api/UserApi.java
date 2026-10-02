package com.sdet.api;

import com.sdet.utils.TestContext;
import org.openqa.selenium.devtools.latest.network.model.Response;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserApi {
    private static final String base_url = "https://api.demoblaze.com";

    public void createUser()
    {
        String userName = "sdet_user_" + System.currentTimeMillis();
        String password = "Test@123";

        String requestBody =
                """
                        {
                        "username": "%s",
                        "password": "%s"
                        }
                        """.formatted(userName, password);
    }

    Response response = RestAssured
            .given()
                .baseUri(base_url)
                .header("content-Type", "application/json")
                .body(requestBody)
            .when()
                .post("/api/signup")
            .then()
                .statusCode(200)
                .extract()
                .response();

    //Print Status code
    System.out.println("Status code: " +response.getStatusCode());

    //Print response body
    System.out.println("Response body: " +response.getBody().asString());

    //Save username in TestContext
    TestContext.setUsername(username);

    //Save password in TestContext
    TestContext.setPassword(password);

}
