package com.mindtree.exceptions;

public class InvalidDateException extends Exception {

	public InvalidDateException(String string) {

		super(string);

	}

	public String toString() {
		return "Invalid Test Date Plzzz check your Input";
	}
}
