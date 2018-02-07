package com.mindtree.exceptions;

public class InvalidTestNameException extends Exception{

	public String getMessage(){
		return "Invalid Test Name please check your input";
	}
}
