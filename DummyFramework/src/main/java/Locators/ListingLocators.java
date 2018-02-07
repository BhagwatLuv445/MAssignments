package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Base.TestBase;

public class ListingLocators extends TestBase{

	@FindBy(how=How.XPATH, using="")
	protected WebElement searchBox;
	
	@FindBy(how=How.XPATH, using="")
	protected WebElement searchBtn;
	
	@FindBy(how=How.XPATH, using="")
	protected WebElement categoriesLink;
	
	@FindBy(how=How.XPATH, using="")
	protected WebElement productsLink ;
	
	@FindBy(how=How.XPATH, using="")
	protected WebElement addToCartIcon;			
}
