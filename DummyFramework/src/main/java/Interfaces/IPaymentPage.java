package Interfaces;

public interface IPaymentPage {
	void enterCreditCard(String nameOnCreditCard, String creditCardNumber, String ccExpireMonth, String ccExpireYear);

	void selectDebitCard(String nameOnCreditCard, String creditCardNumber, String expireMonth, String expireYear,
			String cvv);

	void selectNetBanking(String bankName);

	void selectCashOnDelivery();
}
