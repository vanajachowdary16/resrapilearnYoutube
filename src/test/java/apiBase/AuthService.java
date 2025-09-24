package apiBase;

import java.util.HashMap;

import io.restassured.response.Response;
import requests.LoginRequest;
import requests.SignupRequest;

public class AuthService extends BaseService{
	
	private static final String BASE_PATH="/api/auth/";
	
	public Response login(LoginRequest payload) {
		return postRequest(payload, BASE_PATH+"login");
	}
	public Response signUp(SignupRequest payload) {
		return postRequest(payload, BASE_PATH+"signup");
	}
	public Response forgotPassword(String emailAddress){
		HashMap<String, String> payload = new HashMap<>();
		payload.put("email", emailAddress);
		return postRequest(payload, BASE_PATH+"forgot-password");
	}
}
