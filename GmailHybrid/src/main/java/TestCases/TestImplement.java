package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Operation.UIOperation;
import Utility.ToolsQaDataProvider;

public class TestImplement {

	protected static WebDriver webdriver;

	@BeforeTest
	public static void setUp() 
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\MySeleniumWorkSpace\\HybridFrameWork\\src\\test\\java\\Drivers\\chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "hybridData", dataProviderClass = ToolsQaDataProvider.class)
	public void testLogin(String testcaseName, String keyword, String objectName, String objectType,String LocatorValue, String value) throws Exception 
	{
		UIOperation operation = new UIOperation(webdriver);
		operation.perform(keyword, objectName, objectType, LocatorValue, value);
	}
}