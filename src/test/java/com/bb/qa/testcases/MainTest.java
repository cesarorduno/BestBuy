package com.bb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bb.qa.base.TestBase;
import com.bb.qa.pages.CreateAccountPage;
import com.bb.qa.pages.LoginPage;
import com.bb.qa.pages.MainPage;


public class MainTest extends TestBase{
	
	MainPage mainPage;
	LoginPage loginPage;
	CreateAccountPage createAccountPage;
	
	public MainTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		mainPage = new MainPage();
	}
	
	
	@Test(priority=1)
	public void verifyMainPageTitle(){
		String mainPageTitle = mainPage.validateMainPageTitle();
		Assert.assertEquals(mainPageTitle, "Best Buy | Official Online Store | Shop Now & Save");
	}
	@Test(priority=2)
	public void goLoginPage(){
		loginPage = mainPage.goToLoginPage();
	}
	
	@Test(priority=3)
	public void goToCreateAccountPage(){
		createAccountPage = mainPage.goToCreateAccountPage();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
