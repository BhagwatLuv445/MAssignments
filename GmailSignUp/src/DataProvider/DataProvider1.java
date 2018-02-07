package DataProvider;

import org.testng.annotations.DataProvider;

public class DataProvider1 {

	@DataProvider(name = "Authentication")

	public static Object[][] credentials() {

		return new Object[][] { {}, {}, {} };
		

	}
}
