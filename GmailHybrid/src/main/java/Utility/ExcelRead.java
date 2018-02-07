package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelRead {

	public static Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException
	{
		File file =    new File(filePath+"\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook Workbook = null;
		Workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = Workbook.getSheet(sheetName);
		return sheet;    
	}

	public static Object[][] getDataFromDataprovider(String sheetName) throws IOException
	{
		Object[][] object = null;
		Sheet sheet = readExcel(System.getProperty("user.dir") + "\\", "TestCase.xlsx", sheetName);
		//Find number of rows in excel file
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		object = new Object[rowCount][6];
		for (int i = 0; i < rowCount; i++) 
		{
			//Loop over all the rows
			Row row = sheet.getRow(i+1);
			//Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) 
			{
				//Print excel data in console
				object[i][j] = getCellData(row,j);
			}
		}		
		return object;    
	}

	public static String getCellData(Row row, int cellNumber) 
	{
		return new DataFormatter().formatCellValue(row.getCell(cellNumber));
	}



	/*	public static Object[][] getData(String sheetName) throws Exception {

		Sheet sheet = readExcel(System.getProperty("user.dir") + "\\", "TestCase.xlsx", sheetName);

		int nC = sheet.getRow(0).getLastCellNum();
		int size = 0;

		for(int k=0; k<=sheet.getLastRowNum(); k++) {			
				size++;
		}
				Object[][] dataExcel = new Object[size][1];

		int arrSize = 0;
		for(int i=1; i<=sheet.getLastRowNum(); i++) {			
			{				
				HashMap<String, String> data = new HashMap<String, String>();
				int rowNum = i;

				for(int j=0; j<nC-1; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String val = getCellData(sheet.getRow(i),j);
//					System.out.println(getCellData(sheet.getRow(i),j));
					data.put(key,new String(val));	
				}
				dataExcel[arrSize][0] = data;
				arrSize++;
			}
		}
		return dataExcel;		
	}*/

}