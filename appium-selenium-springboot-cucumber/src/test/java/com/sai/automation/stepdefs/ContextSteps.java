package com.sai.automation.stepdefs;

import org.springframework.beans.factory.annotation.Autowired;

import com.sai.automation.core.DriverFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ContextSteps {
	
	@Autowired
	private DriverFactory driverFactory;

	@Before
	public void beforeScenario(Scenario scenario)
	{
		String executionStatus = String.format("Execution of scenario '%s' started...", scenario.getName());
		System.out.println(executionStatus);
	}
	
	@After
	public void afterScenario(Scenario scenario)
	{
		String executionStatus = String.format("Execution of scenario '%s' completed. Run status - %s", scenario.getName(), scenario.getStatus());
		System.out.println(executionStatus);
		driverFactory.removeDriver();
	}
}
