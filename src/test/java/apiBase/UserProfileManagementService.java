package apiBase;

import io.restassured.response.Response;
import requests.ProfileRequestPojo;

public class UserProfileManagementService extends BaseService{
	
	private static final String BASE_PATH = "/api/users";

	public Response getProfile(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH + "/profile");

	}

	public Response updateProfile(String token, ProfileRequestPojo payload) {
		setAuthToken(token);
		return putRequest(payload, BASE_PATH + "/profile");
	}
}
