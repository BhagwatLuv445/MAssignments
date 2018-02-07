package  Actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScrollActions {

	public void ScrollHorizontally(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll the page Horizontally till the element is found
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollingToBottomofAPage(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollingToElementofAPage(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void ByPixel(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll down the page by 1000 pixel vertical
		js.executeScript("window.scrollBy(0,1000)");

	}
	
	//Scroll down using Page_Down keys
	public void scrollPageDown(WebDriver driver){
		new Actions(driver).sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	//Scroll up using Page_Up keys
	public void scrollPageUp(WebDriver driver){
		new Actions(driver).sendKeys(Keys.PAGE_UP).build().perform();
	}
}
