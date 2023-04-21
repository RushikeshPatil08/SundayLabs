package com.main.sundaylabs.designpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login{
	WebDriver driver;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@class='email-input']")
	WebElement email; 
	
	@FindBy(xpath = "//input[@class='password-input']")
	WebElement pass;
	
	@FindBy(xpath = "//button[@class='custom-button ']//div[contains(text(),'Login')]")
	WebElement loginButton;

	
	
	public void performLoginOperations(){
		email.sendKeys("test106@getnada.com");
		pass.sendKeys("Pass@123");
		loginButton.click();
	}
	
}
