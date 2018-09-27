package com.bb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bb.qa.base.TestBase;

public class SearchPage extends TestBase{
	
	@FindBy(xpath="//span[@class='c-section-title-text'][contains(text(),'Category')]")
	WebElement categoryCart;
	
	
	
	public WebElement selectItemDescription(String name){
		return driver.findElement(By.xpath("//h4[@class='sku-header']//a[contains(text(),'" + name + "')]"));
	}
	
	//Initializing the Page Objects
	public SearchPage(){	
		PageFactory.initElements(driver, this);
	}
	
	public cartPage selectItem(String name){
		
		selectItemDescription(name).click();
		return new cartPage();
	}
	
	public boolean validateCategory(){
		return categoryCart.isDisplayed();
	}
	
}
