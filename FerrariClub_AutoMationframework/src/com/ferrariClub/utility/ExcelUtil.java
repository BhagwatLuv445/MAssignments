package com.ferrariClub.utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	//private static XSSFRow Row;

	public static void setExcelFile(String filePath, String sheetName) throws Exception {
		// File file = new File(filePath+ "\\" + fileName);

		FileInputStream excelFile;
		try {
			excelFile = new FileInputStream(filePath);

			ExcelWBook = new XSSFWorkbook(excelFile);

			ExcelWSheet = ExcelWBook.getSheet(sheetName);
		} catch (Exception e) {
			throw (e);
		}

	}
	
	public static String getCellData(int rowNum, int colNum){
		try{
			Cell = ExcelWSheet.getRow(rowNum).getCell(colNum);
			Cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
			String cellData = Cell.getStringCellValue();
			return cellData;
		}catch(Exception e){
			return "";
		}
	}
}
