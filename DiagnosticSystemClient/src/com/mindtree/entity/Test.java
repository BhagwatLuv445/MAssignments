package com.mindtree.entity;

public class Test {

	int pid;
	int tID;
	String testName;
	int cost;
	
	public Test(){
		
	}
	public Test(int pid, int tId, String testName, int cost){
		
		this.pid = pid;
		this.tID =tId;
		this.testName = testName;
		this.cost = cost;
	}
	
	public int getTID(){
		return tID;
	}
	public void setTID(int tID){
		this.tID = tID;
	}
	public String getTestName(){
		return testName;
	}
	public void setTestName(String testName){
		this.testName = testName;
	}
	public int getCost(){
		return cost;
	}
	public void setCost(int cost){
		this.cost = cost;
	}
}
