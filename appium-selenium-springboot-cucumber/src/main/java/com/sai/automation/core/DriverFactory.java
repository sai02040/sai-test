package com.sai.automation.core;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DriverFactory {

	@Value("${browser.name}")
	private String browserName;
	@Value("${platform}")
	private String platform;
	@Value("${device.name}")
	private String deviceName;
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		if(driver.get()==null)
		{
			if(platform.equalsIgnoreCase("mobile"))
				driver.set(createAndroidDriver());
			else
				driver.set(createFirefoxDriver());
		}
		
		return driver.get();
	}

	public void removeDriver() {
		driver.get().quit();
		driver.remove();
	}
	
	private WebDriver createFirefoxDriver()
	{
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	private WebDriver createAndroidDriver() {
		DesiredCapabilities caps = DesiredCapabilities.android();
//		caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.ANDROID);
		caps.setCapability("platformName", "Android");
		caps.setCapability(CapabilityType.PLATFORM, Platform.ANDROID);
		caps.setCapability("deviceName", "Custom Phone");
		caps.setCapability(CapabilityType.VERSION, "4.4.4");
//		caps.setCapability("app", "null");
		caps.setCapability("browserName", "Browser");
		caps.setCapability("newCommandTimeout", 10000);
		try{
			URL remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");
			WebDriver driver = new RemoteWebDriver(remoteAddress, caps);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			((JavascriptExecutor) driver).executeScript("window.focus();");
			return driver;
		}catch(Exception e)
		{
			System.out.println("An error occured while creating andriod driver");
			return null;
		}
	}

}
