package standalone;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetProfileStandalone {
	
	 private static final String BASE_URL = "http://64.227.160.186:8080";

	    @Test
	    public void getProfileTest() {
	        // Step 1: Login
	        String loginPayload = "{ \"username\": \"vanajachowdary12\", \"password\": \"Apple@123\" }";

	        Response loginResponse = given()
	                .baseUri(BASE_URL)
	                .contentType(ContentType.JSON)
	                .body(loginPayload)
	                .when()
	                .post("/api/auth/login");

	        loginResponse.then().statusCode(200); // basic validation

	        String token = loginResponse.jsonPath().getString("token");
	        System.out.println("Auth Token: " + token);

	        // Step 2: Get Profile
	        Response profileResponse = given()
	                .baseUri(BASE_URL)
	                .header("Authorization", "Bearer " + token)
	                .when()
	                .get("/api/users/profile");

	        profileResponse.then().statusCode(200);

	        System.out.println("Profile Response: " + profileResponse.asPrettyString());

	        String username = profileResponse.jsonPath().getString("username");
	        System.out.println("Username: " + username);
	    }

}
