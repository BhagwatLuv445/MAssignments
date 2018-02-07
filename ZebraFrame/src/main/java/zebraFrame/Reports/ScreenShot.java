package zebraFrame.Reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	static String filePath = "";
	public static String takeSnapShot(WebDriver driver,String screenshotName) throws IOException
	{
		String fileDest=System.getProperty("user.dir")+"/Screenshots/"+screenshotName+".png";
		try {
			
		
		TakesScreenshot takeScrShot = (TakesScreenshot) driver;

		File fileSrc = takeScrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fileSrc,new File(fileDest));
		System.out.println("Screenshot taken");
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());	
		}
		return fileDest;
	}
}
