package com.sai.automation.stepdefs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sai.automation.page.datatables.LoginPageRegisterDataTable;
import com.sai.automation.pageobjects.PageFactory;

import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationStepDefs extends AbstractStepDefs{

	@Autowired
	private PageFactory pageFactory;
	
	@Given("navigated to facebook url")
	public void navigateToUrl()
	{
//		loginPage = new MobileLoginPage();
//		loginPage.navigateToUrl(super.getUrl());
		pageFactory.getLoginPage().navigateToUrl("http://fb.com");
	}
	
	@When("account is created with below details")
	public void createAccount(@Transpose List<LoginPageRegisterDataTable> loginPageRegisterDataTableList)
	{
		for(LoginPageRegisterDataTable loginPageRegisterDataTable : loginPageRegisterDataTableList)
			pageFactory.getLoginPage().createAccount(loginPageRegisterDataTable);
	}
	
	@Then("account is created succesfully")
	public void verifyAccountIsCreated()
	{
		//TODO
	}
}
