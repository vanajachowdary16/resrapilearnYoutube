package demoApiFramework;

import org.testng.annotations.Test;

import apiBase.AuthService;
import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test
	public void forgotPasswordTest() {
		AuthService authService = new AuthService();
		Response resp = authService.forgotPassword("vanajachowdary1166@gmail.com");
		System.out.println(resp.asPrettyString());
		
		
	}

}
