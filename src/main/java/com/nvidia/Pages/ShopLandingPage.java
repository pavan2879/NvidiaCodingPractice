package com.nvidia.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.nvidia.reusablecomponents.InitialClass;
import com.nvidia.reusablecomponents.Utility;

public class ShopLandingPage extends InitialClass{
	
	@FindBy(xpath=".//a/span[text()='GeForce']")
	WebElement shopGeForce;
	
	Utility util = new Utility();
	
	public ShopLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		util.waitForPageLoad(driver);
		String expectedTitle = "Welcome to the Official NVIDIA Store";
		Assert.assertTrue(verifyPageTitle(driver.getTitle(), expectedTitle), expectedTitle);
	}
	
	public void clickOnGeForceGraphicsCards() throws InterruptedException {
		util.elementDisplayed(shopGeForce);
		shopGeForce.click();
		Thread.sleep(5000);
	}

}
