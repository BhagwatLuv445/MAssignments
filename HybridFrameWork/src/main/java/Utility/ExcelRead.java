package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static Sheet readExcel(String filePath, String fileName, String sheetName) throws IOException {
		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook Workbook = null;
		Workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = Workbook.getSheet(sheetName);
		return sheet;
	}
	
	public static Object[][] getData(String sheetName) throws Exception 
	{
		Sheet sheet = readExcel(System.getProperty("user.dir") + "\\", "TestCase.xlsx", sheetName);

		int nC = sheet.getRow(0).getLastCellNum();
		int size = sheet.getLastRowNum();
		Object[][] dataExcel = new Object[size][1];
		int arrSize = 0;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) 
		{
			HashMap<String, String> data = new HashMap<String, String>();
			int rowNum = i;

			if (sheet.getRow(rowNum).getCell(0).getStringCellValue().equalsIgnoreCase("GOTOURL")) 
			{
				String key = sheet.getRow(0).getCell(0).getStringCellValue();
				String val = sheet.getRow(rowNum).getCell(0).getStringCellValue();
				String key1 = sheet.getRow(0).getCell(4).getStringCellValue();
				String val1 = sheet.getRow(rowNum).getCell(4).getStringCellValue();				
				data.put(key, val);				
				data.put(key1, val1);
			} else 
			{
				for (int j = 0; j < nC; j++) 
				{
					String key = sheet.getRow(0).getCell(j).getStringCellValue();					
					String val = sheet.getRow(rowNum).getCell(j).getStringCellValue();					
					data.put(key, new String(val));
				}
			}
			dataExcel[arrSize][0] = data;
			arrSize++;
		}
		return dataExcel;
	}
}
