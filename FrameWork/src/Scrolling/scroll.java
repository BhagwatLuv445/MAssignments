package Scrolling;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class scroll {

	WebDriver driver;

	@Test
    public void ByPixel() {
        System.setProperty("webdriver.chrome.driver", "D:\\tools\\SeleniumWebDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the application		
        driver.get("http://demo.guru99.com/selenium/guru99home/scrolling.html");

        //To maximize the window. This code may not work with Selenium 3 jars. If script fails you can remove the line below		
        driver.manage().window().maximize();

        // This  will scroll down the page by  1000 pixel vertical	
        //x-pixels is the number at x-axis, it moves to the left if number is positive and it move to the right if number is negative .y-pixels is the number at y-axis, it moves to the down if number is positive and it move to the up if number is in negative .
        //js.executeScript("window.scrollBy(0,1000)");
        
        //to bottom
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //to particular element same for horizontal
        WebElement element = driver.findElement(By.xpath("//*[@id='rt-feature']/div[1]/div/p/a/img"));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}