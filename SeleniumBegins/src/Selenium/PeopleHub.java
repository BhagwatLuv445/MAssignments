package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PeopleHub {

	WebDriver driver;
	@Test
	public void loadWebBrowser(){

		System.setProperty("webdriver.chrome.driver","D:\\tools\\SeleniumWebDriver\\ChromeDriver 2.29\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//loadPeopleHub();
		
		driver.get("https://peoplehub.mindtree.com/Pages/default.aspx");

		driver.findElement(By.xpath("//*[@id='header-menu-work']")).click();
		driver.findElement(By.xpath("//*[@id='header-menu-work']/h1/span")).click();
		driver.findElement(By.xpath("//*[text()='Productivity']")).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@href,'MAS')]"))).click();
		//driver.findElement(By.xpath("//*[contains(@href,'MAS')]")).click();
		//driver.findElement(By.xpath("//*[@id='mCSB_1_container']/ul/li[1]/ul/li[5]/a")).click();

	}

	public void loadPeopleHub(){

	}

}
