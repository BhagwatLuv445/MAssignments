package com.ferrari.utility;

public class DateUtil {

	public static String getDay(String date){
		String[] dateArray = date.split("-");
		return dateArray[0];
	}
	
	public static String getMonth(String date){
		String[] dateArray = date.split("-");
		return dateArray[1];	
	}
	
	public static String getYear(String date){
		String[] dateArray = date.split("-");
		return dateArray[2];	
	}
}
