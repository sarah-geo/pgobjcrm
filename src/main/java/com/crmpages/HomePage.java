package com.crmpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crmbase.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath = "//td[contains(text(),'sara george')]")
	WebElement uNamelabel;
	
	@FindBy(xpath ="//a[contains(text(),'Contacts')]")
	WebElement contacts;

	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement deals;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasks;
	
	@FindBy(xpath ="//a[contains(text(),'New Contact')]")
	WebElement newContact;

	
	//Initializing page objects
	
	public HomePage() {
		
		PageFactory.initElements(driver,this);
	}
	
	
	
	public boolean verifyUserNameLabel() {
		driver.switchTo().frame("mainpanel");
		return uNamelabel.isDisplayed();
	
	}
	
	
	public String verifyHomePageTitle() {
		
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContacts() {
		driver.switchTo().frame("mainpanel");
		contacts.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDeals() {
		contacts.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() {
		contacts.click();
		return new TasksPage();
	}
	
	
	public ContactsPage clickOnNewContact() {
		
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(newContact));
		newContact.click();
		return new ContactsPage();
		
		
	}
	
	

	
}
