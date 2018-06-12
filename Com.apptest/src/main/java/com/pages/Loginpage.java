package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclas;

public class Loginpage extends Baseclas {
	
	//pagefactory pattern for finding elements
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signup;
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement crmlogo;
	
	//initializing page objects
	//why below method having no return type
	public  Loginpage()
	{
		PageFactory.initElements(driver,this);
	}
	public String validateloginpagetitle()
	{
		return driver.getTitle();
	}
	public boolean logovalidation()
	{
		return crmlogo.isDisplayed();
	}
	
	
	public Homepage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		return  new Homepage();
	}
	

}
