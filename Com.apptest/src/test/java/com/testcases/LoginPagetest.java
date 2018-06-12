package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Baseclas;
import com.pages.Loginpage;
import com.pages.Homepage;

public class LoginPagetest extends Baseclas {
	Loginpage Loginpage;
	Homepage Homepage;
	public LoginPagetest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		Loginpage=new Loginpage();
		
	}
	@Test
	public void titleverification()
	{
		String Title=Loginpage.validateloginpagetitle();
		Assert.assertEquals(Title,"Free CRM for Small Businesses - FreeCRM.com");
	}
	@Test
	public void imgtest()
	{
	Boolean a=	Loginpage.logovalidation();
	Assert.assertTrue(a);
		
	}
	
	public void loggin()
	{
		Homepage=Loginpage.login(prop.getProperty("username"),prop.getProperty("sangeeee"));
		
		
	}
	
	
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	
	

}
