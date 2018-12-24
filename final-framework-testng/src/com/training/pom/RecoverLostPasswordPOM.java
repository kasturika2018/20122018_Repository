package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoverLostPasswordPOM {
private WebDriver driver; 
	
	//public RecoverLostPasswordPOM(WebDriver driver) {
	//	this.driver = driver; 
//		PageFactory.initElements(driver, this);
	//}
	
	public RecoverLostPasswordPOM(WebDriver driver2) {
		this.driver = driver2; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(className="sign-in")
	private WebElement Logintestlink; 
	
		
	@FindBy(linkText="Lost Your Password?")
	private WebElement LostYourPassword; 
	
	@FindBy(name="user_login")
	private WebElement EmailAddress;

	@FindBy(className="lostpassword-button")
	private WebElement ResetPassword;
	
		
	public void clickLogin() {
		this.Logintestlink.click(); 
	}
	public void clickLostPassword() {
		this.LostYourPassword.click(); 
	}
	public void EmailAddress(String Email) {
		this.EmailAddress.clear();
		this.EmailAddress.sendKeys(Email);
	}
	public void ResetPassword() {
		this.ResetPassword.click(); 
	}

}
