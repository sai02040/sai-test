Feature: Facebook registration 

Scenario: Register a user with all valid fields
	Given navigated to facebook url
	When account is created with below details
		|First Name|firstName|
		|Last Name|lastName|
		|Mobile Number|mobileNumber|
		|New Password|newPassword|
	Then account is created succesfully