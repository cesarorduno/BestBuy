package com.bb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bb.qa.base.TestBase;

public class MainPage extends TestBase{
	
	//Page Factory - OR
	@FindBy(xpath="//button[@type='button' and @class='close']")
	WebElement closePop;
	
	@FindBy(xpath ="//a[@id='hf_accountMenuLink']")
	WebElement accountLink;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	WebElement signInBtn;
	
	@FindBy(xpath="//button[@class='am-create-account__button btn btn-tertiary']")
	WebElement createAccountBtn;
	
	//Initializing the Page Objects
	public MainPage(){	
		PageFactory.initElements(driver, this);
	}
			
	public String validateMainPageTitle(){
		return driver.getTitle();
	}
	
	public CreateAccountPage goToCreateAccountPage(){
		closePop.click();
		accountLink.click();
		createAccountBtn.click();
		return new CreateAccountPage();
	}
	
	public LoginPage goToLoginPage(){	
		closePop.click();
		accountLink.click();
		signInBtn.click();
		return new LoginPage();
	}

}
