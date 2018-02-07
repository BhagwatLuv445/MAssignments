package Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import com.mindtree.entity.Patient;
import com.mindtree.entity.Test;
import com.mindtree.exceptions.InvalidDateException;
import com.mindtree.exceptions.InvalidEmailIdException;
import com.mindtree.exceptions.InvalidPhoneNumberException;
import com.mindtree.exceptions.InvalidTestNameException;
import Database.ConnectionFactory;
import Database.PatientDao;
import Database.PatientTestDao;
import Database.TestDao;

public class DiagnosticSystemManager {

	PatientDao da = new PatientDao();
	TestDao ta = new TestDao();
	PatientTestDao pt = new PatientTestDao();
	Patient p = new Patient();

	// Test t = new Test();
	// check email id
	public int checkEmailId(String email, Connection conn) throws InvalidEmailIdException, SQLException {
		return da.fetchPatientDetailsByEmail(email, conn);

	}

	// check test name
	public int checkTestName(String testName, Connection conn) throws InvalidTestNameException, SQLException {

		return ta.fetchTestDetails(testName, conn);

	}

	// check phone number
	public int checkPhoneNumber(String phone, Connection conn) throws InvalidPhoneNumberException, SQLException {

		return da.fetchPatientDetailsByPhone(phone, conn);

	}

	public void insertDetails(int pid, int tid, Connection conn) {
		pt.insertDetails(tid, pid, conn);
	}

	public ArrayList<Test> checkTestDate(String testDate, Connection conn, int pid)
			throws ParseException, InvalidDateException {

		// ArrayList<String> ar = new ArrayList<>();
		ArrayList<Test> arr = new ArrayList<>();

		String[] newDateArray = testDate.split("-");

		String[] str = new String[] { newDateArray[2], newDateArray[1], newDateArray[0] };
		int yyyy = Integer.parseInt(str[0]);
		int mm = Integer.parseInt(str[1]);
		int dd = Integer.parseInt(str[2]);

		if (dd > 31 || mm > 12 || (yyyy < 2000 && yyyy > 9999)) {
			if (dd > 31) {
				throw new InvalidDateException("Invalid date");
			}
			if (mm > 12) {
				throw new InvalidDateException("Invalid date");
			}
			if ((yyyy > 2000 && yyyy < 9999)) {
				throw new InvalidDateException("Invalid date");
			}
		} else {

			String date = str[0] + "-" + str[1] + "-" + str[2];
			System.out.println(String.valueOf(date));

			arr = pt.fetchAllDetails(date, conn, pid);

		}
		return arr;

	}

	public Patient getName(String choose, Connection conn) throws SQLException {

		// ArrayList<String> ar = new ArrayList<>();
		String name = null;
		String email = null;
		String phone = null;
		Statement stmt = (Statement) conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT name, EMAIL, phone FROM patient where email = '" + choose + "'");
		while (rs.next()) {
			name = rs.getString(1);
			email = rs.getString(2);
			phone = rs.getString(3);
		}
		p.setName(name);
		p.setEmail(email);
		p.setPhone(phone);
		return p;
	}

	public Patient getPhone(String choose, Connection conn) throws SQLException {

		String name = null;
		String email = null;
		String phone = null;
		// ArrayList<String> ar = new ArrayList<>();
		Statement stmt = (Statement) conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT name, EMAIL, phone FROM patient where phone = '" + choose + "'");
		while (rs.next()) {
			name = rs.getString(1);
			email = rs.getString(2);
			phone = rs.getString(3);
		}
		p.setName(name);
		p.setEmail(email);
		p.setPhone(phone);
		return p;
	}
}
