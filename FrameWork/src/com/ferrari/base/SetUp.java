package com.ferrari.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.model.Log;

public class SetUp {

	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("testName.current.date.time", /* testName + " " + */ dateFormat.format(new Date()));

	}

	protected WebDriver driver;
	protected static Properties prop;
	protected static Logger log = Logger.getLogger(Log.class.getName());
	FileInputStream ip;
	final static String browserPath = System.getProperty("user.dir") + "\\lib" + "\\chromedriver.exe",
			browserDriver = "webdriver.chrome.driver",
			configPropertiesFilePath = System.getProperty("user.dir") + "\\Properties" + "\\config.properties",
			Log4jPropertiesFilePath = System.getProperty("user.dir") + "\\Properties" + "\\log4j.properties";

	public SetUp() {
		try {
			prop = new Properties();
			ip = new FileInputStream(configPropertiesFilePath);
			prop.load(ip);
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}
		
		
		
		PropertyConfigurator.configure(Log4jPropertiesFilePath);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty(browserDriver, browserPath);
			driver = new ChromeDriver();
			log.info("Chrome Browser invoke");
		} else if (browserName.equals("firefox")) {
			/*
			 * System.setProperty("webdriver.gecko.driver"
			 * "D:\\tools\\SeleniumWebDriver\\chromedriver_win32\\chromedriver.exe"
			 * );
			 */
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		log.info("Amazon Application launch");
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
}
