package com.ferrariClub.reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	static String filePath = "";
	public static void takeSnapShot(WebDriver driver) throws IOException {

		TakesScreenshot takeScrShot = (TakesScreenshot) driver;

		File fileSrc = takeScrShot.getScreenshotAs(OutputType.FILE);

		File fileDest = new File(filePath);
		
		FileUtils.copyFile(fileSrc, fileDest);
		
	}
}
