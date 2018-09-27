package com.bb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bb.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//button[@id='logout-button']")
	WebElement logOut;
	
	@FindBy(xpath="//img[@alt = 'Best Buy Logo']")
	WebElement bbLogo;
	
	@FindBy(xpath="//input[@id='gh-search-input']")
	WebElement searchButton;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchSubmit;	
	
	@FindBy(xpath="//a[contains(text(),'Hi, Cesar')]")
	WebElement checkCredentials;
	
	@FindBy(xpath ="//a[@id='hf_accountMenuLink']")
	WebElement accountLink;
		
	@FindBy(xpath ="//button[@id='logout-button']")
	WebElement logOutButton;
	
	//Actions
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean validatedBbLogo(){
		return bbLogo.isDisplayed();
	}
	
	public boolean validateCredentials(){
		return checkCredentials.isDisplayed();
	}
	
	public SearchPage searchItem(String nameItem){		
		searchButton.sendKeys(nameItem);
		searchSubmit.click();		
		return new SearchPage();
	}
	
	public LoginPage logOut(){
		accountLink.click();
		logOutButton.click();
		
		return new LoginPage();
	}
}
