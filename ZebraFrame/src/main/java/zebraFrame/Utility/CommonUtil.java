package zebraFrame.Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.TestException;

public class CommonUtil {

	public void checkPageIsReady(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}

			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	public void navigateForward(WebDriver driver) {
		try {
			driver.navigate().forward();
		} catch (Exception e) {

		}
	}

	public void navigateBack(WebDriver driver) {
		try {
			driver.navigate().back();
		} catch (Exception e) {

		}
	}

	public void navigateToURL(WebDriver driver, String URL) {
		try {
			driver.navigate().to(URL);
		} catch (Exception e) {

		}
	}

	public String getCurrentURL(WebDriver driver) {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			throw new TestException(String.format("Current URL is: %s", driver.getCurrentUrl()));
		}
	}

}
