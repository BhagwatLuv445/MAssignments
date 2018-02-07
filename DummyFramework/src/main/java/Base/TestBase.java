package Base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Actions.PageLoadingAndRefreshing;
import Interfaces.ISignUpPage;
import Pages.SignUpPage;
import Utility.PropertiesUtil;
import Utility.TestUtil;

public class TestBase {

	protected ISignUpPage signUpPage;
	protected static WebDriver driver;
	// protected Properties prop;

	protected static Logger log = Logger.getLogger(Log.class.getName());

	@BeforeSuite
	public void initialiazation() throws IOException {

		String browserName = PropertiesUtil.read("browser");
		String Log4jPropertiesFilePath = PropertiesUtil.read("Log4jPropertiesFilePath");

		PropertyConfigurator.configure(Log4jPropertiesFilePath);

		try {
			if (browserName.equals("chrome")) {
				String browserPath = PropertiesUtil.read("browserPath");
				String browserDriver = PropertiesUtil.read("browserDriver");
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
		} catch (Exception e) {
			System.out.println("Unable to open browser");
		}

		signUpPage = new SignUpPage();

		driver.manage().window().maximize();
		log.info("Maximizing Window");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		try {
			driver.get(PropertiesUtil.read("url"));
			PageLoadingAndRefreshing.checkPageIsReady();
			log.info("Launching the Application");
		} catch (Exception e) {
			System.out.println("Page is taking too much time to load");
		}
	}
/*
	@AfterSuite
	public void tearDown() {
		driver.quit();
		log.info("TearDown the Browser");
	}*/
}
