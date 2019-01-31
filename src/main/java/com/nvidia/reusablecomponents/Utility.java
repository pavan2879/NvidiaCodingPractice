package com.nvidia.reusablecomponents;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility extends InitialClass{
	public void waitForPageLoad(WebDriver driver) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		try {
			wait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
							.equals("complete");
				}
			});
		} catch (TimeoutException te) {
			throw te;
		} catch (WebDriverException e) {
		}
	}
	
	public void elementDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void scrollToViewPort(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	public void scrollBy() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}
}
