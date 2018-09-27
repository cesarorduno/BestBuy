package com.bb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bb.qa.base.TestBase;
import com.bb.qa.pages.CreateAccountPage;
import com.bb.qa.pages.HomePage;
import com.bb.qa.pages.MainPage;

public class CreateAccountTest extends TestBase{
	
	CreateAccountPage createAccountPage;
	MainPage mainPage;
	HomePage homePage;
	
	 public CreateAccountTest(){
		 super();
	 }
	
	@BeforeMethod
	public void setUp(){
		initialization();
		mainPage = new MainPage();
		createAccountPage = mainPage.goToCreateAccountPage();
	}
	
	@Test(priority=1)
	public void verifyCreateAccountPageDisplayed(){		
		boolean flag = createAccountPage.validateCreateAccountPageDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void verifyErrorMsg(){		
		Assert.assertTrue(createAccountPage.validateMsgErrors(prop.getProperty("firstNameMsgError"),
															  prop.getProperty("lastNameMsgError"),
															  prop.getProperty("emailMsgError"),
															  prop.getProperty("passMsgError"),
															  prop.getProperty("confirmPassMsgError"),
															  prop.getProperty("phoneMsgError")));		
	}
	
	@Test(priority=3)
	public void verifyPassMatchMsg(){
		Assert.assertTrue(createAccountPage.validatePassMatchMsg(prop.getProperty("passMatchMsg"), prop.getProperty ("passMatch1"), prop.getProperty ("passMatch2")));
	}

	@Test(priority=4)
	public void verifyNotPassMatchMsg(){
		Assert.assertTrue(createAccountPage.validateNotMatchMsg(prop.getProperty("passNotMatchMsg"), prop.getProperty ("passNotMatch1"), prop.getProperty ("passNotMatch2")));
	}
	
	@Test(priority=5)
	public void verifyExistAccountMsgError(){		
		Assert.assertTrue(createAccountPage.validateExistAccountMsgError(prop.getProperty("firstName"),
															  			 prop.getProperty("lastName"),
															  			 prop.getProperty("email"),
															  			 prop.getProperty("pass"),
															  			 prop.getProperty("confirmPass"),
															  			 prop.getProperty("phone"),
															  			 prop.getProperty("existAccountMsgError")));		
	}
	
	@Test(priority=6)
	public void createAccount(){		
		homePage = createAccountPage.createAccountBB(prop.getProperty("firstName"), prop.getProperty("lastName"),
													 prop.getProperty("email"), prop.getProperty("pass"),
													 prop.getProperty("confirmPass"), prop.getProperty("phone"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
