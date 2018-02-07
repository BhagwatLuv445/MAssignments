package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Example {

	/*
	 * public static void clickAndHold(WebDriver driver, WebElement to,
	 * WebElement from) { Actions action = new Actions(driver);
	 * action.clickAndHold(from).build().perform();
	 * action.moveToElement(to).build().perform();
	 * action.release(to).build().perform(); }
	 */

	/*
	 * public static void dragAndDrop1(WebDriver driver, WebElement draggable,
	 * WebElement droppable) { WebDriverWait wait = new WebDriverWait(driver,
	 * 5000); wait.until(ExpectedConditions.visibilityOf(draggable)); Actions
	 * act = new Actions(driver); act.dragAndDrop(draggable,
	 * droppable).build().perform(); System.out.println("hi"); }
	 */
	/*
	 * public static String getToolTipText(WebElement element) { String
	 * toolTipText = element.getAttribute("title");
	 * System.out.println(toolTipText+"null"); return toolTipText; }
	 */public static String getToolTipText(WebDriver driver, WebElement hoverElement, WebElement toolTipElement) {
		new Actions(driver).moveToElement(hoverElement).build().perform();
		String toolTipText = toolTipElement.getAttribute("aria-label");
		System.out.println(toolTipText);
		return toolTipText;
	}

	@Test
	public static void main() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\tools\\SeleniumWebDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		driver.manage().window().maximize();

		// Actions act = new Actions(driver);

		// Script for dragging an element and dropping it in another place
		WebElement iFrame = driver.findElement(By.xpath("//span[@class='gsri_a']"));
		/*
		 * System.out.println(iFrame.getSize());
		 * driver.switchTo().frame(iFrame);
		 */
		WebElement From = driver.findElement(By.xpath("//a[@class='gsst_a']"));
		System.out.println(From.getLocation());
		/*
		 * WebElement To = driver.findElement(By.id("droppable"));
		 * System.out.println(To.getLocation());
		 * 
		 * Example.dragAndDrop1(driver,From, To);
		 */ // act.dragAndDrop(From, To).build().perform();
		String tooltip = Example.getToolTipText(driver,iFrame,From);
		System.out.println(tooltip);

	}
}