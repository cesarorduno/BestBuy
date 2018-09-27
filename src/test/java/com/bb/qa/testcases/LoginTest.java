package com.bb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bb.qa.base.TestBase;
import com.bb.qa.pages.HomePage;
import com.bb.qa.pages.LoginPage;
import com.bb.qa.pages.MainPage;

public class LoginTest extends TestBase {
	LoginPage loginPage;
	MainPage mainPage;
	HomePage homePage;
	
	 public LoginTest(){
		 super();
	 }
	
	@BeforeMethod
	public void setUp(){
		initialization();
		mainPage = new MainPage();
		loginPage = mainPage.goToLoginPage();
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitle(){		
		String loginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Sign In to BestBuy.com");
	}
	
	
	@Test(priority=2)
	public void loginHomePage(){		
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
