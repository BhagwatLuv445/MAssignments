package Operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestCases.TestImplement;

public class Operation extends TestImplement{

	public static void click(WebElement element)
	{
		try
		{
			new WebDriverWait(webdriver, 5000).until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}catch(Exception e)
		{
			System.out.println("Element not clickable");
		}
	}
	public static void enterTextField(WebElement element, String data) 
	{
		try
		{
			if(element.getText() != null || element.getText() != "")
			{
				element.clear();
				element.sendKeys(data);
			}
		}catch(Exception e)
		{
			System.out.println("Element is no there");
			System.out.println("can't fill");
		}
	}

	// to click a radio button
	public static void clickRadio(WebElement element) 
	{
		element.click();
	}

	// to click a radio button using it's index position
	public static void clickRadio(List<WebElement> element, int index) 
	{
		element.get(index).click();
	}

	// SELECTING RADIO BUTTON FROM THE LIST OF RADIO BUTTON
	public static void selectRadioBtn(List<WebElement> select, String value) 
	{
		for (WebElement radio : select) 
		{
			if (radio.getAttribute("value").equalsIgnoreCase(value)) 
			{
				radio.click();
			}
		}
	}

	// SELECTING MULTIPLE CHECKBOXES
	public static void selectMultipleCheck_Box(List<WebElement> chk_boxes, String values) 
	{
		List<String> list = new ArrayList<String>(Arrays.asList(values.split(",")));
		for (String value : list) 
		{
			for (WebElement checkBox : chk_boxes) 
			{
				if (checkBox.getAttribute("value").equalsIgnoreCase(value))
					checkBox.click();
			}
		}
	}

	// SELECT BY VISIBLETEXT
	public static void selectByVisibleText(WebElement element, String value) 
	{
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	// SELECTbYvALUE
	public void selectByValue(WebElement element, String value) 
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// Select By Index
	public static void selectByIndex(WebElement element, int index) 
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
}