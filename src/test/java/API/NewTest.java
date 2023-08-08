package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class NewTest {


	/*	public static void main(String[] args) {

		Response r1=RestAssured.get("https://reqres.in/api/users?page=2");

		System.out.println(r1.getStatusCode());

		System.out.println(r1.getStatusLine());

		System.out.println(r1.body().asString());

		System.out.println(r1.headers());
	}

	 */


	@Test(enabled=false)
	public void getmethod() {

		Response r1=RestAssured.get("https://reqres.in/api/users?page=2");

		System.out.println(r1.getStatusCode());

		System.out.println(r1.getStatusLine());

		System.out.println(r1.body().asString());

		System.out.println(r1.headers());

		Assert.assertEquals(200,r1.getStatusCode());
	}
	
	
	@Test
	public void getmethod_bddstyle() {
		
		RestAssured.useRelaxedHTTPSValidation();
		given().
		when().get("https://reqres.in/api/users?page=2").
		then().statusCode(200).statusLine("HTTP/1.1 200 OK").header("Content-Type","application/json; charset=utf-8")
		.body("data.id[2]",equalTo(9)).body("data.first_name",hasItems("Byron"));
		
	}





@Test(enabled=false)
	public void post(String name, String job) {
		/*
		 * JSONObject data=new JSONObject();
		 * 
		 * data.put("name", name);
		 * 
		 * data.put("job",job);
		 * 
		 * System.out.println(data);
		 * 
		 * given().when().body(data.toJSONString()).put("https://reqres.in/api/users/2")
		 * .then().statusCode(200); }
		 * 
		 * @DataProvider(name="dpadd")
		 * 
		 * public Object[][] getdata(){
		 * 
		 * Object[][] t1=new Object[][] {
		 * 
		 * {"aaaaa","SDET"}, {"bbbbb","developer"}, {"ccccc","tester"}
		 * 
		 * 
		 * 
		 * };
		 * 
		 * 
		 * return t1;
		 */
	}
	
	
	@Test(enabled=false)
	public void delete() {
		
		
		given().when().delete("https://reqres.in/api/users/2").then().statusCode(204);
		
		
		
		
		
	}
	
	@Test
	public void auth() {
		
		RestAssured.useRelaxedHTTPSValidation();
		String data="postman:password";
		
		/*
		 * byte[] encodevalue=Base64.encodeBase64(data.getBytes());
		 * 
		 * String encodedString =new String(encodevalue);
		 * 
		 * given().header("Authorization","Basic "+encodedString).
		 * when().get("https://postman-echo.com/basic-auth"). then().statusCode(200);
		 */
		
		
		
	}

	
}