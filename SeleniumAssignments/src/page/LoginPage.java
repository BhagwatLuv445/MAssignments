package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private static final String LOGIN_PAGE_URL = "…";
	private static final By USERNAME_INPUT = By.name("…");
	private static final By PASSWORD_INPUT = By.name("…");
	private static final By SIGN_IN_BUTTON = By.name("…");
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage open() {
		driver.get(LOGIN_PAGE_URL);
		return this;
	}

	public HomePage loginAs(String username, String password) {
		driver.findElement(USERNAME_INPUT).sendKeys(username);
		driver.findElement(PASSWORD_INPUT).sendKeys(password);
		driver.findElement(SIGN_IN_BUTTON).click();
		return new HomePage(driver);
	}
}
