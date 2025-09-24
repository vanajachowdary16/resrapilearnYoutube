package apiBase;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService{
	
	public static final String BASE_PATH="/api/users/";
	
	public Response getProfile(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"profile");
	}

}
