package com.bb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.bb.qa.base.TestBase;
import com.bb.qa.pages.LanguagePage;


public class LanguageTest extends TestBase{
	LanguagePage languagePage;
	
	public LanguageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		languagePage = new LanguagePage();
	}
	
	@Test
	public void verifyLanguagePageTitleTest(){
		String languagePageTittle = languagePage.validateLanguagePageTitle();
		Assert.assertEquals(languagePageTittle,"Best Buy International: Select your Country - Best Buy");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
