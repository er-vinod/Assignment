Feature:  Register on the website


Scenario: Click Signin on the landing page
	Given user launch "chrome" browser with reportFile "Assignment2Reoprt"
	And 	user open url "http://automationpractice.com/index.php"
	When  user click on Signin button
	Then  "Login - My Store"  page should be appeared
	
Scenario: Create Account by entering email address
	Given user email Address "abc123@abcd.efghi"
	When user click on Create Account button
	Then  "Login - My Store"  page should be appeared

	
Scenario:  Enter details on the Your Personal Information
	Given user first name "QA"
	And user last name "tester"
	And user password "abcd@123"
	And user date of birth "25-5-2000"
	And user Address "rz 12 niwas"
	And user city "xyz"
	And user country "United States"
	And user state "Alaska"
	And user zip "54321"
	And user mobile "9876543210"
	And user address alias "usa"
	When user click on Register button
	Then "My account - My Store"  page should be appeared
	And  user name and surname should be displayed "QA tester"

Scenario: Logout And Login
	Given Email "abc123@abcd.efghi" and Password "abcd@123"
	When click on signin button
	Then "My account - My Store"  page should be appeared


Scenario: Add a product to the cart
	Given a product page
	When select a product
	And get product detail
	Then click addtocart
	

Scenario: Proceed to the checkout page and continue till payments
	Given checkout
	When save Product Detail
	Then verify product details

	
	
	
 
