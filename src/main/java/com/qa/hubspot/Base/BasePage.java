package com.qa.hubspot.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author shahnwaz
 *
 */
public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	public static String flash;
	
	/**
	 * This method is use to initialize the driver on the basis of browser
	 * @return this method return webdriver instance
	 */
	
	public WebDriver intialise_driver(Properties prop) {
	//	String browser = "chrome";
		String browser = prop.getProperty("browser");
		String headless=prop.getProperty("headless");
		flash=prop.getProperty("elementFlash");
		if(browser.equalsIgnoreCase("chrome")) {
		  WebDriverManager.chromedriver().setup();
		  if(headless.equals("yes")) {
			  ChromeOptions co=new ChromeOptions();
			  co.addArguments("--headless");
			  driver=new ChromeDriver(co);
		  }
		  else {
		  driver=new ChromeDriver();
		  }
		}
		else if(browser.equalsIgnoreCase("ff")) {
			  WebDriverManager.firefoxdriver().setup();
			  if(headless.equals("yes")) {
				  FirefoxOptions fo=new FirefoxOptions();
				  fo.addArguments("--headless");
				  driver=new FirefoxDriver(fo);
			  }
			  else {
			  driver=new FirefoxDriver();
			  }
			}	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}

	/**
	 * This method is use to define the properties
	 * 
	 * @return this method return properties prop reference
	 */
	public Properties init_properties() {
		
		prop = new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\shahnwaz\\eclipse-workspace\\HubspotHybridFrameWork\\"
					+ "src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {  
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Some exception has occured while quitting the browser");
		}	
	}
	
	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("Some exception has occured while closing the browser");
		}}

}
