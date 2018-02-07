package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PatientDao {

	public int fetchPatientDetailsByEmail(String email, Connection conn) throws SQLException {
		int pid = -1;
		boolean flag = false;
		Statement stmt = (Statement) conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMAIL FROM patient");
		while (rs.next()) {
			if (rs.getString(1).equals(email)) {
				flag = true;

			}
		}

		if (flag) {
			ResultSet rs1 = stmt.executeQuery("SELECT P_ID FROM patient where EMAIL= '" + email + "'");
			while (rs1.next())
				pid = rs1.getInt(1);
		}
		return pid;
	}

	public int fetchPatientDetailsByPhone(String phone, Connection conn) throws SQLException {

		int pid = -1;
		boolean flag = false;
		Statement stmt = (Statement) conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT PHONE FROM patient");
		while (rs.next()) {
			if (rs.getString(1).equals(phone)) {
				flag = true;

			}
		}

		if (flag) {
			ResultSet rs1 = stmt.executeQuery("SELECT P_ID FROM patient where PHONE= '" + phone + "'");
			while (rs1.next())
				pid = rs1.getInt(1);
		}
		return pid;

	}
}
