package pages;

import org.openqa.selenium.support.PageFactory;

import utility.WebUtil;

public class AutomationPractice extends AutomationPracticeOR{
	
	WebUtil util = WebUtil.getWebUtilObj();
	
	public AutomationPractice() {
		PageFactory.initElements(util.getDriver(), this);
	}
	
	public void clickSignIn() {
		util.click(weSignInLNK, "SignIn Link");
	}
	
	public void entreEmail(String email) {
		util.sendkeys(weEmailED, email, "Email edit box");
	}
	
	public void clickCreateAccount() {
		util.click(weCeateAccountLNK, "Create Account Link");
		util.waitUntilElementInVisible(weCeateAccountLNK, 20);
	}
	
	public void selectTitle(String title) {
		if(title.equalsIgnoreCase("Mr")) {
			util.click(weMrRD, "Mr. Title");
		}
		
		if(title.equalsIgnoreCase("Mrs")) {
			util.click(weMrsRD, "Mrs Title");
		}
	}
	
	public void entreCustomerFirstName(String firstName) {
		util.sendkeys(weFirstNameED, firstName, "Customer First Name");
	}
	
	public void entreCustomerLastName(String lastName) {
		util.sendkeys(weLastNameED, lastName, "Customer Last Name");
	}
	
	
	public void enterPassword(String password) {
		util.sendkeys(wePasswordED, password, "Password Edit Box");
	}
	
	
	/**
	 * @param DOB should be in dd-mm-yyyy
	 */
	public void enterDateOfBirth(String dob) {
		String[] dobs= dob.split("-");
		String day= dobs[0];
		String month=dobs[1];
		String year = dobs[2];
		
		util.selectDropDown(weDaysDD, day, "Day Drop Down");
		util.selectDropDown(weMonthDD, month, "Month Drop Down");
		util.selectDropDown(weYearsDD, year, "Year Drop Down");	
	}
	
	public void enterAddressFirstName(String firstName) {
		util.sendkeys(weAddressFirstNameED, firstName, "Address First Name Edit Box");
	}
	
	public void enterAddressLastName(String lastName) {
		util.sendkeys(weAddressLastNameED, lastName, "Address Last Name Edit Box");
	}
	
	public void entreCompany(String company) {
		util.sendkeys(weCompanyED, company, "Company Edit Box");
	}
	
	public void enterAddress(String address) {
		util.sendkeys(weAddressED, address, "Address Edit Box");
	}
	
	public void enterAddress2(String address2) {
		util.sendkeys(weAddress2ED, address2, "Address(Line 2) Edit Box");
	}
	
	public void enterCity(String city) {
		util.sendkeys(weCityED, city, "City Edit Box");
	}
	
	public void selectState(String state) {
		util.selectDropDown(weStateDD, state, "State Drorp Down");
	}
	
	public void enterPostalCode(String postalCode) {
		util.sendkeys(wePincodeED, postalCode, "Postal Code Edit Box");
	}
	
	public void selectCountry(String country) {
		util.selectDropDown(weCountryDD, country, "Country Drop Down");
	}
	
	public void enterAdditionalInfo(String info) {
		util.sendkeys(weAdditionalInfoED, info, "Additional Information Edit Box");
		
	}
	
	public void enterHomePhone(String homePhone) {
		util.sendkeys(weHomePhoneED, homePhone, "Home Phone Edit Box");
	}
	
	public void enterMobile(String mobile) {
		util.sendkeys(weMobileED, mobile, mobile);
	}
	
	public void enterAdderessAlias(String alias) {
		util.clearEditBox(weAddressAliasED, "Address Alias Edit Box");
		util.sendkeys(weAddressAliasED, alias, "Address Alias Edit Box");
	}
	
	public void clickRegister() {
		util.click(weRegisterLNK, "Register Link");
	}
	public String getNameSurname() {
		return util.getText(weNameSurnameTXT,"Name Surname ");
	}
	public void enterLoginDetails(String user, String pass) {
		util.sendkeys(weLoginEmailED, user,"User Email Edit Box");
		util.sendkeys(weLoginPasswordED, pass, "User password Edit Box");
		
	}
	public void clicklogin() {
		util.click(weSigninBT, "Signin button");
	}
	
	public void logout() {
		util.click(weSignOutLNK, "Signout link");
	}
	public void clickHome() {
		util.click(weHomeBTN, "Home button");
	}
	
	public void clickProduct() {
		util.click(weProductTshirt, "Tshirt");
	}
	
	public String getProductName() {
		util.waitUntilElementIsVisible(weProductName, 20);
		return util.getText(weProductName,"Product Name");
	}
	
	public String getProductNameAtPayment() {
		util.waitUntilElementIsVisible(weProductNameAtPayment, 20);
		return util.getText(weProductNameAtPayment,"Product Name");
	}
	
	public String getProductPrice() {
		util.waitUntilElementIsVisible(weProductPrice, 20);
		return util.getText(weProductPrice, "Product Price");
		
	}
	
	public String getProductPriceAtPayment() {
		util.waitUntilElementIsVisible(weProductPriceAtPayment, 20);
		return util.getText(weProductPriceAtPayment, "Product Price");
		
	}
	
	public void addToCart() {
		util.click(weAddToCartBTN, "Addtocart button");
	}
	public void clickCheckOuts() {
		util.click(weCheckOutBTN, "Checkout button");
	}
	
}
