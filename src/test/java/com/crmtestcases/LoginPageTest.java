package com.crmtestcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmbase.BaseClass;
import com.crmpages.HomePage;
import com.crmpages.LoginPage;


public class LoginPageTest extends BaseClass{
	
	LoginPage loginPage;
	
	public LoginPageTest() {
		super();
	}

	@BeforeClass
	public void SetUp() {
	initialisation();
	loginPage = new LoginPage();
	
	}
	
	@Test(priority =0)
	public void validate_title() {
		
		
		String title =loginPage.getTitle();
		//Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		System.out.println(title);
	}
	@Test
	public void login() {
		
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
