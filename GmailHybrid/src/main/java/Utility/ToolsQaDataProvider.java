package Utility;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class ToolsQaDataProvider {

	@DataProvider(name = "hybridData")
	public static Object[][] getToolsQaData() throws IOException
	{
		Object[][] map = ExcelRead.getDataFromDataprovider("KeywordFramework");
		return map;
	}

}
