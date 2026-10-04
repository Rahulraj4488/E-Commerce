package com.sdet.api;

import com.sdet.utils.TestContext;
import com.sdet.utils.TestContext.*;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserApi {
    private static final String base_url = "https://api.demoblaze.com";

    public void createUser() {
//        String userName = "sdet_user_" + System.currentTimeMillis();
        String userName = "sdet_user_1000";
        String password = "abcd1000";
//        String password = "sdet_pass_" + System.currentTimeMillis();

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

        String responseBody = response.getBody().asString();
        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Response: " + responseBody);

//        // DemoBlaze returns "This user already exist" if duplicate
//        if (responseBody.contains("This user already exist")) {
//            System.out.println("⚠️ User already exists, using existing credentials");
//        } else if (responseBody.contains("Sign up successful")) {
//            System.out.println("✅ User created successfully");
//        }

        // Parse response
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonResponse = mapper.readTree(response.getBody().asString());

            // Check if signup was successful
            int statusCode = response.getStatusCode();
            if (statusCode == 200) {
                // Save credentials in TestContext
                TestContext.setUsername(userName);
                TestContext.setpassword(password);

                System.out.println("✅ User Created Successfully");
                System.out.println("Username: " + userName);
                System.out.println("Password: " + password);
                System.out.println("Now User will be logging in...");
            } else {
                System.out.println("❌ User creation failed with status: " + statusCode);
                throw new RuntimeException("Failed to create user. Status: " + statusCode);
            }
        } catch (Exception e) {
            System.out.println("❌ Error parsing response: " + e.getMessage());
            throw new RuntimeException("Failed to create user", e);
        }
    }
}