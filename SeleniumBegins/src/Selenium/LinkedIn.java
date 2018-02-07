package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LinkedIn {

	WebDriver driver;

	@Test
	public void linkedInHome() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\tools\\SeleniumWebDriver\\ChromeDriver 2.29\\chromedriver.exe");

		driver = new ChromeDriver();

		/*
		 * // driver.manage().window().maximize(); //
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 * 
		 * // driver.navigate().refresh(); logIn();
		 */
		driver.get("http://www.LinkedIn.com");
		driver.navigate().refresh();
		driver.findElement(By.className("login-email")).sendKeys("bhagwatluv445@gmail.com");
		driver.findElement(By.className("login-password")).sendKeys("Sunderlal9094@");
		driver.findElement(By.id("login-submit")).click();

		// driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("Praveen
		// Singh Rajput");
		// driver.findElement(By.xpath("//*[@class='search-typeahead-v2__button
		// typeahead-icon']")).click();
		driver.findElement(By.xpath("//*[@id='notifications-nav-item']//a[@href='/notifications/']")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id='nav-settings__dropdown-trigger']")).click();
		driver.findElement(By.xpath("//*[@class='nav-dropdown__action']")).click();
	}

	public void logIn() {

	}

}
