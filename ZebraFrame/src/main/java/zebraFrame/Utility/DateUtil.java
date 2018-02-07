package zebraFrame.Utility;

public class DateUtil {

	//DateFormat---> DD-MM-YYYY
	public static String getDay(String date)
	{
	
		String[] dateArray = date.split("-");
		return dateArray[0];
	
	}
	
	public static String getMonth(String date)
	{
		String[] dateArray = date.split("-");
		return dateArray[1];	
	}
	
	public static String getYear(String date)
	{
		String[] dateArray = date.split("-");
		return dateArray[2];	
	}
	
	//DateFormat--->DD/MM/YYYY
	public static String getDayFromSlash(String date)
	{
		String[] dateArray = date.split("/");
		return dateArray[0];
	}
	
	public static String getMonthFromSlash(String date)
	{
		String[] dateArray = date.split("/");
		return dateArray[1];	
	}
	
	public static String getYearFromSlash(String date)
	{
		String[] dateArray = date.split("/");
		return dateArray[2];	
	}
}
