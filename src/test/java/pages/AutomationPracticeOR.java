package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeOR {
	
	
	@FindBy(xpath = "//div[@id='contact-link']//preceding-sibling::div//a")
	 WebElement weSignInLNK;
	
	@FindBy(id = "email_create")
	 WebElement weEmailED;
	
	@FindBy(xpath = "//button[@id='SubmitCreate']")
	 WebElement weCeateAccountLNK;

	@FindBy(xpath = "//div[@id='uniform-id_gender1']")
	 WebElement weMrRD;

	@FindBy(xpath = "//div[@id='uniform-id_gender2']")
	 WebElement weMrsRD;
	
	@FindBy(id = "customer_firstname")
	 WebElement weFirstNameED;

	@FindBy(id = "customer_lastname")
	 WebElement weLastNameED;

	@FindBy(id = "passwd")
	 WebElement wePasswordED;
	
	@FindBy(id = "years")
	 WebElement weYearsDD;
	
	@FindBy(id = "months")
	 WebElement weMonthDD;
	
	@FindBy(id = "days")
	 WebElement weDaysDD;

	@FindBy(id = "firstname")
	 WebElement weAddressFirstNameED;
	
	@FindBy(id = "lastname")
	 WebElement weAddressLastNameED;
	
	@FindBy(id = "company")
	 WebElement weCompanyED;
	
	@FindBy(id = "address1")
	 WebElement weAddressED;
	
	@FindBy(id = "address2")
	 WebElement weAddress2ED;
	
	@FindBy(id = "city")
	 WebElement weCityED;
	
	@FindBy(id = "id_state")
	 WebElement weStateDD;
	
	@FindBy(id = "postcode")
	 WebElement wePincodeED;
	
	@FindBy(id = "id_country")
	 WebElement weCountryDD;
	
	@FindBy(id = "other")
	 WebElement weAdditionalInfoED;
	
	@FindBy(id = "phone")
	 WebElement weHomePhoneED;
	
	@FindBy(id = "phone_mobile")
	 WebElement weMobileED;
	
	@FindBy(id = "alias")
	 WebElement weAddressAliasED;
	
	@FindBy(id = "submitAccount")
	 WebElement weRegisterLNK;
	
	@FindBy(xpath = "//a[@title='View my customer account']//span")
	WebElement weNameSurnameTXT;
	
	@FindBy(id = "email")
	WebElement weLoginEmailED;
	
	@FindBy(id = "passwd")
	WebElement weLoginPasswordED;
	
	@FindBy(id = "SubmitLogin")
	WebElement weSigninBT;
	
	@FindBy(xpath = "//a[@title='Log me out']")
	WebElement weSignOutLNK;
	
	@FindBy(xpath = "//span[text()='Quick view']")
	WebElement weProduct;
	
	@FindBy(xpath = "//span[text()=' Home']")
	WebElement weHomeBTN;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement weAddToCartBTN;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement weCheckOutBTN;
	
	@FindBy(xpath = "//h5//a[contains(@title,'T-shirts')]")
	WebElement weProductTshirt;
	
	@FindBy(xpath="//p[@id='product_reference']//parent::div/h1")
	WebElement weProductName;
	
	@FindBy(xpath="//tr[@id='product_1_1_0_761716']//p/a")
	WebElement weProductNameAtPayment;
	
	@FindBy(id = "our_price_display")
	WebElement weProductPrice;
	
	@FindBy(xpath  = "//span[@id='product_price_1_1_761716']//span")
	WebElement weProductPriceAtPayment;
}
