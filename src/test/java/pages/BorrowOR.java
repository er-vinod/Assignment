package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BorrowOR {

	@FindBy(xpath = "//input[@name='application_type']//parent::label")
	protected  List<WebElement>  weApplicationType;
	
	@FindBy(xpath = "//select[@title='Number of dependants']")
	protected WebElement weNoOfDependantDD;
	
	@FindBy(xpath = "//input[contains(@id,'borrow_type')]//parent::label")
	protected List<WebElement> wePropertyTypeRD;
	
	
	@FindBy(xpath = "//span[@id='q2q1i1']//following-sibling::input")
	protected WebElement weIncomeED;
	
	
	@FindBy(xpath = "//span[@id='q2q2i1']//following-sibling::input")
	protected WebElement weOtherIncomeED;
	
	
	@FindBy(xpath = "//span[@id='q3q1i1']//following-sibling::input")
	protected WebElement weLivingExpensesED;
	
	@FindBy(xpath = "//span[@id='q3q2i1']//following-sibling::input")
	protected WebElement weHomeLoanMonthlyRepaymentsED;
	
	
	@FindBy(xpath = "//span[@id='q3q3i1']//following-sibling::input")
	protected WebElement weOtherLoanMonthlyRepaymentsED;
	
	
	@FindBy(xpath = "//span[@id='q3q4i1']//following-sibling::input")
	protected WebElement weMonthlyCommitmentsED;
	
	
	@FindBy(xpath = "//span[@id='q3q5i1']//following-sibling::input")
	protected WebElement weCreditCardsLimitsED;
	
	@FindBy(id="btnBorrowCalculater")
	protected WebElement weHowMuchICouldBorrowBT;
	
	@FindBy(id="borrowResultTextAmount")
	protected WebElement weBorrowResultTXT;
	
	
	@FindBy(xpath = "//button[@class='start-over']")
	protected WebElement weStartOverRST;
	
	@FindBy(xpath = "//div[@class='borrow__error__text']")
	protected WebElement weErrorTXT;
	
}
