package Scrolling;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ferrari.utility.SetUp;

public class Scoll extends SetUp {
	JavascriptExecutor js = (JavascriptExecutor) driver;


	/*
	 * For Scroll down:
	 * 
	 * WebDriver driver = new FirefoxDriver(); JavascriptExecutor jse =
	 * (JavascriptExecutor)driver; jse.executeScript("window.scrollBy(0,250)",
	 * "");
	 */
	
	/*
	 * For Scroll up:
	 * 
	 * jse.executeScript("window.scrollBy(0,-250)", ""); OR,
	 * jse.executeScript("scroll(0, -250);");
	 */
	public void scrollingToBottomofAPage() {

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		/*
		 * or Actions actions = new Actions(driver);
		 * actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		 */
		 // Scroll till to element by Keys  
		/*
		 * dr.findElement(By.partialLinkText("About Yahoo")).sendKeys(Keys.
		 * PAGE_DOWN); Thread.sleep(3000);
		 * dr.findElement(By.partialLinkText("Mail")).sendKeys(Keys.PAGE_UP);
		 * Thread.sleep(5000); // Scroll till to element by action Actions
		 * action = new Actions(dr); action.sendKeys(Keys.PAGE_DOWN);
		 * action.click(dr.findElement(By.partialLinkText("About Yahoo"))).
		 * perform();
		 */
	}

	public void scrollingToElementofAPage(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void ByPixel() {
		// This will scroll down the page by 1000 pixel vertical
		js.executeScript("window.scrollBy(0,1000)");

	}

	public void ScrollHorizontally(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
