package com.sai.automation.stepdefs;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sai.automation.SpringBootTestApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBootTestApplication.class)
@SpringBootTest
public class AbstractStepDefs {

	@Value("{app.url}")
	private String appUrl;
	
	@Value("${platform}")
	private String platform;
	
	public String getUrl()
	{
		return this.appUrl;
	}
	
	public String getPlatform()
	{
		return this.platform;
	}
}
