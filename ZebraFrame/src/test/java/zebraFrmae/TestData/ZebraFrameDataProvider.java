package zebraFrmae.TestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.testng.annotations.DataProvider;

public class ZebraFrameDataProvider {

	protected static String filePath = "";
	private static Sheet excelWSheet;

	private static Workbook excelWBook;

	@DataProvider
	public static Object[][] credentials() {

		return new Object[][] { { "Bhagwat", "Prajapati", "Vegetarian", "Visa", "5567899990123456", "11", "2010",
				"Bhagwat", "", "Prajapati", "Bhopal", "M.P.", "462047", "UNITED STATES" } };
	}

	
	
	public static Object[][] getExcelData(String sheetName) {
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			excelWBook = WorkbookFactory.create(ip);
		} catch (InvalidFormatException i) {
			i.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		excelWSheet = excelWBook.getSheet(sheetName);
		Object[][] data = new Object[excelWSheet.getLastRowNum()][excelWSheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < excelWSheet.getLastRowNum(); i++) {
			for (int k = 0; i < excelWSheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = excelWSheet.getRow(i + 1).getCell(k).toString();
			}
		}

		return data;
	}
}
