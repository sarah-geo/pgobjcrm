package com.crmpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crmbase.BaseClass;

public class ContactsPage extends BaseClass {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//a[contains(text(),'test test')]//parent::td[@class='datalistrow']//preceding-sibling::td//input[@name='contact_id']")
	WebElement checkbox;
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsPageLabel() {
		
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]"
				+ "//parent::td[@class='datalistrow']//preceding-sibling::td//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String firstname,String lastname,String cmpname) {
		
		Select sel = new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(title);
		driver.findElement(By.id("first_name")).sendKeys(firstname);
		driver.findElement(By.id("surname")).sendKeys(lastname);
		driver.findElement(By.name("client_lookup")).sendKeys(cmpname);
		driver.findElement(By.xpath("//input[@type ='submit' and @value='Save']")).click();
	}
	
	
	
	

}
