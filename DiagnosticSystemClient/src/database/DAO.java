package database;

import java.sql.*;
import java.util.ArrayList;

import com.mindtree.entity.Patient;
import com.mindtree.entity.Patient_Test;



public class DAO {

	  // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/Diagnostic_db";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "Welcome123";
	   
	   Connection conn = null;
	   Statement stmt = null;
	   
	   public DAO() {
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		stmt = conn.createStatement();
	   }catch (ClassNotFoundException e) {
		e.printStackTrace();
	   }
	   catch(SQLException s){
		   System.out.println("SQL error");
	   }
	 }
	   public ArrayList<String> fetchDetails(String email, Connection conn) throws SQLException{
		   String sql;
		   String email1 = null;
		   ArrayList<String> ar= new ArrayList<String>();
		   //int id = 0;
		      //sql = "SELECT * FROM patient where patient.email = email";
		   //System.out.println(stmt==null);
		      ResultSet rs = stmt.executeQuery("SELECT * FROM patient where patient.email = \"" + email + "\"");
		      while(rs.next()) {
		    	   //id = rs.getInt(1);
		    	 ar.add(rs.getInt(1)+"");
		    	 ar.add(rs.getInt(2)+"");
		    	 ar.add(rs.getString(3));
		    	 ar.add(rs.getString(4));
		    	 ar.add(rs.getString(5));  
		      }		     
		   
		
		return ar;
	   }
	   public int fetchDetailsByPhone(String phone) throws SQLException{
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
	   }
	   public int fetchDetailsTest(String testName) throws SQLException{
		
		   int id = 0;
		      ResultSet rs = stmt.executeQuery("SELECT * FROM test where test.name = \"" + testName + "\"");
		      while(rs.next()) {
		    	   id = rs.getInt(1);
		    	 System.out.println(rs.getInt(1));//+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getDate(5));  
		      }		     
		   return id;
	   }
	   public int insertIntoPatient_Test(ArrayList<Patient_Test> arrayList) throws SQLException{
		   String insert = "insert into patient_test values(?,?,?)";
		   PreparedStatement ps = conn.prepareStatement(insert); 
		  for(int i=0;i<arrayList.size();i++){
			   //System.out.println(arrayList.get(i).getPid()+" "+arrayList.get(i).getTid()+" "+arrayList.get(i).getDate());
			   ps.setInt(1, arrayList.get(i).getPid());
			   ps.setInt(2,arrayList.get(i).getTid());
			   ps.setString(3,arrayList.get(i).getDate());
			   ps.addBatch();			    
		   }
		   int a=0;
		   if(ps.executeBatch() != null){
			   a=1;
		   }
		   
      
		   return a;		  
	   }
}