package Actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardAction {

	public static void pressEnter(WebDriver driver) {
		new Actions(driver).sendKeys(Keys.ENTER).perform();
	}

	public static void pressTab(WebDriver driver) {
		new Actions(driver).sendKeys(Keys.TAB).perform();
	}

	public static void pressControlT(WebDriver driver) {
		new Actions(driver).keyDown(Keys.CONTROL + "\t").keyUp(Keys.CONTROL).build().perform();
	}

	// TO ENTERING CAPITAL LETTERS USING SHIFT KEY
	public static void pressShift(WebDriver driver, WebElement element, String item) {
		Actions action = new Actions(driver);
		Action seriesOfAction = action.moveToElement(element).click().keyDown(element, Keys.SHIFT).sendKeys(item)
				.keyUp(element, Keys.SHIFT).sendKeys(Keys.ENTER).build();
		seriesOfAction.perform();
	}
}
