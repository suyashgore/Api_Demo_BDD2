package api.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.URLs.UserEndPoints;
import api.pojo.CreateUser_pojo;
import io.restassured.response.Response;

public class UserTests {
	
	CreateUser_pojo pojo;
	
	@BeforeClass
	public void CreateUserData() {
		
		
                  pojo =new CreateUser_pojo();
		
		pojo.setEmail("suyash@gmail.com");
		pojo.setFirstName("Suyash");
		pojo.setId(7001);
		pojo.setLastName("Gore");
		pojo.setPassword("Target@7001");
		pojo.setPhone("9689494747");
		pojo.setUserStatus(0);
		pojo.setUsername("abc");
		
	}
	
	@Test(priority=1)
	public void test_Create_User() {
		
				Response response=UserEndPoints.createuser(pojo);
		
		response.then().log().all().statusCode(200);
			
		
	}
	
	@Test(priority=2)
	public void test_Get_user() {
		
		Response response=UserEndPoints.get_user_name(this.pojo.getUsername());
		
		response.then().log().all().statusCode(200);
		
	}
	
	
	@Test(priority=3)
public void test_update_user() {
		
		
		pojo.setEmail("123#gmail.com");
		pojo.setFirstName("Deva Gore");
		
		Response response=UserEndPoints.update_user(this.pojo.getUsername(),pojo);
		
		response.then().log().all().statusCode(200);
		
	}
	

	@Test(priority=4)
	public void test_delete_user() {
		
		Response response=UserEndPoints.delete_user_name(this.pojo.getUsername());
		
		response.then().log().all().statusCode(200);
		
	}
		

}
