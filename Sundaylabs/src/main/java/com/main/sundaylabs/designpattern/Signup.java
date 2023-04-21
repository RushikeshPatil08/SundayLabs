package com.main.sundaylabs.designpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup {
	WebDriver driver;
	
	public Signup(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signupButton; 
	
	
	public void clickSignupButton() throws InterruptedException {
		signupButton.click();	
	}
	
	
}
