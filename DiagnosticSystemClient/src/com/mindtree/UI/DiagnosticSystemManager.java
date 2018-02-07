package com.mindtree.UI;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mindtree.exceptions.InvalidEmailIdException;
import com.mysql.jdbc.Connection;

import database.DAO;
import database.PatientDAO;
public class DiagnosticSystemManager {


	PatientDAO da = new PatientDAO();
	
	public boolean getPatientByEmail(String email, Connection conn) throws InvalidEmailIdException, SQLException
	{
		ArrayList<String> ar= da.fetchDetails(email,conn);
	
		System.out.println(!(ar==null));
		
		boolean flag =false;
		
			for(String s:ar)
			{
				if(!s.equalsIgnoreCase(email))
				
					flag =true;
				
				}
			if(flag){
				
				return true;
				
			}
		return flag;		
	}

	public boolean getPatientByPhone(String phone, Connection conn) throws InvalidEmailIdException, SQLException
	{
		ArrayList<String> ar= da.fetchDetails(phone,conn);
	
		System.out.println(!(ar==null));
		
		boolean flag =false;
		
			for(String s:ar)
			{
				if(!s.equalsIgnoreCase(phone))
				
					flag =true;
				
				}
			if(flag){
				
				return true;
				
			}
		return flag;		
	}
	/*public int getTestIdByTestName(String testName) throws SQLException{
		int id =da.fetchDetailsTest(testName);
		return id;
	}*/

	/*public int insertIntoPatient_Test(ArrayList<Patient> arrayList){
		int i=0;
		try {
			i = da.insertIntoPatient_Test(arrayList);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return i;		
	}*/
	/*public int getPatientByPhone(String phone) throws Exception{
		int id = da.fetchDetailsByPhone(phone);
		return id;		
	}*/

	public boolean checkEmailId(String email, Connection conn){

		return false;
	}
	public int getTestIdByTestName(String testName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
