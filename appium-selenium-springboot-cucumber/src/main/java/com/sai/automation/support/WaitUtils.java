package com.sai.automation.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WaitUtils {

	@Value("${wait.visibility.seconds}")
	private String waitForVisibityTimeInSeconds;
	
	public void waitForVisibilityOfElement(WebDriver driver, By by)
	{
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(waitForVisibityTimeInSeconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
