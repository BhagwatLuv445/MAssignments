package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	public WebDriver driver;
	public Properties OR;
	public FileInputStream file;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;

	static
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent =new ExtentReports(System.getProperty("user.dirr")+"\\src\\main\\java" + "\\ExtentReport"+ formater.format(calendar.getTime()) + ".html", false);
	}
	public void getBrowser(String browser) 
	{
		if (browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\java\\Drivers\\" + "\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\java\\Drivers\\" + "\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("internet explorer")) 
		{
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\java\\Drivers\\" + "\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}

	public void loadProperties() throws IOException 
	{
		OR = new Properties();
		file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\Properties\\" + "\\config.properties");
		OR.load(file);

		OR = new Properties();
		file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\Properties\\" + "\\log4j.properties");
		OR.load(file);
	}

	public void getPropertiesData() 
	{

	}

	public String getScreenShot(String imageName) throws IOException 
	{
		if (imageName.equals("")) 
		{
			imageName = "blank";
		}
		File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imageLocation = System.getProperty("user.dir") + "\\src\\main\\java\\ScreenShots\\";
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImage = imageLocation + imageName + "_" + formater.format(calender.getTime()) + ".png";
		File destFile = new File(actualImage);
		FileUtils.copyFile(image, destFile);
		return actualImage;
	}

	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS,result.getName() + "test is PASS");
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(LogStatus.SKIP,result.getName() + "test is skipped and skip reason is" + result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, result.getName() + "test is failed" + result.getThrowable());
			String screen = getScreenShot("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		}
		else if(result.getStatus() == ITestResult.STARTED)
		{
			test.log(LogStatus.INFO, result.getName() + "test is started" );
		}
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		getResult(result);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + "test started");
	}
	
	@AfterClass(alwaysRun = true)
	public void endTest()
	{
		driver.quit();
		extent.endTest(test);
		extent.flush();
	}
	
	public WebElement getLocator(String locator) throws Exception
	{
		String [] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];
		
		if(locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if(locatorType.toLowerCase().equals("classname") || locatorType.toLowerCase().equals("class"))
			return driver.findElement(By.className(locatorValue));
		else if(locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if(locatorType.toLowerCase().equals("tagname") || locatorType.toLowerCase().equals("tag"))
			return driver.findElement(By.tagName(locatorValue));
		else if(locatorType.toLowerCase().equals("linktext") || locatorType.toLowerCase().equals("text"))
			return driver.findElement(By.linkText(locatorValue));
		else if(locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if(locatorType.toLowerCase().equals("cssSelector") || locatorType.toLowerCase().equals("css"))
			return driver.findElement(By.cssSelector(locatorValue));
		else if(locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else 
			throw new Exception("Unknown locator type" + locatorType);
	}
	
	public List<WebElement> getLocators(String locator) throws Exception
	{
		String [] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];
		
		if(locatorType.toLowerCase().equals("id"))
			return (List<WebElement>) driver.findElement(By.id(locatorValue));
		else if(locatorType.toLowerCase().equals("classname") || locatorType.toLowerCase().equals("class"))
			return (List<WebElement>) driver.findElement(By.className(locatorValue));
		else if(locatorType.toLowerCase().equals("name"))
			return (List<WebElement>) driver.findElement(By.name(locatorValue));
		else if(locatorType.toLowerCase().equals("tagname") || locatorType.toLowerCase().equals("tag"))
			return (List<WebElement>) driver.findElement(By.tagName(locatorValue));
		else if(locatorType.toLowerCase().equals("linktext") || locatorType.toLowerCase().equals("text"))
			return (List<WebElement>) driver.findElement(By.linkText(locatorValue));
		else if(locatorType.toLowerCase().equals("partiallinktext"))
			return (List<WebElement>) driver.findElement(By.partialLinkText(locatorValue));
		else if(locatorType.toLowerCase().equals("cssSelector") || locatorType.toLowerCase().equals("css"))
			return (List<WebElement>) driver.findElement(By.cssSelector(locatorValue));
		else if(locatorType.toLowerCase().equals("xpath"))
			return (List<WebElement>) driver.findElement(By.xpath(locatorValue));
		else 
			throw new Exception("Unknown locator type" + locatorType);
	}
	
	public WebElement getWebElement(String locator) throws Exception
	{
		return getLocator(OR.getProperty(locator));
	}
	
	public List<WebElement> getWebElements(String locator) throws Exception
	{
		return getLocators(OR.getProperty(locator));
	}
}