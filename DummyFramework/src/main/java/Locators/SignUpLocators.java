package Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Base.TestBase;

public class SignUpLocators extends TestBase
{
	//*[@id="bs-example-navbar-collapse-1"]/ul/li[7]/ul/li/a
	//*[@id="bs-example-navbar-collapse-1"]/ul/li[7]/a
	@FindBy(how=How.XPATH, using="//mat-toolbar-row/div/button/span")
	protected WebElement loginHomeIcon;	

	//@FindBy(how=How.XPATH, using="//li[7]/ul/li[1]/a")
	//protected WebElement loginSignupLink;	

	@FindBy(how=How.XPATH, using="//a[text()='SignUp?']")
	protected WebElement signUpLinkBtn;
	
	@FindBy(how=How.XPATH, using="//input[@name='fname']")////*[@id="mat-input-2"]
	protected WebElement firstNameTextField;

	@FindBy(how=How.XPATH, using="//input[@name='lname']")
	protected WebElement lastNameTextField;

	@FindBy(how=How.XPATH, using="//input[@name='dateOfBirth']")
	protected WebElement ageField;

	@FindBy(how=How.XPATH, using="//mat-radio-button[@class='mat-radio-button mat-accent']")
	protected List<WebElement> genderRadioBtn;

	@FindBy(how=How.XPATH, using="//mat-select[@role='listbox']")////mat-select[@role="listbox"]
	protected WebElement countryDropDown;////*[@id="background"]/div/mat-card/div[2]/form/div[4]/mat-form-field/div/div[1]/div

	@FindBy(how=How.XPATH, using="//input[@name='email']")
	protected WebElement emailTextField;////*[@id="mat-input-7"]

	@FindBy(how=How.XPATH, using="//input[@name='password']")
	protected WebElement passwordTextField;////*[@id="mat-input-8"]

	@FindBy(how=How.XPATH, using="//input[@name='confirm']")
	protected WebElement confirmPasswordTextField;////*[@id="mat-input-9"]

	@FindBy(how=How.XPATH, using="//form//button")
	protected WebElement signUpSubmitBtn;////form//button

	@FindBy(how=How.XPATH, using="//mat-card/div[3]/button[1]")  //a[text()='Proceed with Google']
	protected WebElement proccedWithGoogleBtn;

	@FindBy(how=How.XPATH, using="//div[3]/button[2]")//a[text()='Proceed with Facebook']
	protected WebElement proccedWithFacebookBtn;

	@FindBy(how=How.XPATH, using="//div[2]//p[text()='Use another account']")
	protected WebElement anotherUserLinkBtn;

	@FindBy(how=How.XPATH, using="//*[@id='identifierId']")
	protected WebElement emailOrPhoneTextField;

	@FindBy(how = How.XPATH, using="//div[@id='identifierNext']")
	protected WebElement emailNextBtn;

	@FindBy(how = How.XPATH, using="//input[@type='password']")
	protected WebElement passwordField;

	@FindBy(how = How.XPATH, using="//div[@id=passwordNext]")
	protected WebElement pwdNextBtn;
	
	@FindBy(how = How.XPATH, using="//div[3]/button")
	protected WebElement LoginBtn;
	
}
