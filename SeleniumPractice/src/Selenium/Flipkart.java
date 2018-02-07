package Selenium;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Flipkart{

	static WebDriver driver;
	String chromeDriver ="webdriver.chrome.driver";
	String chromePath = "D:\\tools\\SeleniumWebDriver\\ChromeDriver 2.29\\chromedriver.exe";
	
	String firefoxDriver = "webdriver.gecko.driver";
	String firefoxPath = "D:\\tools\\SeleniumWebDriver\\FirefoxDriver\\geckodriver-v0.11.1-win64\\geckodriver.exe";
	
	String explorerDriver = "webdriver.ie.driver";
	String explorerPath= "D:\\tools\\SeleniumWebDriver\\IEDriverServer_x64_3.3.0\\IEDriverServer.exe";

	@Test
	public void invokeBrowser() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Browser Choice");
		System.out.println("1. Chrome\n2. Firefox\n3. Internet Explorer");
		String choice = sc.nextLine();
		switch (choice) {
		
		case "1":
			call(chromeDriver, chromePath, new ChromeDriver());
			break;
		case "Chrome":
			call(chromeDriver, chromePath,new ChromeDriver());
			break;
		case "2":
			call(firefoxDriver, firefoxPath, new FirefoxDriver());
			break;
		case "Firefox":
			call(firefoxDriver, firefoxPath, new FirefoxDriver());
			break;
		case "3":
			call(explorerDriver, explorerPath,  new InternetExplorerDriver());
			break;
		case "Internet Explorer":
			call(explorerDriver, explorerPath, new InternetExplorerDriver());
			break;
		}
	}

	public static void call(String s1, String s2,WebDriver driver) {
		System.setProperty(s1, s2);
			driver.get("https://www.flipkart.com");

	}
}
