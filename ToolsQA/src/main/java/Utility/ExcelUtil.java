package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static XSSFSheet excelWSheet;

	private static XSSFWorkbook excelWBook;

//	private static XSSFCell cell;

	private static XSSFRow row;
	
	private static String filePath = null;

	public static void setExcelFile(String filePath) throws Exception {
		// File file = new File(filePath+ "\\" + fileName);

		FileInputStream excelFile;
		try {
			excelFile = new FileInputStream(filePath);

			excelWBook = new XSSFWorkbook(excelFile);

//			excelWSheet = excelWBook.getSheet(sheetName);
		} catch (Exception e) {
			throw (e);
		}

	}
		
	public String getData(String sheetName, String colName, int rowNum) {
		
		excelWSheet = excelWBook.getSheet(sheetName);
		row = excelWSheet.getRow(0);
		int colNum = -1;
		
		for(int i=0; i<row.getLastCellNum(); i++) {
			if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
				colNum = i;
		}
		
		row = excelWSheet.getRow(rowNum);
		String data = row.getCell(colNum).getStringCellValue();
		
		return data;
	}
	
	public void setData(String sheetName, String colName, int rowNum, String value) {
		
		try {
			excelWSheet = excelWBook.getSheet(sheetName);
			row = excelWSheet.getRow(0);
			int colNum = -1;
			
			for(int i=0; i<row.getLastCellNum(); i++) {
				if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
					colNum = i;
			}
			
			row = excelWSheet.getRow(rowNum);
			
			row.createCell(colNum).setCellValue(value);
			/*row.createCell(colNum).setCellValue("hd");*/
			FileOutputStream fout = new FileOutputStream(filePath);
			excelWBook.write(fout);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	/*public static HashMap<String, List<String>> getMap(String sheetName) {
		
		HashMap<String, List<String>> myMap = new HashMap<String, List<String>>();
		
		List<String> data = new ArrayList<String>();
		
		excelWSheet = excelWBook.getSheet(sheetName);
		
		for(int i=0; i<excelWSheet.getRow(0).getLastCellNum(); i++) {
			data.clear();
			
			for(int j=1; j<=excelWSheet.getLastRowNum(); j++) {
				data.add(excelWSheet.getRow(j).getCell(i).getStringCellValue());
			}
			
			String cName = excelWSheet.getRow(0).getCell(i).getStringCellValue();
			myMap.put(cName, new ArrayList<String>(data));
			
		}
		
		return myMap;
	}*/
	
	public static Object[][] getData(String testName) throws Exception {

		setExcelFile("./Resources/com/Ferrari_F1_Club/TestData/MercuryData.xlsx");
		excelWSheet = excelWBook.getSheet(testName);

		int nC = excelWSheet.getRow(0).getLastCellNum();
		int size = 0;
		
		for(int k=0; k<=excelWSheet.getLastRowNum(); k++) {
			if(("YY").equals(excelWSheet.getRow(k).getCell(nC-1).getStringCellValue()))
				size++;
		}
				Object[][] dataExcel = new Object[size][1];
		
		int arrSize = 0;
		for(int i=1; i<=excelWSheet.getLastRowNum(); i++) {
			
			if(("YY").equals(excelWSheet.getRow(i).getCell(nC-1).getStringCellValue()))
			{				
				HashMap<String, String> data = new HashMap<String, String>();
				int rowNum = i;

				for(int j=0; j<nC-1; j++) {
					String key = excelWSheet.getRow(0).getCell(j).getStringCellValue();
					String val = excelWSheet.getRow(rowNum).getCell(j).getStringCellValue();
					
					data.put(key,new String(val));	
				}
				dataExcel[arrSize][0] = data;
				arrSize++;
			}
		}
		return dataExcel;		
	}
	
}
