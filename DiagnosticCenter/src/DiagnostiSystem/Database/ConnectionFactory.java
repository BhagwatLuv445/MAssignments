package DiagnostiSystem.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ConnectionFactory {

	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/Diagnostic_db";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "Welcome123";
	   
	   Connection conn = null;
	   Statement stmt = null;
	   
	   public Connection getConnection() {
	   try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		stmt = conn.createStatement();
	   }catch (ClassNotFoundException e) {
		e.printStackTrace();
	   }
	   catch(SQLException s){
		   System.out.println("SQL error");
	   }
	return conn;
	 }

}
