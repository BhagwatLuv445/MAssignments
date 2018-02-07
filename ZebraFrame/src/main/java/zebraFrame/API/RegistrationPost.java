package zebraFrame.API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RegistrationPost {

	public String SuccessCode = "OPERATION_SUCCESS";
	public String Message = "Operation completed successfully";
	String FaultId = "User already exists";
	String fault = "FAULT_USER_ALREADY_EXISTS";

	@BeforeClass
	public void setProxy() {
		System.setProperty("http.proxyHost", "172.17.2.218");
		System.setProperty("http.proxyPort", "8085");
	}

	@Test
	public void postData() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		// create a json object which contains all the fields
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Avanish");
		requestParams.put("LastName", "Kumar");
		requestParams.put("UserName", "AvanishK");
		requestParams.put("Password", "9752509091");
		requestParams.put("Email", "Shubham@gmail.com");

		// add a header stating that body is of json
		request.header("Content-Type", "application/json");

		// add the json to the body of the request
		request.body(requestParams.toJSONString());

		// post the body
		Response response = request.post("/register");
		ResponseBody body = response.getBody();
		System.out.println(response.body().asString());
		int statusCode = response.getStatusCode();

		if (statusCode == 200) {
			RegistrationPost responseBody = body.as(RegistrationPost.class);
			Assert.assertEquals("User already exists", responseBody.FaultId);
			Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody.fault);
		} else if (statusCode == 201) {
			RegistrationPost responseBody = body.as(RegistrationPost.class);
			Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
			Assert.assertEquals("Operation completed successfully", responseBody.Message);
		} /*
			 * System.out.println("status code" + statusCode);
			 * Assert.assertEquals(statusCode, 200, "statusCode pass"); String
			 * successCode = response.jsonPath().get("SuccessCode");
			 * 
			 * System.out.println(response.body().asString());
			 */
	}

}
