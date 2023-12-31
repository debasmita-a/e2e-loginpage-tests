package com.qa.login.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class DriverFactory {

	private WebDriver driver;
	private Properties prop;
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			System.out.println("Launching Chrome browser..");
			tlDriver.set(new ChromeDriver());
			//driver = new ChromeDriver();
			break;
		case "edge":
			System.out.println("Launching Edge browser..");
			tlDriver.set(new EdgeDriver());
			//driver = new EdgeDriver();
			break;
		case "firefox":
			System.out.println("Launching Firefox browser..");
			tlDriver.set(new FirefoxDriver());
			//driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Please provide correct browser name : " + browserName);
			break;
		}
		
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public Properties initProp() {
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	/**
	 * take screenshot
	 */
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
