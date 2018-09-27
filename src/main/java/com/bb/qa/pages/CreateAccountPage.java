package com.bb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bb.qa.base.TestBase;

public class CreateAccountPage extends TestBase{
	
	@FindBy(xpath="//h1[@class='cia-heading cia-create-account__heading']")
	WebElement createAccountPageDisplayed;
	
	@FindBy(xpath="//span[@class='help-block'][contains(text(),'Please enter your first name')]")
	WebElement nameMsgError;
	
	@FindBy(xpath="//span[@class='help-block'][contains(text(),'Please enter your last name')]")
	WebElement lastNameMsgError;
	
	@FindBy(xpath="//span[@class='help-block'][contains(text(),'Please enter a valid email address')]")
	WebElement emailMsgError;
	
	@FindBy(xpath="//span[@class='help-block'][contains(text(),'Please enter a strong password')]")
	WebElement passMsgError;
	
	@FindBy(xpath="//span[@class='help-block'][contains(text(),'Please reenter your password.')]")
	WebElement confirmPassMsgError;
	
	@FindBy(xpath="//span[@class='help-block'][contains(text(),'Please enter a valid phone number.')]")
	WebElement phoneMsgError;
	
	@FindBy(xpath="//span[@class='cia-password-match__text'][contains(text(),'Your passwords match')]")
	WebElement passMatchMsg;
	
	@FindBy(xpath="//span[@class='help-block'][contains(text(),'Passwords do not match.')]")
	WebElement passNotMatchMsgError;
	
	@FindBy(xpath="//strong[contains(text(),'Sorry, there was a problem creating your account.')]")
	WebElement existAccountMsgError;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement createAccountBtn;
	
	@FindBy(xpath="//input[@id='fld-firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='fld-lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='fld-e']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='fld-p1']")
	WebElement pass;
	
	@FindBy(xpath="//input[@id='fld-p2']")
	WebElement confirmPass;
	
	@FindBy(xpath="//input[@id='fld-phone']")
	WebElement phone;
	
	//Initializing the Page Objects
	public CreateAccountPage(){	
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateCreateAccountPageDisplayed(){		
		return createAccountPageDisplayed.isDisplayed();		
	}
	
	public String getNameErrorMsg(){
		return nameMsgError.getText();
	}
	
	public String getLastNameErrorMsg(){
		return lastNameMsgError.getText();
	}
	
	public String getEmailErrorMsg(){
		return emailMsgError.getText();
	}
	
	public String getPassErrorMsg(){
		return passMsgError.getText();
	}
	
	public String getConfirmPassErrorMsg(){
		return confirmPassMsgError.getText();
	}
	
	public String getPhonePassErrorMsg(){
		return phoneMsgError.getText();
	}
	
	
	//Validating Password Match Msg
	public boolean validatePassMatchMsg(String passMatch, String pass1, String pass2){
		boolean flag = false;
		
		pass.sendKeys(pass1);
		confirmPass.sendKeys(pass2);
			
		if(passMatchMsg.getText().contains(passMatch)){
			flag = true;
		}
		
		return flag;
	}
	
	//Validating Not Password Match Msg
		public boolean validateNotMatchMsg(String notPassMatch, String pass1, String pass2){
			boolean flag = false;
			
			pass.sendKeys(pass1);
			confirmPass.sendKeys(pass2);
			phone.click();
			
			if(passNotMatchMsgError.getText().contains(notPassMatch)){
				flag = true;
			}
			
			return flag;
		}
	
	public boolean validateMsgErrors(String name, String lastName,String email, String pass, String confirmPass,String phone){
		boolean flag = false;
		createAccountBtn.click();
		
		if(getNameErrorMsg().contains(name) && getLastNameErrorMsg().contains(lastName)&& 
				getEmailErrorMsg().contains(email) && getPassErrorMsg().contains(pass) &&
				getConfirmPassErrorMsg().contains(confirmPass) && getPhonePassErrorMsg().contains(phone)){
			flag = true;
		}
		
		return flag;
		
	}
	
	public boolean validateExistAccountMsgError(String userName, String lastName,String email, String pass, String confirmPass,String phone,String existAccountError){
		boolean flag = false;
		
		this.firstName.sendKeys(userName);
		this.lastName.sendKeys(lastName);
		this.email.sendKeys(email);
		this.pass.sendKeys(pass);
		this.confirmPass.sendKeys(confirmPass);
		this.phone.sendKeys(phone);
		createAccountBtn.click();
		
		if(existAccountMsgError.getText().contains(existAccountError)){
			flag = true;
		}
		
		return flag;
	}
	
	public HomePage createAccountBB(String userName, String lastName,String email, String pass, String confirmPass,String phone){
		
		this.firstName.sendKeys(userName);
		this.lastName.sendKeys(lastName);
		this.email.sendKeys(email);
		this.pass.sendKeys(pass);
		this.confirmPass.sendKeys(confirmPass);
		this.phone.sendKeys(phone);
		createAccountBtn.click();
		
		return new HomePage();
		
	}
	
}
