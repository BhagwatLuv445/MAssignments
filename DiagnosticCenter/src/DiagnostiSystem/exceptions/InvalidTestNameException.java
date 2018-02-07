package DiagnostiSystem.exceptions;

public class InvalidTestNameException extends Exception{

	public InvalidTestNameException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	public String toString(){
		return "Invalid Test Name please check your input";
	}
}
