package com.DiagnostiSystem.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Patient;

public class PatientDao {

	static Patient p = new Patient();
	public int fetchPatientDetailsByEmail(String email, Connection conn) throws SQLException{
		   int pid =-1;
		   boolean flag = false;
		   Statement stmt = (Statement)conn.createStatement();
		      ResultSet rs = stmt.executeQuery("SELECT EMAIL FROM patient");
		      while(rs.next()) {
		    	   if(rs.getString(1).equals(email)){
		    		  flag = true;
		    		
		    	   }
		      }		  
		      
		      if(flag){
			      ResultSet rs1 = stmt.executeQuery("SELECT P_ID FROM patient where EMAIL= '" + email +"'");
			   	  while(rs1.next())
			   				pid = rs1.getInt(1);
		      }
		return pid;		   
}

	public int fetchPatientDetailsByPhone(String phone, Connection conn) throws SQLException
	{
	
		
		int pid =-1;
		   boolean flag = false;
		   Statement stmt = (Statement) conn.createStatement();
		      ResultSet rs = stmt.executeQuery("SELECT PHONE FROM patient");
		      while(rs.next()) {
		    	   if(rs.getString(1).equals(phone)){
		    		  flag = true;
		    		
		    	   }
		      }		  
		      
		      if(flag){
			      ResultSet rs1 = stmt.executeQuery("SELECT P_ID FROM patient where PHONE= '" + phone +"'");
			   	  while(rs1.next())
			   				pid = rs1.getInt(1);
		      }
		return pid;	
	
}
	public Patient getName(String choose,Connection conn) throws SQLException{
		 
		  //ArrayList<String> ar = new ArrayList<>();
		  	String name = null;
			String email = null;
			String phone = null;
		  Statement stmt = (Statement) conn.createStatement();
	      ResultSet rs = stmt.executeQuery("SELECT name, EMAIL, phone FROM patient where email = '" + choose +"'");
	      while(rs.next()){
	    	  name = rs.getString(1);
	    	  email = rs.getString(2);
	    	  phone = rs.getString(3);
	      }
		 p.setName(name);
		 p.setEmail(email);
		 p.setPhone(phone);
	    	  return p;
	}
	
	public Patient getPhone(String choose,Connection conn) throws SQLException{
		 
		String name = null;
		String email = null;
		String phone = null;
		 // ArrayList<String> ar = new ArrayList<>();
		  Statement stmt = (Statement) conn.createStatement();
	      ResultSet rs = stmt.executeQuery("SELECT name, EMAIL, phone FROM patient where phone = '" + choose +"'");
	      while(rs.next()){
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
