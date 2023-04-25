package api.URLs;
import static io.restassured.RestAssured.*;

import api.pojo.CreateUser_pojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response createuser(CreateUser_pojo pojo){
		
		Response response=given().log().all().accept(ContentType.JSON).contentType(ContentType.JSON).body(pojo)
		
		.when().post(Routes.post_url);
		
		return response;
		
	}
	
	public static Response get_user_name(String Username) {
		
		
		Response response=given().log().all()
				.pathParam("username", Username)
		
		.when().get(Routes.get_url);
		return response;
		
	}
	
	public static Response update_user(String Username, CreateUser_pojo pojo) {
		
		
	Response response=	given().log().all()
			.pathParam("username", Username)
			
			.accept(ContentType.JSON).contentType(ContentType.JSON).body(pojo)
		
		.when().put(Routes.put_url);
	return response;
		
		
	}
	
public static Response delete_user_name(String Username) {
		
		
		Response response=given().log().all()
				.pathParam("username", Username)
				.accept(ContentType.JSON)
		
		.when().delete(Routes.delete_url);
		return response;
		
	}
	
	
	

}
