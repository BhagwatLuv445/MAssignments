package testCase;

import org.openqa.selenium.WebDriver;

import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;
//import DataProvider.DataProvider1;
import pages.SignUp;
import utility.LogDemo;

//import utility.ExcelUtils;
public class SignUpTest extends LogDemo {

	private static WebDriver driver;

	/*
	 * public static final String filePath =
	 * "C:\\Users\\M1043004\\Downloads\\Project\\";
	 * 
	 * public static final String fileName = "data.xlsx";
	 */

	@BeforeTest
	public void initBrowser() { 
		System.setProperty("webdriver.chrome.driver",
				"D:\\tools\\SeleniumWebDriver\\chromedriver_win32\\chromedriver.exe");
		// DOMConfigurator.configure("log4j.xml");
		PropertyConfigurator.configure("log4j.properties");
		Log.info("New Driver invoke");
		driver = new ChromeDriver();
		Log.info("The Browser window gets maximize");
		driver.manage().window().maximize();

	}

	//@Test(dataProvider = "Authentication", dataProviderClass =DataProvider1.class)
	@Parameters({ "firstname", "lastname", "username", "password", "month", "day", "year", "gender", "mobileNumber",
			"recoveryEmail" })
	@Test
	public void signUp(String firstname, String lastname, String username, String password, String month, String day,
			String year, String gender, String mobileNumber, String recoveryEmail) {
		
		driver.get(
				"https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");
		Log.info("Web Application Launched");		
		// ExcelUtils.setExcelFile(filePath + fileName, "Gmail_SignUp");

		SignUp signup = new SignUp(driver);
		signup.setFirstNameTextField(firstname);
		signup.setLastNameTextField(lastname);
		signup.setUserNameTextField(username);
		signup.setPasswordTextField(password);
		signup.setConfirmPasswordTextField(password);
		signup.setMonthDropDownField(month);
		signup.setDayTextField(day);
		signup.setYearTextField(year);
		signup.setGendeDropDownField(gender);
		signup.setMobileNumberField(mobileNumber);
		signup.setCurrentEmailTextField(recoveryEmail);
		// signup.setLocationDropDownField(ExcelUtils.getCellData(1, 12));
		signup.clickNextStepButton();
	}

	@AfterTest
	public void closeBrowser() {
		Log.info("Browser closed");
		driver.quit();
	}
}
