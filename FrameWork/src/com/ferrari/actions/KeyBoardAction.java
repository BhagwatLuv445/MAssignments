package com.ferrari.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardAction {

	public static void enterTextField(WebElement element, String data){
		element.clear();
		element.sendKeys(data);
	}
	
	public static void pressEnter(WebDriver driver){
		new Actions(driver).sendKeys(Keys.ENTER).perform();
	}
	
	public static void pressTab(WebDriver driver){
		new Actions(driver).sendKeys(Keys.TAB).perform();
	}
	
	public static void pressControlT(WebDriver driver){
		new Actions(driver).keyDown(Keys.CONTROL + "\t").keyUp(Keys.CONTROL).build().perform();
	}
}
