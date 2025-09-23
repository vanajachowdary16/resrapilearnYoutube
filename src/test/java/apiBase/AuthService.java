package apiBase;

import io.restassured.response.Response;
import requests.LoginRequest;

public class AuthService extends BaseService{
	
	private static final String BASE_PATH="/api/auth/";
	
	public Response login(LoginRequest payload) {
		return postRequest(payload, BASE_PATH+"login");
	}
}
