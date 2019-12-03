package com.qa.hubspot.Testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Pages.HomePage;
import com.qa.hubspot.Pages.LoginPage;
import com.qa.hubspot.Util.Constants;

public class HomePageTest {
	
	public WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	Properties prop;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		basePage=new BasePage();
		prop = basePage.init_properties();
		driver = basePage.intialise_driver(prop);
		loginPage = new LoginPage(driver);
	    homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
				 
	}
	@Test(priority=1, description="home page title test...")
	public void homePageTitleTest() {
		String title= homePage.getHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2, description="home page header test")
	public void getHomePageHeaderTest() {
		String header = homePage.getHomePageHeader();
		System.out.println(header);
		Assert.assertEquals(header,Constants.HOME_PAGE_HEADER,"Home page header is incorrect...");
	}
	
	@Test(priority=3)
	public void loggedInAccountNameTest()
	{
		String name = homePage.loggedInAccountName();
		System.out.println(name);
		Assert.assertTrue(homePage.verifyLoggedInAccountName());
		Assert.assertEquals(name, prop.getProperty("accountname"));
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}
