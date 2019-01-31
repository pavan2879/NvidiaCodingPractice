package com.nvidia.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.nvidia.reusablecomponents.InitialClass;
import com.nvidia.reusablecomponents.Utility;

public class StorePage extends InitialClass{
	
	@FindBy(xpath=".//input[contains(@class, 'list-view')]")
	WebElement btnListView;
	
	@FindBy(xpath=".//div[@id='mainCont']")
	WebElement mainContainer;
	
	
	Utility util = new Utility();
	
	public StorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		util.waitForPageLoad(driver);
		String expectedTitle = "Buy GeForce RTX Graphics Cards | NVIDIA GeForce Store";
		Assert.assertTrue(verifyPageTitle(driver.getTitle(), expectedTitle), expectedTitle);
	}
	
	public void changeToListView() {
		util.elementDisplayed(btnListView);
		btnListView.click();
	}
	
	public List<WebElement> outOfStocProducts(){
		List<WebElement> listOOS = driver.findElements(By.xpath(".//a[contains(@class,'out-of-stock')]//ancestor::div[contains(@class,'buy-col-lg')]/preceding-sibling::div[contains(@class,'details-col')]//h2"));
		return listOOS;
	}
	
	public List<WebElement> addToCartProducts(){
		List<WebElement> listAddToCart = driver.findElements(By.xpath(".//a[contains(@class,'js-add-button')]"));
		return listAddToCart;
	}
	
	public List<WebElement> buyNowProducts(){
		List<WebElement> listButNow = driver.findElements(By.xpath(".//div[contains(@class,'buy-link')]"));
		return listButNow;
	}
	
	

}
