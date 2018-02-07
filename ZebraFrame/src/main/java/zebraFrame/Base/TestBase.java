package zebraFrame.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import zebraFrame.Utility.TestUtil;
import zebraFrame.Utility.WebEventListener;

public class TestBase {

	protected static WebDriver driver;
	protected static EventFiringWebDriver e_driver;
	protected static WebEventListener eventListener;
	protected Properties prop;

	protected static Logger log = Logger.getLogger(Log.class.getName());

	final static String browserPath = System.getProperty("user.dir") + "\\Resources\\com\\Ferrari_F1_club\\Browser"
			+ "\\chromedriver.exe",
			browserDriver = "webdriver.chrome.driver",
			configPropertiesFilePath = System.getProperty("user.dir") + "\\Resources\\com\\Ferrari_F1_club\\Properties"
					+ "\\config.properties",
			Log4jPropertiesFilePath = System.getProperty("user.dir") + "\\Resources\\com\\Ferrari_F1_club\\Properties"
					+ "\\log4j.properties";

	@BeforeSuite
	public void initialiazation() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(configPropertiesFilePath);
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
			log.info("Browser open");
		} else if (browserName.equals("firefox")) {
			/*
			 * System.setProperty("webdriver.gecko.driver",
			 * "D:\\tools\\SeleniumWebDriver\\chromedriver_win32\\chromedriver.exe"
			 * );
			 */
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		log.info("Maximizing Window");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		log.info("Launching the Application");
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		log.info("TearDown the Browser");
	}
}
