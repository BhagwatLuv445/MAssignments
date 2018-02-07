package Pages;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import Actions.InputField;
import Assestions.Assertions;
import Interfaces.ISignUpPage;
import Locators.SignUpLocators;
import Utility.WaitUtil;

public class SignUpPage extends SignUpLocators implements ISignUpPage {

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		return null;

	}

	public void enterSigUpDetails(String firstName, String lastName, String age, String gender, String country,
			String email, String password, String confrimPassword) {
		try {
			WaitUtil.waitForElementToBeClickable(loginHomeIcon);
			//WaitUtil.waitForElementToBeClickable(loginSignupLink);
			// WaitUtil.waitForElementToBeClickable(signUpLinkBtn);
			signUpLinkBtn.click();
			Assertions.sendKey(firstNameTextField, firstName);
			Assertions.sendKey(lastNameTextField, lastName);
			Assertions.sendKey(ageField, age);
			InputField.selectRadioBtn(genderRadioBtn, gender);
			// InputField.selectByVisibleText(countryDropDown, country);
			countryDropDown.sendKeys(country);
			// Assertions.sendKey(countryDropDown, country);
			Assertions.sendKey(emailTextField, email);
			Assertions.sendKey(passwordTextField, password);
			Assertions.sendKey(confirmPasswordTextField, confrimPassword);
			WaitUtil.waitForElementToBeClickable(signUpSubmitBtn);
		} catch (IOException e1) {

		}
	}

	public void loginDetails(String userName, String password) throws IOException {
		WaitUtil.waitForElementToBeClickable(loginHomeIcon);
		//WaitUtil.waitForElementToBeClickable(loginSignupLink);

		Assertions.sendKey(emailTextField, userName);
		Assertions.sendKey(passwordTextField, password);

		LoginBtn.click();
	}	
}
