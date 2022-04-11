Feature: Login

Scenario: Successful login with valid credentails
	Given User launches chrome browser
	When User opens URL "http://demowebshop.tricentis.com/"
	And Click on LogIn header link
	And User enters Email as "pramod@gmail.com" and Password as "123456"
	And Click on Login button
	Then Check the Logout link is displayed
	When User Click on Logout link
	And close the browser
	
Scenario: Display of Header links
	Given User launches chrome browser
	When User opens URL "http://demowebshop.tricentis.com/"
	And Check the display of Register link
	And Check the display of Login
	And Check  
