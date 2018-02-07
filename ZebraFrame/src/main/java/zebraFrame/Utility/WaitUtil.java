package zebraFrame.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, 5000);

	public void waitForElementToDisplay(WebDriver driver, WebElement element) {
		while (!element.isDisplayed()) {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}

	public void waitForElementToBeClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {

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
