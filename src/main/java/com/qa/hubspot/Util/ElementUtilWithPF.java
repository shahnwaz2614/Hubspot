package com.qa.hubspot.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.Base.BasePage;

public class ElementUtilWithPF extends BasePage {

	WebDriver driver;
	public ElementUtilWithPF(WebDriver driver) {
		this.driver=driver;
	}
	
	public void waitForElementPresent(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
