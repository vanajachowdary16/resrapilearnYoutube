package demoApiFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class LoginApiTest {
	
	@Test(description="verify login test API is working...")
	public void loginTest() {
		
		//RestAssured.baseURI="http://64.227.160.186:8080";
		/*RequestSpecification x =RestAssured.given();
		RequestSpecification y = x.header("Content-Type", "application/json");
		RequestSpecification z = y.body("{\"usname\":\"vanajachowdary12\",\"password\":\"Apple@123\"}");*/	
		Response response = given().baseUri("http://64.227.160.186:8080")

				.header("Content-Type", "application/json")
				.body("{\"username\": \"vanajachowdary12\",\"password\": \"Apple@123\"}").post("/api/auth/login");
		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200);

		System.out.println(response.asPrettyString());

}
}
