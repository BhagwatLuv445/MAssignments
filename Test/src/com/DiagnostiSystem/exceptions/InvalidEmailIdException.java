package com.DiagnostiSystem.exceptions;

public class InvalidEmailIdException extends Exception{
	
	public InvalidEmailIdException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	public String toString(){
		return "Invalid email id please check your input";
	}

}
