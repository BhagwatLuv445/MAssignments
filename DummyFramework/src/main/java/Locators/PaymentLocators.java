package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Base.TestBase;

public class PaymentLocators extends TestBase {

	@FindBy(how = How.XPATH, using = "")
	protected WebElement creditCardBtn;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement nameOnCreditCard;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement creditCardNumber;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement ccExpireMonth;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement ccExpireYear;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement ccAddYourCardBtn;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement debitCardBtn;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement nameOnDebitCard;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement creditDebitNumber;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement dcExpireMonth;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement dcExpireYear;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement cvvNumber;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement dcAddYourCardBtn;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement netBankingBtn;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement CashOnDeliveryBtn;

	@FindBy(how = How.XPATH, using = "")
	protected WebElement confirmPaymentBtn;
}
