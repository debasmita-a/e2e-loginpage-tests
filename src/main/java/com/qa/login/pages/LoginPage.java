package com.qa.login.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice/");
		
		By testLoginPageLink = By.linkText("Test Login Page");
		driver.findElement(testLoginPageLink).click();
		
		By userNameLabel = By.xpath("(//div/label)[1]");
		By passwordLabel = By.xpath("(//div/label)[2]");
		
		System.out.println("Using getText() method :: " + driver.findElement(userNameLabel).getText());
		System.out.println("Using getAttribute(innerText) method :: " + driver.findElement(userNameLabel).getAttribute("innerText"));
		System.out.println("Using getAttribute(innerHTML) method :: " + driver.findElement(userNameLabel).getAttribute("innerHTML"));
		System.out.println("Using getAttribute(textContent) method :: " + driver.findElement(userNameLabel).getAttribute("textContent"));
		
		System.out.println("=================================================================");
		By userNameLabelText = By.xpath("(//div[@id='form']/div)[1]");
		
		System.out.println("Using getText() method :: " + driver.findElement(userNameLabelText).getText());
		System.out.println("Using getAttribute(innerText) method :: " + driver.findElement(userNameLabelText).getAttribute("innerText"));
		System.out.println("Using getAttribute(innerHTML) method :: " + driver.findElement(userNameLabelText).getAttribute("innerHTML"));
		System.out.println("Using getAttribute(textContent) method :: " + driver.findElement(userNameLabelText).getAttribute("textContent"));
		
	}
}
