package stepDefinition;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AutomationPractice;
import pages.Borrow;
import utility.WebUtil;

public class AssignmentSteps {
	WebUtil util = WebUtil.getWebUtilObj();
	Borrow  br;
	AutomationPractice ap;
	static String productName, productPrice;
	String productNameAtPayment, productPriceAtPayment;
	
	

	@Given("user launch {string} browser")
	public void user_launch_browser_with_report_file(String browser) {
		util.launchChromeBrowser(browser);
		
	}
	
	
	@When("user open url {string}")
	public void user_open_url(String url) {
		if(url.contains("automationpractice")) {
			//util.getExtentLogger("assignment2");
			ap=new AutomationPractice();
		}
		
		if(url.contains("www.anz.com.au")) {
			br=new Borrow();
		}
		
		util.openUrl(url);
	    
	}

	@Then("{string}  page should be appeared")
	public void page_should_be_appeared(String string) {
	
			 Assert.assertTrue(util.getTitle(string).contains(string));
			
	    
	}

	@Given("application type {string}")
	public void application_type(String string) {
	   br.selectApplicationType(string);
	}
	  
	@Given("No of dependants {string}")
	public void no_of_dependants(String string) {
	   br.selectNoOfDependant(string); 
	    
	}

	@Given("buying a {string}")
	public void buying_a(String string) {
	    br.selectPropertyType(string);
	    
	}

	@Given("with income of ${string}")
	public void with_income_of_$(String string) {
	    br.enterAnnualIncome(string);
	    
	}

	@Given("other income ${string}")
	public void other_income_$(String string) {
	    br.enterOtherIncome(string);
	    
	}

	@Given("living expenses ${string}")
	public void living_expenses_$(String string) {
	    br.enterLivingExpenses(string);
	    
	}

	@Given("current home loan repayments ${string}")
	public void current_home_loan_repayments_$(String string) {
	    br.enterHomeLoanRepayment(string);
	    
	}

	@Given("other loan repayments ${string}")
	public void other_loan_repayments_$(String string) {
	    br.enterOtherLoanRepayment(string);
	    
	}

	@Given("other commitments ${string}")
	public void other_commitments_$(String string) {
	   br.enterMonthlyCommitments(string); 
	    
	}

	@Given("and total credit card limits ${string}")
	public void and_total_credit_card_limits_$(String string) {
	    br.enterCreditsCardsLimit(string);
	    
	}

	@When("click on Work out how much I could borrow")
	public void click_on_work_out_how_much_i_could_borrow() {
	    br.clickHowMuchICouldBorrowButton();
	    
	}

	@Then("has a borrowing estimate of ${string}")
	public void has_a_borrowing_estimate_of_$(String string) {
	    Assert.assertTrue(br.getBorrowResult().contains(string));
	    
	}
	
	@When("Clicking the Start Over button")
	public void clicking_the_start_over_button() {
	   br.ClickStartOver();
	}

	@Then("returns the following message: {string}")
	public void returns_the_following_message(String string) {
	   String msg = br.getErrorText();
	   Assert.assertTrue(string.equals(msg));
	}
	
	@When("user click on Signin button")
	public void user_click_on_signin_button() {
	   ap.clickSignIn();
	   
	}
	
	@Given("user email Address {string}")
	public void user_email_address(String string) {
		ap=new AutomationPractice();
	   ap.entreEmail(string);
	}

	@When("user click on Create Account button")
	public void user_click_on_create_account_button() {
	   ap.clickCreateAccount();
	   
	}
	
	@Given("user first name {string}")
	public void user_first_name(String string) {
		ap=new AutomationPractice();
	    ap.entreCustomerFirstName(string);
	    
	}

	@Given("user last name {string}")
	public void user_last_name(String string) {
	   ap.entreCustomerLastName(string);
	}

	@Given("user password {string}")
	public void user_password(String string) {
	    ap.enterPassword(string);
	}

	@Given("user date of birth {string}")
	public void user_date_of_birth(String string) {
	    ap.enterDateOfBirth(string);
	}

	@Given("user Address {string}")
	public void user_address(String string) {
	   ap.enterAddress(string);
	}

	@Given("user city {string}")
	public void user_city(String string) {
	   ap.enterCity(string);
	}

	@Given("user country {string}")
	public void user_country(String string) {
	    ap.selectCountry(string);
	}

	@Given("user state {string}")
	public void user_state(String string) {
	    ap.selectState(string);
	}

	@Given("user zip {string}")
	public void user_zip(String string) {
	   ap.enterPostalCode(string);
	}

	@Given("user mobile {string}")
	public void user_mobile(String string) {
	    ap.enterMobile(string);
	}

	@Given("user address alias {string}")
	public void user_address_alias(String string) {
	   ap.enterAdderessAlias(string);
	}
	
	@When("user click on Register button")
	public void user_click_on_register_button() {
	    ap.clickRegister();
	}

	@Then("user name and surname should be displayed {string}")
	public void user_name_and_surname_should_be_displayed(String string) {
	   String actText = ap.getNameSurname();
	   Assert.assertTrue(actText.equals(string));
	}
	

	@Given("Email {string} and Password {string}")
	public void email_and_password(String string, String string2) {
	   ap = new AutomationPractice();
	   try {
		   ap.logout();
	} catch (NoSuchElementException e) {
		
	}
	  
	   ap = new AutomationPractice();
	   ap.enterLoginDetails(string, string2);
	}
	@When("click on signin button")
	public void click_on_signin_button() {
	   ap.clicklogin();
	   
	}
	
	

	@Given("a product page")
	public void a_product_page() {
	   ap= new AutomationPractice();
	   ap.clickHome();
	  
	   
	}
	@When("select a product")
	public void select_a_product() {
	   ap= new AutomationPractice();
	   ap.clickProduct();
	   
	}
	@When("get product detail")
	public void get_product_detail() {
		
		ap= new AutomationPractice();
	    productName= ap.getProductName();
	    productPrice = ap.getProductPrice();
	}
	@Then("click addtocart")
	public void click_addtocart() {
	   ap.addToCart();
	}

	
	@Given("checkout")
	public void checkout() {
		ap= new AutomationPractice();
	    ap.clickCheckOuts();
	}
	
	@When("save Product Detail")
	public void save_product_detail() {
		ap= new AutomationPractice();
		productNameAtPayment = ap.getProductNameAtPayment();
		productPriceAtPayment = ap.getProductPriceAtPayment();
	}
	
	@Then("verify product details")
	public void verify_product_details() {
	   Assert.assertTrue(productNameAtPayment.equalsIgnoreCase(productName));
	   Assert.assertTrue(productPriceAtPayment.equalsIgnoreCase(productPrice));

	}



}
