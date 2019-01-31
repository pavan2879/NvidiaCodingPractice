package com.nvidia.controller;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class DriverSetup {
	
	protected WebDriver driver = null;
	protected String chromeDriverPath = "";
	
	@Test
	public void runTest() throws Exception {
		launchBrowser();
		test();
	}

	public void test() throws Exception {
	
	}
	
	public void openPage(String url) throws Exception {
		driver.get(url);
	}
	
	public void launchBrowser() throws MalformedURLException, InterruptedException {
		chromeDriverPath = System.getProperty("user.dir") +"/"+ "chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.focus();");
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() throws Exception {
		if (driver != null)
			driver.quit();
	}

}
