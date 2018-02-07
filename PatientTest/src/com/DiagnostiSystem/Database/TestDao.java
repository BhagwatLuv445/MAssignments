package com.DiagnostiSystem.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestDao {

	public int fetchTestDetails(String testName, Connection conn) throws SQLException
	{
		int tid =-1;
		   boolean flag = false;
		   Statement stmt = (Statement) conn.createStatement();
		      ResultSet rs = stmt.executeQuery("SELECT name FROM test");
		      while(rs.next()) {
		    	   if(rs.getString(1).equals(testName)){
		    		  flag = true;
		    		
		    	   }
		      }		  
		      
		      if(flag){
			      ResultSet rs1 = stmt.executeQuery("SELECT T_ID FROM test where name= '" + testName +"'");
			   	  while(rs1.next())
			   				tid = rs1.getInt(1);
		      }
		return tid;		   
}
}
