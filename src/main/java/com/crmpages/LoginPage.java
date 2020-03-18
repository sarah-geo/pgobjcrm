package com.crmpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmbase.BaseClass;

public class LoginPage extends BaseClass{
	
	
	@FindBy(name="username")
	WebElement un;
	
	@FindBy(name="password")
	WebElement pswd;
	
	@FindBy(xpath = "//input[@value ='Login']")
	WebElement loginbtn;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public HomePage login(String uname, String psw) {
		un.sendKeys(uname);
		pswd.sendKeys(psw);
		loginbtn.click();
		return new HomePage();
	}
	

}
