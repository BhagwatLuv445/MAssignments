/*package zebraFrame.API;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;



public class GetRequest {

	//Simple get request
	@Test
	public void test_01(){

		Response resp = when().get("api.openweathermap.org/data/2.5/weather");
		Assert.assertEquals(resp.getStatusCode(), 200);
	}
	
	//How to use Paramaters using Rest Assured
	
	@Test
	public void test_03(){
		Response resp = (Response) given().
				param("id","2172797").
				param("appid","8d69d2803b9bd38f2eb7664d58aa88e3").
				when().get("api.openweathermap.org/data/2.5/weather");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
		
		if(resp.getStatusCode() == 200){
			System.out.println("API is working fine");
		}else{
			System.out.println("API is not working fine");
		}
				
	}
	
	//Assert in our Testcase in rest assured
	@Test
	public void test_04(){
		given().
		param("q", "london").
		param("apid", "8d69d2803b9bd38f2eb7664d58aa88e3").
		when().
		get("api.openweathermap.org/data/2.5/weather").then().assertThat().statusCode(200);
	}
	
	
	//To show all the response data--> asString()
	@Test
	public void test_05(){
		Response resp = given().
				param("qa", "bhopal").				
				param("key","8d69d2803b9bd38f2eb7664d58aa88e3").
				when().
				get("api.openweathermap.org/data/2.5/weather");
		
		System.out.println("Response Data is:" + resp.asString());
	}
	
	
	//Extracting info and check whether the response is json or not
	@Test
	public void test_06(){
		Response resp = given().
				param("", "").
				param("key", "8d69d2803b9bd38f2eb7664d58aa88e3").
				when().
				get("api.openweathermap.org/data/2.5/weather");
		
		String actualReport = resp.
				then().
				contentType(ContentType.JSON).extract().path("weather[0].description");
		
		String ExpectedReport = null;
		if(actualReport.equalsIgnoreCase(ExpectedReport)){
			System.out.println("Test Pass");
		}else{
			System.out.println("Test Fail");
		}
	}
}
*/