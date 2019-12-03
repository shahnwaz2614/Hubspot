package com.qa.hubspot.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ElementUtil;

public class LoginPage extends BasePage {
	
	public WebDriver driver;
	ElementUtil elementUtil;
	
	
	

	// define locators / OR - with By locator (NPF):

	By emailId = By.id("username");
	By password = By.id("password");
	By lgnBtn = By.id("loginBtn");
	By header=By.cssSelector(".signup-link>i18n-string");
	
	// constructor of Page class:
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	// Page Actions
          
	public String getLoginPageTitle() {
	        
		return elementUtil.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
	         
	        
		}
		
		public HomePage doLogin(String username, String pwd) {
			elementUtil.doSendkeys(emailId, "shahnwaznew@gmail.com");
			elementUtil.doSendkeys(password, "Golu1234");
			elementUtil.doClick(lgnBtn);
			return new HomePage(driver);
			
			
			
		}

}
