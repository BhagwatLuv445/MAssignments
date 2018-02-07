package Interfaces;

import java.io.IOException;

public interface ISignUpPage {

	String validateHomePageTitle();
	void enterSigUpDetails(String firstName, String lastName, String age, String gender, String country,
			String email, String password, String confrimPassword);
	void loginDetails(String userName, String password) throws IOException;
}
