package com.qa.login.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.login.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil util;
	//private By locators
	private By username = By.id("username");
	private By password = By.id("password");
	private By submitBtn = By.id("submit");
	private By successMsg = By.xpath("//h1");
	private By logoutLink = By.linkText("Log out");
	private By errorMsg = By.id("error");
	
	//public constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	//public page actions
	public void positiveLogin(String usernameValue, String passwordValue) {
		util.doSendKeys(username, usernameValue);
		util.doSendKeys(password, passwordValue);
		util.doClick(submitBtn);
	}
	
	public String loggedInPageURL(String usernameValue, String passwordValue) {
		positiveLogin(usernameValue, passwordValue);
		String pageURL = util.getPageURL();
		util.doClick(logoutLink);
		return pageURL;
	}
	
	public String loggedInPageTitle(String usernameValue, String passwordValue) {
		positiveLogin(usernameValue, passwordValue);
		String pageTitle = util.getPageTitle();
		util.doClick(logoutLink);
		return pageTitle;
	}
	
	public String loggedInPageSuccessMsg(String usernameValue, String passwordValue) {
		positiveLogin(usernameValue, passwordValue);
		String successMessage = util.doGetText(successMsg);
		util.doClick(logoutLink);
		return successMessage;
	}
	
	public boolean loggedInPageLogOutLink(String usernameValue, String passwordValue) {
		positiveLogin(usernameValue, passwordValue);
		boolean isLogoutLinkAvailable = util.isElementPresent(logoutLink);
		util.doClick(logoutLink);
		return isLogoutLinkAvailable;
	}
	
	public String negativeUsernameLogin(String usernameValue, String passwordValue) {
		util.doSendKeys(username, usernameValue);
		util.doSendKeys(password, passwordValue);
		util.doClick(submitBtn);
		String error = util.doGetText(errorMsg);
		return error;
	}
	
	public String negativePasswordLogin(String usernameValue, String passwordValue) {
		util.doSendKeys(username, usernameValue);
		util.doSendKeys(password, passwordValue);
		util.doClick(submitBtn);
		String error = util.doGetText(errorMsg);
		return error;
	}
	

}
