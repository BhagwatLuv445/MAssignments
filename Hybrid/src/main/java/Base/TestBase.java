package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.api.log.Log;

public class TestBase {

	static
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time",dateFormat.format(new Date()));
		
	}
	
	protected static WebDriver driver;
	public static Properties OR;
	public static FileInputStream file;
	
	protected static Logger log = Logger.getLogger(Log.class.getName());
	
	
	public static void init() throws IOException
	{
		loadProperties();
		PropertyConfigurator.configure(System.getProperty("user.dir")+ "\\src\\test\\java" + "\\Resources\\log4j.properties");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\java\\Drivers\\" + "\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(OR.getProperty("url"));
		driver.get(OR.getProperty("url"));
	}	
	public static void loadProperties() throws IOException 
	{
		OR = new Properties();
		file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\Resources\\" + "\\config.properties");
		OR.load(file);
	}
	
	public static void main(String[] args) throws IOException {
		TestBase.init();
	}
}
