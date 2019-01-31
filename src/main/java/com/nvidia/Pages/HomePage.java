package com.nvidia.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.nvidia.reusablecomponents.InitialClass;
import com.nvidia.reusablecomponents.Utility;

public class HomePage extends InitialClass{

	@FindBy(xpath=".//div[@class='sub-brand-nav']//div/a[contains(text(),'Shop')]")
	WebElement tabShop;
	
	Utility util = new Utility();
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		util.waitForPageLoad(driver);
		String expectedTitle = "Artificial Intelligence Computing Leadership from NVIDIA";
		Assert.assertTrue(verifyPageTitle(driver.getTitle(), expectedTitle), expectedTitle);
	}
	
	public void clickOnShop() throws InterruptedException {
		util.elementDisplayed(tabShop);
		tabShop.click();
		Thread.sleep(5000);
	}

}
