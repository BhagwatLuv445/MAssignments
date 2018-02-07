package com.ferrari.utility;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaitUtil {

	WebDriver driver;
	public void clickLinkByHref(String href) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();

        while(i.hasNext()) {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(href)) {
                anchor.click();
                break;
            }
        }
    }
	
	
	public void selectByText(String text){
		List<WebElement> options = driver.findElements(By.xpath("")); 
		
		for(WebElement opt : options){
			if(opt.getText().equalsIgnoreCase(text)){
				opt.click();
				break;
			}else{
				System.out.println("match not found");
			}
		}
	}
}
