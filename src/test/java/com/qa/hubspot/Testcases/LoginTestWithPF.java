package com.qa.hubspot.Testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Pages.LoginPageWithPF;

public class LoginTestWithPF {
	
	public WebDriver driver;
	BasePage basePage;
	LoginPageWithPF loginPagepf;
	Properties prop;

	@BeforeMethod
	public void setUp() {
		basePage=new BasePage();
		prop = basePage.init_properties();
		driver = basePage.intialise_driver(prop);
		loginPagepf = new LoginPageWithPF(driver);			 

}
	@Test
	public void loginWithPFTest() {
		
		loginPagepf.doLogin("shahnwaznew@gmail.com", "Golu1234");
		
	}
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
}