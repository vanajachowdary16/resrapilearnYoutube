package demoApiFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiBase.AuthService;
import io.restassured.response.Response;
import requests.SignupRequest;

public class AccountCreationTest {
	
	
	@Test(description="verify account creation")
	public void createAccountTest() {
		SignupRequest signupReqst = new SignupRequest.Builder().userName("vanu").password("disha@123").email("testtest123@gmail.com")
		.firstName("disha").lastName("butt").mobileNumber("7495068278").build();
		AuthService authService = new AuthService();
		
		Response resp =authService.signUp(signupReqst);
		System.out.println(resp.asPrettyString());
		Assert.assertEquals(resp.asPrettyString(), "User registered successfully!");
		
	}

}
