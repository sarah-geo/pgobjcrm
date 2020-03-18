package com.crmtestcases;

import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmbase.BaseClass;
import com.crmpages.ContactsPage;
import com.crmpages.HomePage;
import com.crmpages.LoginPage;

public class HomePageTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	//testcases should be independent.avoid dependencies.
	//before each testcase launch browser and login.
	//@test-execute tc
	//after each tc close browser
	
	
	@BeforeMethod
	public void SetUp() {
	initialisation();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority =1)
	public void verifyUserName() {
		Assert.assertTrue(homePage.verifyUserNameLabel());
	}
	
	@Test(priority =0)
	public void verifyHomePageTitleTest() {
		
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","home page title not matched"); //third parameter gets printed in report if assertion fails
	}
	
	@Test(priority =2)
	public void verifyContactsLink() {
		contactsPage = homePage.clickOnContacts();
	}
	
	@Test(priority =3)
	public void newContactLink() {
	homePage.clickOnNewContact();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
