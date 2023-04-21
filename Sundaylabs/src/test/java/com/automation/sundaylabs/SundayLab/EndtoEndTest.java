package com.automation.sundaylabs.SundayLab;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.main.sundaylabs.designpattern.*;
import com.main.sundaylabs.library.AppLibrary;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class EndtoEndTest {
	ViewProfile v;
	@BeforeTest
	public void initialize() {
		AppLibrary.initializeDriver();
	}
	@Test(priority = 1)
	public void Login() throws InterruptedException {
		Thread.sleep(1000);
		Login l = new Login(AppLibrary.driver);
		l.performLoginOperations();
	}
	
	@Test(priority = 2)
	public void ProfilePage() throws InterruptedException {
		Thread.sleep(10000);
		v = new ViewProfile(AppLibrary.driver);
		v.AccountInfo();
	}
	
	@Test(priority = 3)
	public void verifyUserType() throws InterruptedException {
		v.VerifyPanCardPopWindow(); 
	}
	
	@Test(priority = 4)
		public void verifyPan() throws InterruptedException {
			//Boolean panValue = AppLibrary.driver.findElement(By.xpath("//div[text()='PAN']//parent::div//following-sibling::div//input")).getAttribute("value");
			if( AppLibrary.driver.findElement(By.xpath("//div[text()='PAN']//parent::div//following-sibling::div//input")).getAttribute("value")=="") {
				
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertEquals(v.verifyPanCardWithInValidPan(),"Failed to verify PAN, Please try again.","Title is not Matching");
			
				Thread.sleep(1000);
				 v.closePanPopup();
//				softAssert.assertEquals(v.verifyPanCardWithValidPan(),"Failed to verify PAN, Please try again.","Title is not Matching");
         		softAssert.assertAll();
         	 
			}else {
				String panNumber = AppLibrary.driver.findElement(By.xpath("//div[text()='PAN']//parent::div//following-sibling::div//input")).getAttribute("value");
			}
			
			
		}
	
	@Test(priority = 5)
	public void verifyAdhar() throws InterruptedException{
		
		v.verifyInvalidAadhar();
		
		
	}
	
	
	@AfterTest
	public void close() {
		AppLibrary.driver.close();
	}
	
}	
