import java.util.Calendar;
import java.util.Date;


class Date1 {

	public void diff(Date d1, Date d2) {

		
		long differInMilliSeconds = Math.abs(d1.getTime() - d2.getTime());
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(differInMilliSeconds);
		long days = differInMilliSeconds/(24*60*60*1000);
		System.out.println(days);
		/*
		int year = cal.get(Calendar.YEAR)-1970;
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);*/
		/*System.out.println("Difference between dates");
		System.out.println("YEAR  :"+year);
		System.out.println("Month :"+month);
		System.out.println("Day   :"+day);*/
	}
}

public class DateDifference {
	public static void main(String[] args) {
		/*Date d1 = new Date();
		Date d2 = new Date(2018,0,01);
		long differInMilliSeconds = d1.getTime();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(differInMilliSeconds);
		int year = cal.get(Calendar.YEAR)-1970;
		System.out.println(year)*/;
		Date1 d = new Date1();
		d.diff(new Date(2018,12,12),new Date(2018,12,9));		
	}
}

