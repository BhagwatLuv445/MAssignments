package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	private static String fileName = "TestCase.xlsx";
	private static File file;
	private static FileInputStream fileInput;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	private static boolean createWorkbook()
	{
		if (fileName == null)
		{
			System.out.println(null +" Excel file name not provided");
			return false;
		}
		file = new File(System.getProperty("user.dir")+"//src//test//java//Resources//" + fileName);
		try
		{
			fileInput = new FileInputStream(file);
			workbook = new XSSFWorkbook(fileInput);
			return true;
		}
		catch(FileNotFoundException e)
		{
			System.out.println();
		}
		catch(IOException io)
		{
			System.out.println();
		}
		return false;		
	}
	
	public static boolean createSheet(String sheetName){
		if(!createWorkbook())
		{
			return false;
		}
		sheet = workbook.getSheet(sheetName);
		return true;
	}
	
	public static int getRowCount(){
		if(sheet == null){
			return -1;
		}
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int getFirstRow(){
		if(sheet == null){
			return -1;
		}
		return sheet.getFirstRowNum();
	}
	
	public static int getCellCount(int rowNumber){
		if(sheet == null){
			return -1;
		}
		return sheet.getRow(rowNumber).getPhysicalNumberOfCells();
	}
	
	public static int getFirstCell(int rowNumber){
		if(sheet == null){
			return -1;
		}
		return sheet.getRow(rowNumber).getFirstCellNum();
	}
	
	public static String getCellData(int rowNumber, int cellNumber)
	{
		if(sheet == null || rowNumber < 0 || cellNumber < 0)
		{
			return null;
		}
		return new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
	}
}
