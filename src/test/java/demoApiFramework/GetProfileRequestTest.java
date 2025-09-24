package demoApiFramework;

import org.testng.annotations.Test;

import apiBase.AuthService;
import apiBase.UserProfileManagementService;
import io.restassured.response.Response;
import requests.LoginRequest;
import response.LoginResponse;
import response.UserProfileResponse;

public class GetProfileRequestTest {
	
	
	@Test
	public void getProfileTest() {
	AuthService authService = new AuthService();
	Response resp =authService.login(new LoginRequest("vanajachowdary12","Apple@123"));
	LoginResponse loginresp=resp.as(LoginResponse.class);
	System.out.println(loginresp.getToken());
	UserProfileManagementService uermanagementservice = new UserProfileManagementService();
	resp =uermanagementservice.getProfile(loginresp.getToken());
	System.out.println(resp.asPrettyString());
	UserProfileResponse userprofileresponse= resp.as(UserProfileResponse.class);
	System.out.println(userprofileresponse.getUsername());
	}

}
