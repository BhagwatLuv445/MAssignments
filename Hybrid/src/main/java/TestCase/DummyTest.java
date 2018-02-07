package TestCase;

import Utility.Excel;

public class DummyTest 
{

	protected static String Name, Number;


	public static void runTest()
	{
		Excel.createSheet("Sheet1");

		for(int i = 1; i < Excel.getRowCount();i++)
		{
			Name = Excel.getCellData(i, 0);
			Number = Excel.getCellData(i, 1);
			System.out.println(Name +"--- " + Number);

		}
	}
	
	public static void main(String[] args) {
		runTest();
	}
}
