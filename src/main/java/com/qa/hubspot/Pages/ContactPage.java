package com.qa.hubspot.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ElementUtil;

public class ContactPage {
	
	public WebDriver driver;
	ElementUtil elementUtil;
	
	By header = By.cssSelector("h1>i18n-string");
	By createContactBtn = By.xpath("//span[text()='Create contact']");
	By email = By.id("uid-ctrl-1");
	By firstName = By.id("uid-ctrl-2");
	By lastName = By.id("uid-ctrl-3");
	By jobTitle = By.id("uid-ctrl-5");
	By createContactBtn1 = By.xpath("//li[@class='uiListItem private-list__item p-bottom-1']//span[text()='Create contact']");

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	public String getContactPageTitle(){
		return elementUtil.waitForPageTitle(Constants.CONTACTS_PAGE_TITLE);
	}

	public String getContactPageHeader() {
		return elementUtil.doGetText(header);

	}
	
	public void fillCreateContactPageForm(String mail,String FN,String LN,String Jobtitle){
		elementUtil.doClick(createContactBtn);
		elementUtil.doSendkeys(email, mail);
		elementUtil.doSendkeys(firstName, FN);
		elementUtil.doSendkeys(lastName, LN);
		elementUtil.doSendkeys(jobTitle, Jobtitle);
		elementUtil.doClick(createContactBtn1);
		
	}

}
