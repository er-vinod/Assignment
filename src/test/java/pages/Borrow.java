package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utility.WebUtil;

public class Borrow extends BorrowOR{
	
	
	public WebUtil util= WebUtil.getWebUtilObj();
	
	
	public Borrow() {
		PageFactory.initElements(util.getDriver(), this);
	}
	
	
	public void selectApplicationType(String type) {
		for (WebElement webElement : weApplicationType) {
			String act = util.getText(webElement, "Application type");
			if(type.equalsIgnoreCase(act)) {
				util.click(webElement, type);
			}
		}
	}
	public void selectNoOfDependant(String NoOfDependant ) {
		util.selectDropDown(weNoOfDependantDD, NoOfDependant, "Number of dependants Drop Down");
	}
	
	public void selectPropertyType(String PropertyType) {
		
		for (WebElement webElement : wePropertyTypeRD) {
			String actPropertyType = util.getText(webElement, PropertyType);
			if(actPropertyType.equalsIgnoreCase(PropertyType)) {
				util.click(webElement, PropertyType);
			}
		}
	}
	
	public void enterAnnualIncome(String annualIncome) {
		util.clearEditBox(weIncomeED, "Annual Income");
		util.sendkeys(weIncomeED,annualIncome, "Annual Income Edit Box");
	}
	
	public void enterOtherIncome(String otherIncome) {
		util.clearEditBox(weOtherIncomeED, "Other Income");
		util.sendkeys(weOtherIncomeED,otherIncome, "other Income Edit Box");
	}
	
	public void enterLivingExpenses(String livingEXp) {
		util.clearEditBox(weLivingExpensesED, "Monthly Living Expenses");
		util.sendkeys(weLivingExpensesED, livingEXp, "Monthly Living Expenses Edit Box");
	}
	
	public void enterHomeLoanRepayment(String homeLoan) {
		util.clearEditBox(weHomeLoanMonthlyRepaymentsED, "Home Loan Repayment");
		util.sendkeys(weHomeLoanMonthlyRepaymentsED, homeLoan, "Home Loan Repayment Edit Box");
	}
	
	public void enterOtherLoanRepayment(String otherLoan) {
		util.clearEditBox(weOtherLoanMonthlyRepaymentsED, "Other Loan Repayment");
		util.sendkeys(weOtherLoanMonthlyRepaymentsED, otherLoan, "Other Loan Repayment Edit Box");
	}
	
	public void enterMonthlyCommitments(String commits) {
		util.clearEditBox(weMonthlyCommitmentsED, "Monthly Commitments");
		util.sendkeys(weMonthlyCommitmentsED, commits, "Monthly Commitments Edit Box");
	}
	
	public void enterCreditsCardsLimit(String credits) {
		util.clearEditBox(weCreditCardsLimitsED, "Credits Cards Limit");
		util.sendkeys(weCreditCardsLimitsED, credits, "Credits Cards Limit Edit Box");
	}
	
	public void clickHowMuchICouldBorrowButton() {
		util.click(weHowMuchICouldBorrowBT, "How Much I Could Borrow Button");
	}
	
	public String getBorrowResult() {
		util.holdOn(3);
		return util.getText(weBorrowResultTXT, "Borrow Result text");
	}
	
	public void ClickStartOver() {
		util.click(weStartOverRST, "Start Over Link");
	}
	
	public String getErrorText() {
		return util.getText(weErrorTXT, "Error Message");
	}
}
