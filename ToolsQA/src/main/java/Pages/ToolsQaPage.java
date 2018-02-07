package Pages;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Actions.InputField;
import Assestions.Assertions;
import Exceptions.CheckDir;
import Exceptions.checkFile;
import Interfaces.IToolsQa;
import Locators.ToolsQaLocators;
import Utility.WaitUtil;

public class ToolsQaPage extends ToolsQaLocators implements IToolsQa {

	private static String downloadPath = "C:\\Users\\M1043004\\Downloads";

	public ToolsQaPage() {
		PageFactory.initElements(driver, this);
	}

	public void fillPersonalInfo(String firstName, String lastName, String sex, String yoExp, String date,
			String profession, String photo, String tools, String continent, String seleniumCommands)
			throws IOException {
		Assertions.sendKey(firstNameField, firstName);
		Assertions.sendKey(lastNameField, lastName);
		InputField.selectRadioBtn(sexRadio, sex);
		InputField.selectRadioBtn(yoExpRadio, yoExp);
		Assertions.sendKey(datePicker, date);
		InputField.selectMultipleCheck_Box(professionchkBox, profession);
		Assertions.sendKey(profilePicture, photo);
		InputField.selectMultipleCheck_Box(toolschkBox, tools);
		InputField.selectByVisibleText(continents, continent);
		InputField.selectByVisibleText(seleniumCommand, seleniumCommands);
		WaitUtil.waitForElementToBeClickable(submitBtn);
	}

	public void clickOnPartialLink() {
		partialLinkTest.click();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		// driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		String expectedTitle = "Demo Form for practicing Selenium Automation";
		assertEquals(expectedTitle, actualTitle);
	}

	public void clickOnLink() {
		linkTest.click();
		driver.navigate().back();
	}

	public void downLoadFile() throws InterruptedException {
		seleniumDownloadLink.click();
		Object fileName = CheckDir.checkDir(downloadPath);
		System.out.println(fileName);
		if (fileName.toString().contains("OnlineStore")) {
			log.info("OnlineStore file downloaded successfully");
		} else {
			log.info("File is not downloaded");
		}
		testFileDownload.click();
		Object fileName1 = CheckDir.checkDir(downloadPath);
		System.out.println(fileName1);
		if (fileName1.toString().contains("Test-File-to-Download")) {
			log.info("Test-File-to-Download successfully");
		} else {
			log.info("xlsx file is not downloaded");
		}
	}
}
