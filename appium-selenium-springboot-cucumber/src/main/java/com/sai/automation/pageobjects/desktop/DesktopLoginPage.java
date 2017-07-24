package com.sai.automation.pageobjects.desktop;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import com.sai.automation.core.AbstractWebPage;
import com.sai.automation.page.datatables.LoginPageRegisterDataTable;
import com.sai.automation.pageobjects.LoginPage;

@Component(value="desktop")
public class DesktopLoginPage extends AbstractWebPage implements LoginPage{

	private By firstName = By.xpath("//input[@name='firstname']");
	private By lastName = By.name("lastname");
	private By mobileNumber = By.xpath("//input[@aria-label='Mobile number or email address']");
	private By newPassword = By.xpath("//input[@aria-label='New password']");
	
	public void setFirstName(String firstName)
	{
		super.setText(this.firstName, firstName);
	}
	
	public void setLastName(String lastName)
	{
		super.setText(this.lastName, lastName);
	}
	
	public void setMobileNumber(String mobileNumber)
	{
		super.setText(this.mobileNumber, mobileNumber);
	}
	
	public void setPassword(String password)
	{
		super.setText(this.newPassword, password);
	}

	public void createAccount(LoginPageRegisterDataTable dataTable)
	{
		this.setFirstName(dataTable.getFirstName());
		this.setLastName(dataTable.getLastName());
		this.setMobileNumber(dataTable.getMobileNumber());
		this.setPassword(dataTable.getNewPassword());
	}

	public void clickOnCreateNewAccount() {
		// TODO Auto-generated method stub
	}
	
	
}
