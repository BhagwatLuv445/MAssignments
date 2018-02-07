package Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.TestBase;

public class ToolsQaTest extends TestBase {

	@Test(priority = 2)
	public void fillPersonalInfoTest() throws IOException {
		toolsQa.fillPersonalInfo("Bhagwat", "Prajapati", "Male", "1", "15/01/2018", "Automation Tester",
				"C:\\Users\\M1043004\\Downloads\\Personal_Data\\bhagwat_prajapati.jpg", "Selenium Webdriver", "Asia",
				"WebElement Commands");
	}
	
	@Test(priority = 0)
	public void clickOnPartialLink(){
		toolsQa.clickOnPartialLink();
	}
	
	@Test(priority = 1)
	public void clickOnLink(){
		toolsQa.clickOnLink();
	}
	
	@Test(priority = 3)
	public void downLoadFile() throws InterruptedException{
		toolsQa.downLoadFile();
	}
}
