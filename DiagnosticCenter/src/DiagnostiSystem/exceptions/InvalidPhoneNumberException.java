package DiagnostiSystem.exceptions;

public class InvalidPhoneNumberException extends Exception{

	public InvalidPhoneNumberException(String string) {
		super(string);
	}

	public String toString(){
		return "Invalid phone number please check your input";
	}
}
