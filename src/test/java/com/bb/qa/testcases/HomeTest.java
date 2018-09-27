package com.bb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bb.qa.base.TestBase;
import com.bb.qa.pages.HomePage;
import com.bb.qa.pages.LoginPage;
import com.bb.qa.pages.MainPage;
import com.bb.qa.pages.SearchPage;
import com.bb.qa.util.TestUtil;

public class HomeTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	MainPage mainPage;
	SearchPage searchPage;
	
	String sheetName = "items";
	
	public HomeTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		mainPage = new MainPage();
		loginPage = new LoginPage();
		loginPage = mainPage.goToLoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	/*@Test(priority=1)
	public void logoBbTest(){
		boolean flag = homePage.validatedBbLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void credentialsTest(){
		homePage.validateCredentials();
		
	}*/
	
	@DataProvider
	public Object[][] getNameItemsData(){		
		Object data[][] = TestUtil.getTestSearchItems(sheetName);		
		return data;
	}
	
	@Test(priority=1, dataProvider="getNameItemsData")
	public void searchItemTest(String searchItemName){
		searchPage = homePage.searchItem(searchItemName);
	}
	/*
	@Test(priority=4)
	public void logOutTest(){
		loginPage = homePage.logOut();
	}*/
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
