package com.mindtree.entity;

import java.sql.Date;
import java.util.ArrayList;

public class Patient {

	int pID;
	String name;
	String email;
	String phone;
	String dob;
	
	public ArrayList<Test> tests;
	
	public Patient(){
		pID = 0;
		name = "";
		email = "";
		phone = "";
		dob = "";
		tests = new ArrayList<Test>();
	}
	
	public Patient(int pID, String name, String email, String phone, String dob){
		this.pID = pID;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		tests = new ArrayList<Test>();
	}
	
	
	public int getPID(){
		return pID;	
	}
	public void setPID(int pID){
		this.pID = pID;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getDob(){
		return dob;
	}
	public void setDob(String dob){
		this.dob = dob;
	}
}
