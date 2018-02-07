package Assestions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Base.TestBase;
import Reports.ScreenShot;

public class Assertions extends TestBase {

	public static void MatchTitle(String actual, String expected) throws Exception {
		try {
			assertEquals(actual, expected);
		} catch (Exception e) {
			throw new Exception("title mismatch exception" + e.getMessage());
		}
	}

	public static boolean isPresent(String xpat) {
		if (driver.findElements(By.xpath(xpat)).size() != 0) {
			return true;
		} else
			return false;
	}

	public static boolean isVisible(String xpat) {
		if (driver.findElement(By.xpath(xpat)).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public static boolean isEnabled(String xpat) {
		if (driver.findElement(By.xpath(xpat)).isEnabled()) {
			return true;
		} else
			return false;
	}

	public static void click(String xpat) throws IOException {
		if (isPresent(xpat)) {
			if (isVisible(xpat)) {
				if (isEnabled(xpat)) {
					System.out.println("Button is enabled");
				} else {
					System.out.println("Element is disabled");
				}

				WebElement we = driver.findElement(By.xpath(xpat));
				boolean bol = we.isDisplayed();
				Assert.assertEquals(true, bol);
				System.out.println("button is present");
				System.out.println("button is visible");
				ScreenShot.takeSnapShot("clickError");
			}
		} else {
			System.out.println("button isinvisible");
			ScreenShot.takeSnapShot("ButtonNotAvailable");

		}
	}

	public static void sendKey(WebElement element, String key) throws IOException {
		// WebElement element=driver.findElement(By.xpath(xpat));

		try {
			Assert.assertNotNull(element);
			//element.clear();
			element.sendKeys(key);
		} catch (NoSuchElementException e) {
			System.out.println("No such element found");
			ScreenShot.takeSnapShot("NosuchElement");
		}
	}

	public static void select(String[] list, String xpat) {
		WebElement dropdown = driver.findElement(By.xpath(xpat));
		Select select = new Select(dropdown);

		List<WebElement> opt = select.getOptions();

		for (int i = 0; i < opt.size(); i++) {
			try {
				Assert.assertEquals(list[i], opt.get(i).getText());
				opt.get(i).click();
				System.out.println("matched");
			} catch (Exception e) {
				System.out.println("no matched");
			}
		}
	}

	public static void listCompare(List<Object> lis1, List<Object> lis2) {
		try {
			for (int i = 0; i < lis1.size(); i++) {
				Assert.assertEquals(lis1.get(i), lis2.get(i));
				System.out.println("List at" + i + "matched");
			}
		} catch (Exception e) {
			System.out.println("list not matched");
		}
	}

/*	public void setTripType(List<WebElement> radio,String trip) {

		if (trip.equalsIgnoreCase("Round Trip")) {
			log.info(trip + "Found");
			if (!radio.get(0).isSelected()) {
				radio.get(0).click();
				log.info("Round Trip Radio Button selected");
			}
		} else if (trip.equalsIgnoreCase("One Way")) {
			log.info(trip + "found");
			if (!radio.get(1).isSelected()) {
				radio.get(1).click();
				log.info("One Way trip Radio Button Selected");
			}
		} else {
			log.error("trip not found");
		}
	}*/

}
