package Interfaces;

public interface IAddToCartPage {

	void clickOnIncreaseDD(String number);

	void clickOnDecreaseDD(String number);

	void clickOnAddToCartBtn();

	void clickOnBuyNowBtn();

	void clickRemoveProductBtn();

	// Address Page
	void enterFirstName(String firstName);

	void enterLastName(String lastName);

	void enterHouseNumber(String houseNumber);

	void enterStreetNumber(String StreetNumber);

	void enterCity(String city);

	void enterState(String state);

	void enterPincode(String pinCode);

	void enterMobileNumber(String mobileNumber);

	void clickOnContinueBtn();
}
