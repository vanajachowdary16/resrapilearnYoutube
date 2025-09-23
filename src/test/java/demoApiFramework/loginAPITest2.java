package demoApiFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiBase.AuthService;
import io.restassured.response.Response;
import requests.LoginRequest;
import response.LoginResponse;

public class loginAPITest2 {
	
	@Test(description ="verify if login is working")
	public void loginTest() {
		LoginRequest loginreqst= new LoginRequest("vanajachowdary12", "Apple@123");
		AuthService authservice = new AuthService();
		//Response resp=authservice.login("{\"username\":\"vanajachowdary12\",\"password\":\"Apple@123\"}");
		Response resp=authservice.login(loginreqst);
		LoginResponse loginResponse =resp.as(LoginResponse.class);
		System.out.println(resp.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getId());
		Assert.assertEquals(loginResponse.getEmail(),"vanajachowdary1166@gmail.com");
		Assert.assertTrue(loginResponse.getToken()!=null);
	}

}
