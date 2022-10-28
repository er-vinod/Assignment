

Feature: Home loan borrowing power calculator

Background: setUp for tests
	Given user launch "chrome" browser with reportFile "Assignment1Reoprt"
	When  user open url "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
	Then  "Home loan borrowing power calculator"  page should be appeared
 # @assignment1
  Scenario: a person with the following details
    Given application type "Single"
    And No of dependants "0"
    And buying a "home to live in"
    And with income of $"80000"
    And other income $"10000"
    And living expenses $"500"
    And current home loan repayments $"0"
    And other loan repayments $"100"
    And other commitments $"0"
    And and total credit card limits $"10,000"
    When click on Work out how much I could borrow
    Then has a borrowing estimate of $"419,000"
    When Clicking the Start Over button
    And  living expenses $"1"
    And  click on Work out how much I could borrow
    Then returns the following message: "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."