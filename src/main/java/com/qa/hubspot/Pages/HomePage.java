package com.qa.hubspot.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ElementUtil;

public class HomePage extends BasePage {
	
	public WebDriver driver;
	ElementUtil elementUtil;
	
	
	// Locators:

		By header = By.cssSelector("h1.private-page__title");
		By accountClick = By.xpath ("//img[@class=' nav-avatar ']");
		By accountName = By.cssSelector("#userPreferences>div>div.user-info-name");
		
		// Contact page locator
		By contactMain = By.id("nav-primary-contacts-branch");
		By contactChild = By.id("nav-secondary-contacts");
   
		
		public HomePage(WebDriver driver) {
         this.driver = driver;
         elementUtil = new ElementUtil(driver);
		}
		
		public String getHomePageTitle() {
			return elementUtil.waitForPageTitle(Constants.HOME_PAGE_TITLE);
		}

		public String getHomePageHeader() {
			return elementUtil.doGetText(header);
		}

		public boolean verifyLoggedInAccountName() {
			return elementUtil.elementDisplayed(accountName);
		}
		
		public String loggedInAccountName() {
			elementUtil.doClick(accountClick);
			return elementUtil.doGetText(accountName);
		}
		
		private void clickOnContact() {
			elementUtil.getElement(contactMain).click();
			elementUtil.getElement(contactChild).click();

		}
		
		public ContactPage goToContactsPage() {
			clickOnContact();
			return new ContactPage(driver);
		}


}
