package com.qa.hubspot.Testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Pages.ContactPage;
import com.qa.hubspot.Pages.HomePage;
import com.qa.hubspot.Pages.LoginPage;
import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ExcelUtil;

public class ContactPageTest {
	
	public WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	Properties prop;
	HomePage homePage;
	ContactPage contactpage;
	
	@BeforeMethod
	public void setUp() {
		basePage=new BasePage();
		prop = basePage.init_properties();
		driver = basePage.intialise_driver(prop);
		loginPage = new LoginPage(driver);
	    homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	    contactpage= homePage.goToContactsPage();
				 
	}
	
	@Test
	public void verifyContactsPageTitle() {
		String title=contactpage.getContactPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}
	
	@DataProvider
	public Object[][] getContactData() {
		Object[][] data=ExcelUtil.getTestData("createcontact");
		return data;
		
	}
	@Test(dataProvider = "getContactData")
	public void createNewContactTest(String email,String firstname,String lastname,String jobTitle) {
		contactpage.fillCreateContactPageForm(email, firstname, firstname, jobTitle);

	//	contactpage.fillCreateContactPageForm("shah@gmail.com", "shah", "khan","lead");
		

	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}


}
