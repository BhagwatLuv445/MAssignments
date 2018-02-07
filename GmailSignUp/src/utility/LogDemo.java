package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
/*import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;*/

public class LogDemo {

	protected static Logger Log = Logger.getLogger(Log.class.getName());//

	/*
	static String testName =null;
	
	@Parameters("testName")
	@BeforeClass
	static void fileName(String testName)
	{
		LogDemo.testName = testName ;
	}
	*/
	
	static
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("testName.current.date.time", /*testName + " " +*/ dateFormat.format(new Date()));
		
	}
	
	
	public static void startTestCase(String sTestCaseName) {

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

		Log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

	}

	// This is to print log for the ending of the test case

	public static void endTestCase(String sTestCaseName) {

		Log.info("XXXXXXXXXXXXXXXXXXXXXXX              " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");
	}

	// Need to create these methods, so that they can be called

	/*public static void info(String message) {

		Log.info(message);

	}

	public static void warn(String message) {

		Log.warn(message);

	}

	public static void error(String message) {

		Log.error(message);

	}

	public static void fatal(String message) {

		Log.fatal(message);

	}

	public static void debug(String message) {

		Log.debug(message);

	}*/

}
