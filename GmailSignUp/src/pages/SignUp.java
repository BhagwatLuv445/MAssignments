package pages;

import org.apache.commons.logging.Log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utility.LogDemo;

public class SignUp extends LogDemo {

	private WebDriver driver = null;

	public SignUp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "FirstName")
	WebElement firstNameTextField;

	@FindBy(how = How.ID, using = "LastName")
	WebElement lastNameTextField;

	@FindBy(how = How.ID, using = "RecoveryEmailAddress")
	WebElement currentEmailTextField;

	@FindBy(how = How.ID, using = "GmailAddress")
	WebElement userNameTextField;

	@FindBy(how = How.ID, using = "Passwd")
	WebElement passwordTextField;

	@FindBy(how = How.ID, using = "PasswdAgain")
	WebElement confirmPasswordTextField;

	@FindBy(how = How.XPATH, using = "//*[@id='BirthDay']")
	WebElement dayTextField;

	@FindBy(how = How.XPATH, using = "//*[@id='BirthMonth']/div[1]")
	WebElement monthDropDownField;

	@FindBy(how = How.XPATH, using = "//*[@id='BirthYear']")
	WebElement yearTextField;

	@FindBy(how = How.XPATH, using = "//*[@id='Gender']/div")
	WebElement genderDropDownField;

	@FindBy(how = How.ID, using = "RecoveryPhoneNumber")
	WebElement mobileNumberField;

	@FindBy(how = How.XPATH, using = "//*[@id=':i']")
	WebElement locationDropDownField;

	@FindBy(how = How.ID, using = "submitbutton")
	WebElement nextStepButton;

	public void setFirstNameTextField(String firstName) {
		Log.info("firstName Element Found.");
		Log.info("Firstname entered in firstname textbox");
		firstNameTextField.sendKeys(firstName);
	}

	public void setLastNameTextField(String lastName) {
		Log.info("lastName Element Found.");
		Log.info("Lastname entered in Lastname textbox");
		lastNameTextField.sendKeys(lastName);
	}

	public void setEmailTextField(String email) {
		Log.info("email Element Found.");
		Log.info("Email entered in Email textbox");
		currentEmailTextField.sendKeys(email);
	}

	public void setPasswordTextField(String password) {
		Log.info("Password Element Found.");
		Log.info("Password entered in Password textbox");
		passwordTextField.sendKeys(password);
	}

	public void setConfirmPasswordTextField(String confirmPassword) {
		Log.info("confirmPassword Element Found.");
		Log.info("Confirm Password entered in Confirm Password textbox");
		confirmPasswordTextField.sendKeys(confirmPassword);
	}

	public void setDayTextField(String day) {
		Log.info("Day Element of Date of Birth Found.");
		Log.info("Day entered in Day textbox");
		dayTextField.sendKeys(day);
	}

	public void setMonthDropDownField(String month) {
		Log.info("Month Element of Date of Birth Found.");
		Log.info("Month has chosen from month list");
		monthDropDownField.sendKeys(month);
	}

	public void setYearTextField(String year) {
		Log.info("year Element of Date of Birth Found.");
		Log.info("Year entered in year textbox");
		yearTextField.sendKeys(year);
	}

	public void setGendeDropDownField(String gender) {
		Log.info("Gender Element Found.");
		Log.info("Gender has chosen from gender list");
		genderDropDownField.sendKeys(gender);
	}

	public void setMobileNumberField(String mobileNumber) {
		Log.info("Mobile Number Element Found.");
		Log.info("Mobile Number entered in Mobile Number textbox");
		mobileNumberField.sendKeys(mobileNumber);
	}

	public void setLocationDropDownField(String location) {
		Log.info("Location Element Found.");
		Log.info("Location entered ");
		locationDropDownField.sendKeys(location);
	}

	public void setUserNameTextField(String userName) {
		Log.info("username Element Found.");
		Log.info("username entered in username textbox");
		userNameTextField.sendKeys(userName);
	}

	public void setCurrentEmailTextField(String currentEmail) {
		Log.info("Current Email Element Found.");
		Log.info("Current Email entered in Current Email textbox");
		currentEmailTextField.sendKeys(currentEmail);
	}

	public void clickNextStepButton() {
		Log.info("Next Button Element Found.");
		Log.info("Click action performed on Next Button");
		nextStepButton.click();
	}
}
