package com.sai.automation.support;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.stereotype.Component;

@Component
public class Verifications {
	
	public <T> void verifyEquals(String description, T actual, T expected)
	{
		assertThat(actual).as(description).isEqualTo(expected);
	}
	
	public void verifyTrue(String description, boolean value)
	{
		assertThat(value).as(description).isTrue();
	}
	
	public void verifyFalse(String description, boolean value)
	{
		assertThat(value).as(description).isFalse();
	}

}
