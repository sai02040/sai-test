package com.sai.automation.pageobjects;

import com.sai.automation.page.datatables.LoginPageRegisterDataTable;

public interface LoginPage {

	public void navigateToUrl(String url);
	public void createAccount(LoginPageRegisterDataTable dataTable);
	public void clickOnCreateNewAccount();
	public void setFirstName(String firstName);
	public void setLastName(String lastName);
	public void setMobileNumber(String mobileNumber);
	public void setPassword(String password);
}
