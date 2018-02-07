package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import database.ConnectionFactory;

public class PatientDAO implements PatientInterface {

	@Override
	public void insertPatient() {
		// TODO Auto-generated method stub

	}

	@Override
	  public ArrayList<String> fetchDetails(String email, Connection conn) throws SQLException{
		   String sql;
		   String email1 = null;
		   ArrayList<String> ar= new ArrayList<String>();
		   //int id = 0;
		      //sql = "SELECT * FROM patient where patient.email = email";
		   //System.out.println(stmt==null);
		   Statement stmt = (Statement) conn.createStatement();
		      ResultSet rs = stmt.executeQuery("SELECT * FROM patient where patient.email = \"" + email + "\"");
		      while(rs.next()) {
		    	   //id = rs.getInt(1);
		    	 ar.add(rs.getInt(1)+"");
		    	 ar.add(rs.getString(2)+"");
		    	 ar.add(rs.getString(3));
		    	 ar.add(rs.getString(4));
		    	 ar.add(rs.getString(5));  
		      }		     
		   
		
		return ar;
	   }	/*public int fetchDetailsByPhone(String phone) throws SQLException{
		String sql;
		int id = 0;
		//sql = "SELECT * FROM patient where patient.email = email";
		//System.out.println(stmt==null);
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM patient where patient.phone = \"" + phone + "\"");
		while(rs.next()) {
			id = rs.getInt(1);
			// System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getDate(5));  
		}		     
		return id;
	}*/

	

	//@Override
	/*public String fetchDetails(String email, Connection conn)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}*/

}


