package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.NAME,using="username") 
	@CacheLookup
	WebElement userName;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.ID,using="tdb1")
	@CacheLookup
	WebElement loginButton;
	
	
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage loginAdmin(String uname,String pass)
	{
		userName.clear();
		password.clear();
		
		userName.sendKeys(uname);
		
		password.sendKeys(pass);
		
		loginButton.click();
		return new HomePage();
	}

}
