package hipackage;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTest {

	String endPoint = "id";
	String GET_EMPLOYEE_PATH_PARAM ="http://restapi.demoqa.com/utilities/weather/{city}";
	@BeforeSuite
	public void setProxy() {
		System.setProperty("http.proxyHost", "172.17.2.218");
		System.setProperty("http.proxyPort", "8085");
	}

	@Test
	public void getData() {
		//RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/{city}";
		// RequestSpecification httpRequest = RestAssured.given();
		RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
		requestSpecification.pathParam("city", "Bhopal").log().all();
		requestSpecification.given().spec(requestSpecification).get(GET_EMPLOYEE_PATH_PARAM).then().statusCode(200).log().all();

		// Response response = httpRequest.request(Method.GET, "/1");

	}
}
