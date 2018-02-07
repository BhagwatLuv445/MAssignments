package DummyFramework.TestData;

import org.testng.annotations.DataProvider;

public class Ferrari_f1_DataProvider {

	@DataProvider(name = "F1DataProvider")
	public static Object[][] credentials() {

		return new Object[][] { { "Bhagwat", "Prajapati", "Vegetarian", "Visa", "5567899990123456", "11", "2010",
				"Bhagwat", "", "Prajapati", "Bhopal", "M.P.", "462047", "UNITED STATES" } };
	}
}
