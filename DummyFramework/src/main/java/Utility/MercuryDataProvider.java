package Utility;

import org.testng.annotations.DataProvider;



public class MercuryDataProvider {
	@DataProvider(name = "mecuryDataProvider")
	public static Object[][] credentials() {

		return new Object[][] { { "Bhagwat", "Prajapati", "Vegetarian", "Visa", "5567899990123456", "11", "2010",
				"Bhagwat", "", "Prajapati", "Bhopal", "M.P.", "462047", "UNITED STATES" } };
	}
	@DataProvider(name="bookFlight")
	public Object[][] bookFlightData() throws Exception {

		Object[][] map = ExcelUtil.getData("BookFlightPage");
	
		return map;
	}
	@DataProvider(name="flightFinder")
	public Object[][] flightFinderData() throws Exception {

		Object[][] map = ExcelUtil.getData("FlightFinderPage");
	
		return map;
	}
	@DataProvider(name="selectFlight")
	public Object[][] selectFlightData() throws Exception {

		Object[][] map = ExcelUtil.getData("SelectFlightPage");
	
		return map;
	}
}
