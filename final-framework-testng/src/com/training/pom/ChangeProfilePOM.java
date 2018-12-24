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
	
	// These are for initial login 
	@FindBy(className="sign-in")
	private WebElement Logintestlink; 
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn1; 
	
	
	//Find My Profile link

	@FindBy(className="user-menu-active")
	private WebElement UserProfile;
	
	@FindBy(xpath="/html/body/div[1]/header/div[2]/div[2]/div/div/div/ul/li[1]/a")
	private WebElement EditProfile; 
	
	// Find Last Name Title textbox
	
	@FindBy(id= "last-name")
	private WebElement LastName11;
	
	// Find Phone textbox
	
	@FindBy(name= "phone")
	private WebElement Phone;
	
	
	// Find Phone textbox
	// @FindBy(xpath="/html/body/div[1]/div[4]/div/article/div[2]/div/div[1]/form/button")
	@FindBy(name= "my-account-submission")
		private WebElement UpdateProfile;
	
	
	// These methods are for initial login
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
	
	//Click on Edit Profile link
	public void UserProfileclick() {
		this.UserProfile.click();
	}
	
	public void EditProfile() {
		this.EditProfile.click(); 
	}
	
	// Enter valid credentials in Last Name Title textbox
	
	
	public void sendLastName(String LastName) {
	this.LastName11.sendKeys(LastName);
		
	}
	
	// Enter valid credentials in Phone textbox
	
	public void sendPhone(String Phone) {
		this.Phone.sendKeys(Phone);
	}
	//Click on Update Profile button
	
		public void UpdateProfile() {
			this.UpdateProfile.click(); 
		}
	

}
