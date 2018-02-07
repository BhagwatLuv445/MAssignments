package TestCases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Operation.UIOperation;
import Utility.ExcelRead;

public class TestImplement {

	protected static WebDriver webdriver;

	@BeforeMethod
	public static void setUp() 
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\MySeleniumWorkSpace\\HybridFrameWork\\src\\test\\java\\Drivers\\chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Test
	public void testLogin() throws Exception 
	{
		Object map[][] = ExcelRead.getData("KeywordFramework");
		UIOperation operation = new UIOperation(webdriver);
		for (int i = 0; i < map.length; i++) 
		{
			HashMap<String, String> data = (HashMap<String, String>) map[i][0];			
			operation.perform(data.get("Keyword"), data.get("ObjectName"), data.get("ObjectType"),
					data.get("LocatorValue"), data.get("value"));
		}
	}

	@AfterMethod
	public void tearDown()
	{
		webdriver.close();
	}
}