package Testcases;

import org.testng.annotations.Test;

import Base.TestBase;

public class SignupTest extends TestBase {

	@Test
	public void signupTest(){
		signUpPage.enterSigUpDetails("Bhagwat", "Prajapati", "01-01-1994", "Male", "India", "bhagwat9094@gmail.com", "Sunderlal9094@", "Sunderlal9094@");
	}
}
