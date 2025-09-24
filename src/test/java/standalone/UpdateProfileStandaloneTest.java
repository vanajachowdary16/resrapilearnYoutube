package standalone;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UpdateProfileStandaloneTest {

    private static final String BASE_URL = "http://64.227.160.186:8080";

    @Test(description = "Verify profile update test")
    public void updateProfileTest() {

        // Step 1: Login
        String loginPayload = "{ \"username\": \"vanajachowdary12\", \"password\": \"Apple@123\" }";

        Response loginResp = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(loginPayload)
                .when()
                .post("/api/auth/login");

        loginResp.then().statusCode(200);

        String token = loginResp.jsonPath().getString("token");
        System.out.println("Auth Token: " + token);

        System.out.println("==========");

        // Step 2: Get Profile
        Response profileResp = given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/api/users/profile");

        profileResp.then().statusCode(200);
        System.out.println("Profile Response: " + profileResp.asPrettyString());

        String username = profileResp.jsonPath().getString("username");
        String email = profileResp.jsonPath().getString("email");
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);

        Assert.assertEquals(username, "vanajachowdary12");

        System.out.println("==========");

        // Step 3: Update Profile
        String updatePayload = "{"
                + "\"firstName\": \"disha2\","
                + "\"lastName\": \"bhat2\","
                + "\"email\": \"vanajachowdary1166@gmail.com\","
                + "\"mobileNumber\": \"3334445566\""
                + "}";

        Response updateResp = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(updatePayload)
                .when()
                .put("/api/users/profile");

        updateResp.then().statusCode(200);

        System.out.println("Update Response: " + updateResp.asPrettyString());

        String updatedEmail = updateResp.jsonPath().getString("email");
        System.out.println("Updated Email: " + updatedEmail);

        Assert.assertEquals(updatedEmail, "vanajachowdary1166@gmail.com");
    }
}
