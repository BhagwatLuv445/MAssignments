package Reports;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Reporters
{
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
//	public static ExtentHtmlReporter htmlReporter;
	
	
	static
	{
			
		Calendar calendar=Calendar.getInstance();
    	SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy-hh_mm_ss");
    	extent =new ExtentReports(System.getProperty("user.dir")+"\\src\\com\\mindtree\\extent" + formater.format(calendar.getTime()) +".html",false);
    	extent.loadConfig(new File(System.getProperty("user.dir")+"\\Extent.xml"));
    	
	}
	
			public void getResult(ITestResult result) throws IOException
			{
	    	if(result.getStatus()==ITestResult.SUCCESS)
	    	{
	    		test.log(LogStatus.PASS,result.getName()+" test case PASSED");
	    	}
	    	else if(result.getStatus()==ITestResult.SKIP)
	    	{
	    		test.log(LogStatus.SKIP,result.getName()+" test case skipped and the reason is :"+ result.getThrowable());
	    	}
	    	else if(result.getStatus()==ITestResult.FAILURE)
	    	{
	    		test.log(LogStatus.FAIL,result.getName()+" test case FAILED ");
	    	}
	    	else if(result.getStatus()==ITestResult.STARTED)
	    	{
	    		test.log(LogStatus.INFO,result.getName()+" test started");
	    		
	    	}
	    }
	    @AfterMethod()
	    public void afterMethod(ITestResult result) throws IOException
	    {
	    	getResult(result);
	    	if(ITestResult.FAILURE==result.getStatus())
	  	    {
	  		  String path=ScreenShot.takeSnapShot(result.getName());
	  		  test.log(LogStatus.FAIL,test.addScreenCapture(path));	  		  
	  	    }
	    }
	    @BeforeMethod()
	    public void beforeMethod(Method result)
	    {
	    	test=extent.startTest(result.getName());
	    	test.log(LogStatus.INFO,result.getName()+" test started");
	    	
	    }
	    @AfterClass(alwaysRun=true)
	    public void endTest()
	    {
	    	
	    	extent.endTest(test);
	    	extent.flush();
	    }
}