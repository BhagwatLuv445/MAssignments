package com.mindtree.exceptions;

public class InvalidPhoneNumberException extends Exception{

	public String getMessage(){
		return "Invalid phone number please check your input";
	}
}
