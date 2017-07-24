package com.sai.automation.pageobjects;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PageFactory {

	@Autowired
	private Map<String,LoginPage> loginPages;
	private LoginPage loginPage;
	@Value("${platform}")
	private String platform;
	
	public LoginPage getLoginPage()
	{
		if(this.loginPage == null){
			Set<String> keys = loginPages.keySet();
			for(String key: keys)
			{
				if(key.contains(platform))
				{
					this.loginPage = loginPages.get(key);
					return this.loginPage;
				}
			}
		}
		return null;
	}
	
}
