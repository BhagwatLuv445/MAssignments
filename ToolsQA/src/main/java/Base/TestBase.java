package Base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Actions.PageLoadingAndRefreshing;
import Interfaces.IToolsQa;
import Pages.ToolsQaPage;
import Utility.PropertiesUtil;
import Utility.TestUtil;

public class TestBase {

	protected IToolsQa toolsQa;
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
				String browserPath = PropertiesUtil.read("browserChromePath");
				String browserDriver = PropertiesUtil.read("browserChromeDriver");
				System.setProperty(browserDriver, browserPath);
				driver = new ChromeDriver();
				log.info("Browser open");
			} else if (browserName.equals("IE")) {
				String browserPath = PropertiesUtil.read("browserIEPath");
				String browserDriver = PropertiesUtil.read("browserIEDriver");
				System.setProperty(browserDriver, browserPath);
				driver = new InternetExplorerDriver();
				log.info("Browser open");
			}
		} catch (Exception e) {
			System.out.println("Unable to open browser");
		}

		toolsQa = new ToolsQaPage();
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

	@AfterSuite
	public void tearDown() {
		driver.quit();
		log.info("TearDown the Browser");
	}
}
