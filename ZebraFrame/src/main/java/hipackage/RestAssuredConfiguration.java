package hipackage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestAssuredConfiguration {

	
/*	@BeforeSuite
	public void setProxy(){
		System.setProperty("http.proxyHost", "172.17.2.218");
		System.setProperty("http.proxyPort", "8085");
	}*/
	/*@BeforeMethod
	public void config() {
		System.setProperty("http.proxyHost", "172.17.2.218");
		System.setProperty("http.proxyPort", "8085");
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		//RestAssured.port = 8085;
		//RestAssured.basePath = "/Ferrari/men/catageory";
	}*/

	public RequestSpecification getRequestSpecification() {
		return RestAssured.given().contentType(ContentType.JSON);
	}
}
