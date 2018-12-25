package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenerateNewPasswordPOM {
private WebDriver driver; 
	
	public GenerateNewPasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="sign-in")
	private WebElement Logintestlink; 
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn1; 
	
	@FindBy(linkText="Change Password")
	private WebElement ChangePassword; 
	
	// Fill Current Password
	@FindBy(name="current_pass")
	private WebElement Currentpassword;
		
	//Fill New Password 
	
	@FindBy(name="pass1")
	private WebElement Newpassword;
		
	// Confirm New Password
	@FindBy(name="pass2")
	private WebElement Confirmpassword;
	
	// Save Changes
	@FindBy(id="wp-submit")
	private WebElement Savepassword;
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn1.click(); 
	}
	public void clickLogin() {
	this.Logintestlink.click(); 
	}
	public void ChangePasswordClick() {
		this.ChangePassword.click();
	}
	public void sendCurrentPassword(String password) {
		this.Currentpassword.clear(); 
		this.Currentpassword.sendKeys(password); 
	}
	public void sendNewPassword(String password) {
		this.Newpassword.clear(); 
		this.Newpassword.sendKeys(password); 
	}
	public void sendConfirmPassword(String password) {
		this.Confirmpassword.clear(); 
		this.Confirmpassword.sendKeys(password); 
	}
	public void clickSavePassword() {
		this.Savepassword.click(); 
	}
}