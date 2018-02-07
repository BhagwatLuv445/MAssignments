package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PatientInterface {

	public void insertPatient();
	
//	String fetchPatient(String email) throws SQLException;

	//ArrayList<String> fetchPatient(String email, Connection conn) throws SQLException;

	ArrayList<String> fetchDetails(String email, Connection conn) throws SQLException;
}
