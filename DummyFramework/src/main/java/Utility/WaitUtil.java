package Utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;
import Reports.ScreenShot;

public class WaitUtil extends TestBase{

	
	static WebDriverWait wait = new WebDriverWait(driver, 5000);

	public static void waitForElementToDisplay(WebElement element) {
		while (!element.isDisplayed()) {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}

	public static void waitForElementToBeClickable(WebElement element) throws IOException {
		try {
			element.click();
		}catch (TimeoutException toe){
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();			
		}catch(Exception e){
			System.out.println("Element not clickable\n" +element.getText());
			ScreenShot.takeSnapShot(element.getText());
			//System.out.println(e.getMessage());
		}
	}

	public void waitForElementToBeSelected(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeSelected(element));
		} catch (Exception e) {

		}
	}

	public void waitForElementToBeVisible(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {

		}
	}

}
