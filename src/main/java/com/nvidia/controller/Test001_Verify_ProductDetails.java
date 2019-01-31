package com.nvidia.controller;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.nvidia.Pages.HomePage;
import com.nvidia.Pages.ShopLandingPage;
import com.nvidia.Pages.StorePage;

public class Test001_Verify_ProductDetails extends DriverSetup{

	@Override
	public void test() throws Exception {
		openPage("https://www.nvidia.com");
		
		HomePage home = new HomePage(driver);
		home.clickOnShop();
		
		ShopLandingPage shop = new ShopLandingPage(driver);
		shop.clickOnGeForceGraphicsCards();
		
		StorePage store = new StorePage(driver);
		store.changeToListView();
		
		List<WebElement> listOOSProds = store.outOfStocProducts();
		System.out.println("Total Number of Out Of Stock Products: "+listOOSProds.size());
		for(WebElement e:listOOSProds) {
			System.out.println("Oout Of Stock Product: "+e.getText());
		}
		
		List<WebElement> listBuyNow = store.buyNowProducts();
		List<WebElement> listAddToCart = store.addToCartProducts();		
		System.out.println("Total Number of Available Products: "+(listBuyNow.size()+listAddToCart.size()));
	}
}
