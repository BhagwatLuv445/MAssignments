package hipackage;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FerrariAPI {

	@BeforeClass
	public void setProxy()
	{
		System.out.println("hello");
		System.setProperty("http.proxyHost", "172.17.2.218");
		System.setProperty("http.proxyPort", "8085");
		System.out.println("hi");
	   // RestAssured.baseURI = "https://ferrariclubserverdev.azurewebsites.net";
	}
	
	@Test
	public void menCategoryTest()
	{
		String pathParam = "1";
		given().
		 pathParam("id", pathParam).
			when().
				get("https://ferrariclubserverdev.azurewebsites.net/Ferrari/men/catageory/{id}").
		then().
			assertThat().
			statusCode(200);
	}
}
