package zebraFrame.API;

import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetWeatherDetails {

	@BeforeClass
	public void setProxy() {
		System.setProperty("http.proxyHost", "172.17.2.218");
		System.setProperty("http.proxyPort", "8085");
	}

	@Test
	public void getWeather() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/Bhopal");

		// get response body
		String responseBody = response.getBody().asString();
		System.out.println("Response Body:->" + responseBody);

		// get and check the status code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200, "Status code is correct");
		System.out.println("Status code " + statusCode);

		// get the status line
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.0 200 OK", "Status Line is correct");
		System.out.println("StatusLine " + statusLine);

		// get response header
		String content_Type = response.header("Content-Type");
		System.out.println("Content-Type:" + content_Type);
		String server = response.header("Server");
		System.out.println("Server Type :" + server);
		String encodingType = response.header("Content-Encoding");
		System.out.println("Encoding Type:" + encodingType);

		/*
		 * //get all headers Headers header = response.headers(); for(Header
		 * head : header){ System.out.println(head.getName() + "\t" +
		 * head.getValue()); }
		 */

		// to read all the node of response we use jsonPath
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println("City : " + jsonPathEvaluator.get("City"));
		System.out.println("Temperature : " + jsonPathEvaluator.get("Temperature"));
		System.out.println("Humidity : " + jsonPathEvaluator.get("Humidity"));
		System.out.println("WeatherDescription" + jsonPathEvaluator.get("WeatherDescription"));
		System.out.println("WindSpeed : " + jsonPathEvaluator.get("WindSpeed"));
		System.out.println("WindDirectionDegree : " + jsonPathEvaluator.get("WindDirectionDegree"));
		/*
		 * "City": "Bhopal", "Temperature": "17 Degree celsius", "Humidity":
		 * "63 Percent", "WeatherDescription": "few clouds", "WindSpeed":
		 * "1.5 Km per hour", "WindDirectionDegree": "50 Degree"
		 */

	}
}
