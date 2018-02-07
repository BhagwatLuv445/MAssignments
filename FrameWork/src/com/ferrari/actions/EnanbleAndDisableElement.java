package com.ferrari.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class EnanbleAndDisableElement {

	public void disable(WebDriver driver, String nameOfHtmlElement){
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		  String todisable = "document.getElementsByName(nameOfHtmlElement)[0].setAttribute('disabled', '');";
		  javascript.executeScript(todisable);
		  //Thread.sleep(2000);
	}
	
	
}
