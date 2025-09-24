package demoApiFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiBase.AuthService;
import io.restassured.response.Response;
import requests.SignupRequest;

public class AccountCreationTest {
	
	
	@Test(description="verify account creation")
	public void createAccountTest() {
		SignupRequest signUpRequest=new SignupRequest.Builder()
				.userName("diishaaa19")
				.email("diishaaa1234@test.com")
				.firstName("Disha1")
				.password("disha123")
				.lastName("Bhatt")
				.mobileNumber("7777777774")
				.build();				
				AuthService authService = new AuthService();
				Response response=authService.signUp(signUpRequest);
				Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
				Assert.assertEquals(response.statusCode(), 200);
		
	}

}
