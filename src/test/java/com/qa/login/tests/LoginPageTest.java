package com.qa.login.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.login.base.BaseTest;
import com.qa.login.constants.FrameworkConstants;

public class LoginPageTest extends BaseTest {

	@Parameters({"username", "password"})
	@Test
	public void loggedInPageURLTest(String username, String password) {
		String actualURL = loginPage.loggedInPageURL(username, password);
		Assert.assertTrue(actualURL.contains(FrameworkConstants.LOGGEDIN_PAGE_URL));
	}
	
	@Parameters({"username", "password"})
	@Test
	public void loggedInPageTitleTest(String username, String password) {
		String actualTitle = loginPage.loggedInPageTitle(username, password);
		Assert.assertEquals(actualTitle, FrameworkConstants.LOGGEDIN_PAGE_TITLE);
	}
	
	@Parameters({"username", "password"})
	@Test
	public void loggedInPageSuccessMsgTest(String username, String password) {
		String actualSuccessMsg = loginPage.loggedInPageSuccessMsg(username, password);
		Assert.assertEquals(actualSuccessMsg, FrameworkConstants.LOGIN_SUCCESS_MESSAGE);
	}
	
	@Parameters({"username", "password"})
	@Test
	public void loggedInPageLogOutLinkTest(String username, String password) {
		Assert.assertTrue(loginPage.loggedInPageLogOutLink(username, password));
	}
	
	@Parameters({"username", "password"})
	@Test
	public void negativeUsernameLoginTest(String username, String password) {
		String actualErrorMsg = loginPage.negativeUsernameLogin(username, password);
		Assert.assertEquals(actualErrorMsg, FrameworkConstants.NEGATIVE_USERNAME_ERROR_MESSAGE);
	}
	
	@Parameters({"username", "password"})
	@Test
	public void negativePasswordLoginTest(String username, String password) {
		String actualErrorMsg = loginPage.negativeUsernameLogin(username, password);
		Assert.assertEquals(actualErrorMsg, FrameworkConstants.NEGATIVE_PASSWORD_ERROR_MESSAGE);
	}
}
