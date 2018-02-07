package com.mindtree.entity;

import java.util.Date;

public class Patient_Test {

	int pID;
	int tID;
	String date;
	public Patient_Test(){
		
	}
	
	public void setPid(int pid){
		this.pID = pid;
	}
	public int getPid(){
		return pID;
	}
	public void setTid(int tid){
		this.tID = tid;
	}
	public int getTid(){
		return tID;
	}
	public void setDate(String date){
		this.date = date;
	}
	public String getDate(){
		return date;
	}
}
