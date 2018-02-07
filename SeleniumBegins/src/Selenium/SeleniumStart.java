package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class SeleniumStart {

	@Test
	public void sampleTest(){
		System.out.println("Bhagwat");
		Assert.assertEquals("abc", "abc");
	}
	
	@Test
	public void test1(){
		Assert.assertEquals("abc", "abc");
	}
	
	@Test
	public void test2(){
		System.setProperty("webdriver.chrome.driver","D:\\tools\\SeleniumWebDriver\\ChromeDriver 2.29\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//to load a new web page
		driver.get("https://peoplehub.mindtree.com/Pages/default.aspx");
		
		//to get the title of the current web page
		String title = driver.getTitle();
		int length = title.length();
		System.out.println(title+ " "+length);
		
		//to get current url of the web browser
		String currentURl = driver.getCurrentUrl();	
		if(currentURl.contentEquals("https://peoplehub.mindtree.com/Pages/default.aspx")){
			System.out.println(currentURl);
			}else{
				System.out.println("Different url");
			}
		
		//to get the page source
		String pageSource = driver.getPageSource();
		int length1 = pageSource.length();
		System.out.println(length1);
		
		driver.findElement(By.cssSelector(".people-hub-menuu-icn")).click();
		
		//typing into an element
		driver.findElement(By.id("sitemap-search")).sendKeys("Profile");
		
		//clear an elements fields
		//driver.findElement(By.id("sitemap-search")).clear();
		
		//to click on an element
		driver.findElement(By.className("overlay_search")).click();
		
		driver.findElement(By.id("ctl00_ctl40_g_1afc7673_78cb_4b67_b86c_7f432d1371b0_csr_sbox")).clear();
		
		driver.findElement(By.id("ctl00_ctl40_g_1afc7673_78cb_4b67_b86c_7f432d1371b0_csr_sbox")).sendKeys("Bhagwat Prajapati");
		
		driver.findElement(By.className("ms-srch-sbLarge-searchImg")).click();
		
		driver.navigate().back();
		
		driver.findElement(By.id("ctl00_ctl40_g_c159a5b7_2656_4906_ade7_151935d8a59b_SRCHNAVITEM").className("ms-srchnav-link")).click();
				
		/*
		 * //to navigate to particular url driver.navigate().to(
		 * "https://peoplehub.mindtree.com/Profile/Pages/Profile.aspx");
		 * 
		 * //to go back one page driver.navigate().back();
		 * 
		 * //to go one page forward driver.navigate().forward();
		 * 
		 * //to refresh the page driver.navigate().refresh(); //It closes the
		 * current window of the browser opened by the Webdriver
		 * //driver.close();
		 * 
		 * //it closes all the windows opened by the Webdriver //driver.quit();
		 */ }
}
