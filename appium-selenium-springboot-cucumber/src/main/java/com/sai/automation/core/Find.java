package com.sai.automation.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

@Component
public class Find {

	@Autowired
	private DriverFactory driverFactory;
	
	public WebElement findElement(By by)
	{
		return driverFactory.getDriver().findElement(by);
	}
	
	public WebElement findElementByXpath(String xpath)
	{
		return driverFactory.getDriver().findElement(By.xpath(xpath));
	}
	
	public WebElement findVisibleElement(By by)
	{
		List<WebElement> elements = driverFactory.getDriver().findElements(by);
		return elements.get(0);
	}
}
