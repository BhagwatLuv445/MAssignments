package Locators;

import org.openqa.selenium.By;

public class Locators {

	public static By locatorValue(String locatorType, String locatorValue) {
		By by;

		switch (locatorType) {
		case "id":
			by = By.id(locatorValue);
			break;
		case "name":
			by = By.name(locatorValue);
			break;
		case "cssSelector":
			by = By.cssSelector(locatorValue);
			break;
		case "className":
			by = By.className(locatorValue);
			break;
		case "linkText":
			by = By.linkText(locatorValue);
			break;
		case "partialLinkText":
			by = By.partialLinkText(locatorValue);
			break;
		case "tagName":
			by = By.tagName(locatorValue);
			break;
		case "xpath":
			by = By.xpath(locatorValue);
			break;
		default : by = null;
		}
		if(by == null){
			System.out.println("Locator is not found");
		}
		return by;
	}
}
