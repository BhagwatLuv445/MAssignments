package hipackage;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Rest {

	@BeforeClass
	public void setProxy()
	{
		System.setProperty("http.proxyHost", "172.17.2.218");
		System.setProperty("http.proxyPort", "8085");
	}
	
	@Test
	public void test_NumberOfCircuitsFor2017Season_ShouldBe20() 
	{
	        
	    given().
	    when().
	        get("http://ergast.com/api/f1/2017/circuits.json").
	    then().
	        assertThat().	        
	        body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
	}
	
	@Test
	public void test_ResponseHeaderData_ShouldBeCorrect()
	{
		given().
		when()
			.get("http://ergast.com/api/f1/2017/circuits.json").
		then().
			assertThat().
			statusCode(200).
		and().
			contentType(ContentType.JSON).
		and().
			header("Content-Length", equalTo("4551"));		
	}
	
	@Test
	public void test_Md5CheckSumForTest_ShouldBe098f6bcd4621d373cade4e832627b4f6() 
	{
		String originalText = "test";
		String expectedMd5CheckSum = "098f6bcd4621d373cade4e832627b4f6";
		
		given().
			param("text",originalText ).
		when().
			get("http://md5.jsontest.com").
		then().
			assertThat().
			body("md5",equalTo(expectedMd5CheckSum));
	}
	
	@Test
	public void test_NumberOfCircuits_ShouldBe20_Parameterized() 
	{
		String season = "2017";
		
		given().
			pathParam("raceSeason",season).
		when().
			get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
		then().
			assertThat().body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
	}
}
