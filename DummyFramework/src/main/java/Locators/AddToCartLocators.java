package Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Base.TestBase;

public class AddToCartLocators extends TestBase{

	@FindBy(how=How.XPATH, using="")
	protected List<WebElement> itneIncreaseDD;

	@FindBy(how=How.XPATH, using="")
	protected List<WebElement> itneDecreaseDD;
	
	@FindBy(how=How.XPATH, using="")
	protected WebElement addToCartBtn;
	
	@FindBy(how=How.XPATH, using="")
	protected WebElement buyNowBtn;
	
	@FindBy(how=How.XPATH, using="")
	protected WebElement removeProductBtn;
	
	//Address Page
	@FindBy(how=How.XPATH, using="")
	protected WebElement firstName;

	@FindBy(how=How.XPATH, using="")
	protected WebElement lastName;
	
	@FindBy(how=How.XPATH, using="")
	protected WebElement houseNumber;
	
	@FindBy(how=How.XPATH, using="")
	protected WebElement streetNumber;
	
	@FindBy(how=How.XPATH, using="")
	protected WebElement city;
	
	@FindBy(how=How.XPATH, using="")
	protected WebElement state;

	@FindBy(how=How.XPATH, using="")
	protected WebElement pinCode;
	
	@FindBy(how=How.XPATH, using="")
	protected WebElement mobileNumber;
	
	@FindBy(how=How.XPATH, using="")
	protected WebElement continueBtn;		
}
