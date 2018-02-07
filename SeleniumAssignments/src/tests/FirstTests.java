package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.AddToCartConfirmPage;
import page.CartPage;
import page.HomePage;
import page.ProductDetailsPage;
import page.SearchResultsPage;

public class FirstTests {

	private WebDriver driver;
	private HomePage homePage;

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		System.setProperty("webdriver.chrome.driver","D:\\tools\\SeleniumWebDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@BeforeMethod(alwaysRun = true)
	public void openHomePage() {
		homePage = new HomePage(driver).open();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testAddingItemToCard() {
		SearchResultsPage searchResultsPage = homePage.navigationMenu().searchFor("Electronics", "refrigerator");
		String itemTitle = searchResultsPage.getFirstResultTitle();
		ProductDetailsPage productDetailsPage = searchResultsPage.clickFirstResultTitle();
		assert (productDetailsPage.getProductTitle().equals(itemTitle));
		AddToCartConfirmPage addToCartConfirmPage = productDetailsPage.addToCart();
		assert (addToCartConfirmPage.getConfirmationText().equals("1 item added to Cart"));
		CartPage cartPage = addToCartConfirmPage.navigationMenu().navigateToCartPage();
		//assert (cartPage.getFirstItemText().contains(itemTitle));
				
	}

	/*@Test
	public void testSignInSignOut() throws InterruptedException { // TODO refactor to use page objects
		// Navigate to 'Your Account' page
		driver.findElement(By.xpath("//span[text()='Hello. Sign in']")).click();
		Thread.sleep(5000);
		//driver.findElement(By.linkText("Sign in")).click();
		//Thread.sleep(5000);
		// Enter e-mail address
		driver.findElement(By.id("ap_email")).sendKeys("7000426261");

		// Enter password
		driver.findElement(By.id("ap_password")).sendKeys("9752509094");

		// Click 'Sign in using our secure server' button
		driver.findElement(By.id("signInSubmit")).click();

		// Verify 'Your Account' button contains the name of the user
		//assert (driver.findElement(By.xpath("//span[text()='Hello. Bhagwat']")).getText().contains("Hello, Bhagwat"));

		// Hover over a "Your account" button and click on "Sign Out"
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Hello, Bhagwat']"))).perform();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign Out")).click();

		// Verify "Sign In" form appears
		assert (driver.findElement(By.name("signIn")).isDisplayed());
	}*/
}
