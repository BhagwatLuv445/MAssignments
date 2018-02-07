package zebraFrame.API;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Grid_SetUP {
	public static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		String URL = "http://www.DemoQA.com";
		String Node = "http://172.17.124.21:4444/wd/hub";
		
		System.setProperty("webdriver.chrome.driver", "D:\\tools\\SeleniumWebDriver\\chromedriver_win32\\chromedriver.exe");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL(Node), cap);

		driver.navigate().to(URL);
		Thread.sleep(5000);
		driver.quit();
	}
}