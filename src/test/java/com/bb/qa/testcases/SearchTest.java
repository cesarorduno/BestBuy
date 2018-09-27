package com.bb.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bb.qa.base.TestBase;
import com.bb.qa.pages.HomePage;
import com.bb.qa.pages.LoginPage;
import com.bb.qa.pages.MainPage;
import com.bb.qa.pages.SearchPage;
import com.bb.qa.pages.cartPage;
import com.bb.qa.util.TestUtil;

public class SearchTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	MainPage mainPage;
	SearchPage searchPage;
	cartPage CartPage;
	
	String sheetName = "items";
	
	public SearchTest(){
		super();
	}
	

	@BeforeMethod
	public void setUp(){
		initialization();
		mainPage = new MainPage();
		loginPage = new LoginPage();
		loginPage = mainPage.goToLoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		searchPage = homePage.searchItem("mcqueen cars");
	}
	
	
	@Test(priority=1)
	public void categoryTest(){
		Assert.assertTrue(searchPage.validateCategory());
	}
	
	
	@DataProvider
	public Object[][] getNameItemsDescription(){		
		Object data[][] = TestUtil.getTestDescriptionItems(sheetName);		
		return data;
	}
	
	@Test(priority=2, dataProvider="getNameItemsDescription")
	public void selectItemTest(String selectDescriptionName){
		CartPage = searchPage.selectItem(selectDescriptionName);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
