package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
 
public class ActionClass {
	
	@Test
	public void textInCaps() throws InterruptedException{
                //Instantiating the WebDriver interface.
		System.setProperty("webdriver.chrome.driver", "D:\\tools\\SeleniumWebDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
                //Open the required URL
        //Open the required URL where you could do double click action
		driver.get("http://api.jquery.com/dblclick/");
               //Maximize the browser
               driver.manage().window().maximize();
               //As per the above URL we need to switch to frame. The targeted element is in the frame
		driver.switchTo().frame(0);
               //Create the object 'action'		
		Actions action = new Actions(driver);
		//Find the targeted element
		WebElement ele = driver.findElement(By.cssSelector("html>body>div"));
               //Here I used JavascriptExecutor interface to scroll down to the targeted element
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
               //used doubleClick(element) method to do double click action
		action.doubleClick(ele).build().perform();
               //Once clicked on the element, the color of element is changed to yellow color from blue color
               //driver.close();
	}
}
