import java.util.Date;

class D {
	public void difference(Date d1, Date d2) {

		long diff = Math.abs(d1.getTime()-d2.getTime());
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000)%31;
		long diffMonth = diff / (12 * 24 * 60 * 60 * 1000)%12;
		long diffYear = diff / (12 * 24 * 60 * 60 * 1000);

		System.out.print(diffYear + " Year, ");
		System.out.print(diffMonth + " Month, ");
		System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");
	}
}

public class DateDiff {
	public static void main(String[] args) {

		D d = new D();
		d.difference(new Date(04,01,2018), new Date(01,01,1994));
	}
}
