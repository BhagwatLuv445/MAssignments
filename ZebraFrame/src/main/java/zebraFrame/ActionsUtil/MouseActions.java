package zebraFrame.ActionsUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseActions {

	// to click on an element
	public static void clickElements(WebElement element) {
		element.click();
	}

	// to check the chechbox if it is uncheck
	public static void check_checkBox(WebElement element) {
		if (!element.isSelected()) {
			element.click();
		}
	}

	// to uncheck a checked checkbox
	public static void uncheck_checkBox(WebElement element) {
		if (element.isSelected()) {
			element.click();
		}
	}

	// To check the button is enable or not
	/*
	 * public static boolean isEnabled(WebElement element) { if
	 * (element.isEnabled()) { return true; } else { return false; } }
	 */

	// to hover mouse on an element
	public static void mouseOver(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).build().perform();
	}

	// to hover on an element and click on an element
	public static void HoverAndClick(WebDriver driver, WebElement elementToHover, WebElement elementToClick) {
		Actions action = new Actions(driver);
		action.moveToElement(elementToHover).click(elementToClick).build().perform();
	}

	// to drag and drop
	public static void dragAndDrop1(WebDriver driver, WebElement draggable, WebElement droppable) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(draggable));
		Actions act = new Actions(driver);
		act.dragAndDrop(draggable, droppable).build().perform();
	}

	// TO DRAG AND DROP USING CLICK AND HOLD
	public static void clickAndHold(WebDriver driver, WebElement to, WebElement from) {
		Actions action = new Actions(driver);
		action.clickAndHold(from).build().perform();
		action.moveToElement(to).build().perform();
		action.release(to).build().perform();
	}

	// to double click
	public static void doubleClick(WebDriver driver) {
		new Actions(driver).doubleClick().perform();
	}

	// to double click on an element
	public static void doubleClick(WebDriver driver, WebElement element) {
		new Actions(driver).doubleClick(element).perform();
	}

	// to right click
	public static void mouseRightClick(WebDriver driver) {
		new Actions(driver).contextClick().perform();
	}

	// to right click on an element
	public static void mouseRightClick(WebDriver driver, WebElement element) {
		new Actions(driver).contextClick(element).perform();
	}

	// to get tool tip text using getAttribute---title
	public static String getToolTipText(WebElement element) {
		String toolTipText = element.getAttribute("title");
		return toolTipText;
	}

	// to get toolTip text
	public static String getToolTipText(WebDriver driver, WebElement hoverElement, WebElement toolTipElement) {
		new Actions(driver).moveToElement(hoverElement).build().perform();
		String toolTipText = toolTipElement.getText();//getAttribute("");
		return toolTipText;
	}
}
