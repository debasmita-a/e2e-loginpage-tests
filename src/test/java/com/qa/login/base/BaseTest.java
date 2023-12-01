package com.qa.login.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.qa.login.factory.DriverFactory;
import com.qa.login.pages.LoginPage;

public class BaseTest {

	protected DriverFactory df;
	protected Properties prop;
	protected WebDriver driver;
	protected LoginPage loginPage;
	
	@BeforeClass
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);	
		loginPage = new LoginPage(driver);
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
