package com.bb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bb.qa.base.TestBase;

public class LanguagePage extends TestBase {
	LoginPage loginPage;
	
	//Page Factory - OR
	@FindBy(xpath="//a[@class ='us-link']//img[@alt='Estados Unidos']")
	WebElement usFlag;
	
	//Initializing the Page Objects
	public LanguagePage(){	
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLanguagePageTitle(){
		return driver.getTitle();
	}
	
	public LoginPage selectLanguage(){
		usFlag.click();		
		return loginPage = new LoginPage();		
	}

}
