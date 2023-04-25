package api.URLs;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import api.pojo.CreateUser_pojo;


public class Code_Implementation {
	
	
	@Test(priority=1)
	public void create_User_API() {
		
		RestAssured.baseURI=Routes.base_url;
		
		CreateUser_pojo pojo=new CreateUser_pojo();
		
		pojo.setEmail("suyash@gmail.com");
		pojo.setFirstName("Suyash");
		pojo.setId(7001);
		pojo.setLastName("Gore");
		pojo.setPassword("Target@7001");
		pojo.setPhone("9689494747");
		pojo.setUserStatus(0);
		
		
	String response= 	given().log().all().headers("Content-Type","application/json").body(pojo)
		
		.when().post("https://petstore.swagger.io/v2/user")
		
		.then().log().all().statusCode(200).extract().asString();
	
	JsonPath js=new JsonPath(response);
	
	js.getString("");
		
		
	}

}
