package com.ferrariClub.actions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void clickElements(WebElement element) {
		element.click();
	}

	public static void check_checkBox(WebElement element) {
		if (!element.isSelected()) {
			element.click();
		}
	}

	public static void uncheck_checkBox(WebElement element) {
		if (element.isSelected()) {
			element.click();
		}
	}

	public static void mouseOver(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).build().perform();
	}

	public static void clickRadio(WebElement element) {
		element.click();
	}

	public static void clickRadio(List<WebElement> element, int index) {
		element.get(index).click();
	}

	public static void dragAndDrop(WebDriver driver, WebElement dragElement, WebElement dropElement) {
		new Actions(driver).dragAndDrop(dragElement, dropElement).perform();
	}
	
	public static void doubleClick(WebDriver driver){
		new Actions(driver).doubleClick().perform();
	}
	
	public static void doubleClick(WebDriver driver, WebElement element){
		new Actions(driver).doubleClick(element).perform();
	}
	
	public static void mouseRightClick(WebDriver driver){
		new Actions(driver).contextClick().perform();
	}
	
	public static void mouseRightClick(WebDriver driver, WebElement element){
		new Actions(driver).contextClick(element).perform();
	}
}
