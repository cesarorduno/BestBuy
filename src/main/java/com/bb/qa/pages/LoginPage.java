package com.bb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.bb.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR
				
		@FindBy(xpath="//input[@type='email']")
		WebElement email;
		
		@FindBy(xpath = "//input[@type='password']")
		WebElement password;
		
		@FindBy(xpath="//button[@type='submit']")
		WebElement loginBtn;
		
		//@FindBy(xpath="//a[contains(text(),'Apple - MacBook Pro® - 13" + " Display - Intel Core i5 - 8 GB Memory - 128GB Flash Storage - Space Gray')]")
		//WebElement linkItem;
		
		//Initializing the Page Objects
		public LoginPage(){	
			PageFactory.initElements(driver, this);
		}
		
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
	
		public HomePage login(String email, String pwd){
			
		
			this.email.sendKeys(email);
			this.password.sendKeys(pwd);
			loginBtn.click();
	
			return new HomePage();
			
		}

}
