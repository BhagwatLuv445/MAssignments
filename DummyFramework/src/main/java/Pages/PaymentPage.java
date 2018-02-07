package Pages;

import org.openqa.selenium.support.PageFactory;

import Locators.PaymentLocators;

public class PaymentPage extends PaymentLocators {

	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterCreditCard(String nameOnCreditCard, String creditCardNumber, String ccExpireMonth,
			String ccExpireYear) {

	}

	public void selectDebitCard(String nameOnCreditCard, String creditCardNumber, String expireMonth, String expireYear,
			String cvv) {

	}

	public void selectNetBanking(String bankName) {

	}

	public void selectCashOnDelivery() {

	}
}
