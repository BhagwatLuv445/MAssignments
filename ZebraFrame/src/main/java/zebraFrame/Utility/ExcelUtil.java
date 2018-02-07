package zebraFrame.Utility;

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
	
	/*public static void setExcelFile(String filePath) throws Exception {
		// File file = new File(filePath+ "\\" + fileName);

		FileInputStream excelFile;
		try {
			this.filePath = filePath;
			
			excelFile = new FileInputStream(filePath);

			excelWBook = new XSSFWorkbook(excelFile);

		} catch (Exception e) {
			throw (e);
		}

	}*/
	
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
	
	/*public static String getCellData(int rowNum, int colNum){
		try{
			cell = excelWSheet.getRow(rowNum).getCell(colNum);
			cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
			String cellData = cell.getStringCellValue();
			return cellData;
		}catch(Exception e){
			return "";
		}
	}*/
	
	public static HashMap<String, List<String>> getMap(String sheetName) {
		
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
	}
}
