package com.qa.hubspot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Util.ElementUtil;
import com.qa.hubspot.Util.ElementUtilWithPF;

public class LoginPageWithPF extends BasePage {
	
	public WebDriver driver;
	ElementUtilWithPF elementUtilpf;
	
	@FindBy(id="username")
	WebElement emailId;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement lgnBtn;
	
	public LoginPageWithPF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	    elementUtilpf=new ElementUtilWithPF(driver);
	}
	
	public void doLogin(String un,String pwd) {
		elementUtilpf.waitForElementPresent(emailId);
		emailId.sendKeys(un);
		password.sendKeys(pwd);
		lgnBtn.click();
	}
	

}
  