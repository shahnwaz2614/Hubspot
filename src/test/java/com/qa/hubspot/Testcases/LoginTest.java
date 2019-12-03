package com.qa.hubspot.Testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Pages.LoginPage;
import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ElementUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginTest {
	public WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	Properties prop;

	@BeforeMethod
	public void setUp() {
		basePage=new BasePage();
		prop = basePage.init_properties();
		driver = basePage.intialise_driver(prop);
		loginPage = new LoginPage(driver);
				 
	}
	@Test(priority=2, description="login test with correct usernsame and password...")
	@Description("login test with correct usernsame and password...")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1, description="login page title test")
	@Description("login test title")
	@Severity(SeverityLevel.NORMAL) 
	public void getLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE,"Login page title is incorrect...");
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
	

}
