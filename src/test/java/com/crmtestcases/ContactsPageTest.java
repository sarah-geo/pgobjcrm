package com.crmtestcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crmbase.BaseClass;
import com.crmpages.ContactsPage;
import com.crmpages.HomePage;
import com.crmpages.LoginPage;
import com.crmutil.excelTestData;

public class ContactsPageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialisation();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	//	contactsPage = homePage.clickOnContacts();
		
		
	}
	
//	@Test(priority =0 )
//	public void verifyContactsLabel() {
		
//		Assert.assertTrue(contactsPage.verifyContactsPageLabel(),"missing contacts label");
		
//	}
	
	@Test(priority =1 )
	public void selectContact() {
		contactsPage.selectContactsByName("test test");
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = excelTestData.getTestData("sheet1");
		return data;
		
	}
	
	
	@Test(priority =0,dataProvider = "getTestData")

	public void addNewContact(String title,String fname,String sname,String comp) {
		
		
		contactsPage = homePage.clickOnNewContact();
		contactsPage.createNewContact(title,fname,sname,comp);
	}
	
	
	
//	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
