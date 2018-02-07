package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.mindtree.entity.Patient;
import com.mindtree.entity.Test;

public class PatientTestDao {

	ArrayList<Test> arr = new ArrayList<>();

	public void insertDetails(int tid, int pid, Connection conn) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		Date date = new Date();

		String current = (String) dateFormat.format(date);

		try {

			Statement stmt = conn.createStatement();
			// System.out.println("insert into patient_test (p_id,t_id,date)
			// values ('"+pid + "', '" + tid +"', '" + current +"')");

			stmt.executeUpdate("insert into patient_test (p_id,t_id,date) values ('" + pid + "', '" + tid + "', '"
					+ current + "')");

			System.out.println("Details added to the database!");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public ArrayList<Test> fetchAllDetails(String date, Connection conn, int pid) {

		try {

			Statement stmt = conn.createStatement();
			// System.out.println(( "select * patient_test where
			// patient_test.date = '" + date +"'"));

			ResultSet rs = stmt.executeQuery(
					"select test.name,test.cost from test join patient_test on test.t_id = patient_test.t_id join patient on patient.p_id = patient_test.p_id where patient_test.p_id = '"
							+ pid + "' and patient_test.date = '" + date + "'");

			while (rs.next()) {

				Test t = new Test();

				t.setTestName(rs.getString(1));

				t.setCost(rs.getInt(2));

				arr.add(t);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;

	}

}
