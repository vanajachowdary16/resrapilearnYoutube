package demoApiFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiBase.AuthService;
import apiBase.UserProfileManagementService;
import io.restassured.response.Response;
import requests.LoginRequest;
import requests.ProfileRequestPojo;
import response.LoginResponse;
import response.UserProfileResponse;

public class UpdateProfileTest {
	
	
	@Test(description="verify profile update test")
	public void updateProfileTest() {
		AuthService authService = new AuthService();
		Response resp =authService.login(new LoginRequest("vanajachowdary12","Apple@123"));
		LoginResponse loginresp=resp.as(LoginResponse.class);
		System.out.println(loginresp.getToken());
		
		System.out.println("================");
		
		UserProfileManagementService uermanagementservice = new UserProfileManagementService();
		resp =uermanagementservice.getProfile(loginresp.getToken());
		System.out.println(resp.asPrettyString());
		UserProfileResponse userprofileresponse= resp.as(UserProfileResponse.class);
		System.out.println(userprofileresponse.getUsername());
		Assert.assertEquals(userprofileresponse.getUsername(), "vanajachowdary12");
		
		System.out.println("================");
		
		ProfileRequestPojo profilerequest = new ProfileRequestPojo.Builder().firstName("disha2")
				.lastName("bhat2").email("disha3344@gmail.com").mobileNumber("3334445566").build();
		
		resp=uermanagementservice.updateProfile(loginresp.getToken(), profilerequest);
		System.out.println(resp.asPrettyString());
		System.out.println(userprofileresponse.getEmail());
		
	}

}
