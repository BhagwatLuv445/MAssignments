package zebraFrame.API;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthenticationBasics {

	@BeforeClass
	public void setProxy(){
		System.setProperty("http.proxyHost", "172.17.2.218");
		System.setProperty("http.proxyPort","8085");
	}
	
	@Test
	public void basicAuthentication(){
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get();
		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Status Message: " + response.body().asString());
	}
}

