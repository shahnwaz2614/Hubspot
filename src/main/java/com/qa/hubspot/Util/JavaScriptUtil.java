package com.qa.hubspot.Util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	public static String getTitleByJs(WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String title=js.executeScript("return document.title;").toString();
		return title;
		
	}
	
	public static void clickElementByJs(WebElement element,WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void refreshBrowserByJs(WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	
	public static void generateAlertByJs(WebDriver driver,String message){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("alert('" + message +  "')");
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void sendKeysUsingJSWithID(WebDriver driver, String id, String value){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + id + "').value='"+value+"'");
	}
	public static void sendKeysUsingJSWithClassName(WebDriver driver, String className, String value){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementByClassName('" + className + "').value='"+value+"'");
	}
	
	public static void sendKeysUsingJSWithName(WebDriver driver, String name, String value){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementByName('" + name + "').value='"+value+"'");
	}
	
	public static String getBrowserInfo(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String uAgent = js.executeScript("return navigator.userAgent;").toString();     
		return uAgent;
	}
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element, driver);// 1
			changeColor(bgcolor, element, driver);// 2
		}
	}
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}
	

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	


}
