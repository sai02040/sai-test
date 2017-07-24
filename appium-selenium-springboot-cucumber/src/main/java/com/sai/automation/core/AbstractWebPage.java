package com.sai.automation.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractWebPage {

	@Autowired
	private DriverFactory driverFactory;
	@Autowired
	private Find find;
	
	public void click(By by)
	{
		WebElement element = find.findElement(by);
		Actions actions = new Actions(driverFactory.getDriver());
		actions.moveToElement(element).click().build().perform();
	}
	
	public void setText(By by, String text)
	{
		WebElement element = find.findElement(by);
		Actions actions = new Actions(driverFactory.getDriver());
		actions.moveToElement(element).perform();
		element.clear();
		element.sendKeys(text);
	}
	
	public void appendText(By by, String text)
	{
		WebElement element = find.findElement(by);
		Actions actions = new Actions(driverFactory.getDriver());
		actions.moveToElement(element).sendKeys(text).perform();
	}
	
	public void navigateToUrl(String url)
	{
		driverFactory.getDriver();
		driverFactory.getDriver().navigate().to(url);
	}
	
}
