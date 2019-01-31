package com.nvidia.reusablecomponents;

import org.openqa.selenium.WebDriver;

public class InitialClass {
	protected WebDriver driver = null;
	protected String expectedPageTitle = null;
	
	public InitialClass(WebDriver driver) {
		this.driver = driver;
	}
	
	public InitialClass() {
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	public boolean verifyPageTitle(String actual, String expected) {
		return actual.equalsIgnoreCase(expected);
	}
}
