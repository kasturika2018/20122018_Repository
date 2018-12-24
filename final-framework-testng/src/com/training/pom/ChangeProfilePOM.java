package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeProfilePOM {
private WebDriver driver; 
	
	public ChangeProfilePOM(WebDriver driver) {
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
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	@FindBy(id="wp-admin-bar-my-account")
	private WebElement EditProfile; 
	
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
	public void editProfile() {
		Actions builder = new Actions(driver);
		builder.moveToElement(EditProfile).build().perform();
		//this.EditProfile.click();
	}

}
