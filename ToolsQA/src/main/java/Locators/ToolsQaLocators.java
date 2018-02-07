package Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Base.TestBase;

public class ToolsQaLocators extends TestBase{

	@FindBy(how = How.XPATH, using = "//form/fieldset/div[2]/a/strong")
	protected WebElement partialLinkTest;

	@FindBy(how = How.XPATH, using = "//form/fieldset/div[5]/a/strong")
	protected WebElement linkTest;

	@FindBy(how = How.XPATH, using = "//input[@name='firstname']")
	protected WebElement firstNameField;

	@FindBy(how = How.XPATH, using = "//input[@name='lastname']")
	protected WebElement lastNameField;

	@FindBy(how = How.XPATH, using = "//*[@name='sex']")
	protected List<WebElement> sexRadio;

	@FindBy(how = How.XPATH, using = "//*[@name='exp']")
	protected List<WebElement> yoExpRadio;
	
	@FindBy(how=How.XPATH, using="//*[@id='datepicker']")
	protected WebElement datePicker;
	
	@FindBy(how=How.XPATH, using="//input[@name='profession']")
	protected List<WebElement> professionchkBox;
	
	@FindBy(how=How.XPATH,using="//*[@name='photo']")
	protected WebElement profilePicture;
	
	@FindBy(how=How.XPATH, using="//*[@name='tool']")
	protected List<WebElement> toolschkBox;
	
	@FindBy(how=How.XPATH,using="//*[@name='continents']")
	protected WebElement continents;
	
	@FindBy(how=How.XPATH, using="//form/fieldset/div[25]/a")
	protected WebElement seleniumDownloadLink;
	
	@FindBy(how=How.XPATH,using="//form/fieldset/div[26]/a")
	protected WebElement testFileDownload;
	
	@FindBy(how=How.XPATH,using="//*[@id='selenium_commands']")
	protected WebElement seleniumCommand;
	
	@FindBy(how=How.XPATH,using="//*[@id='submit']")
	protected WebElement submitBtn;
}
