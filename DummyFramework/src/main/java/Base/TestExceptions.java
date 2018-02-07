package Base;

public class TestExceptions extends Exception{
	public TestExceptions(String string) {
		super(string);
	}

	public String toString() {
		return "Invalid Test Date Plzzz check your Input";
	}
}
