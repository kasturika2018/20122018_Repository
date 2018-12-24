package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutFromApplicationPOM {
private WebDriver driver; 
	
	public LogoutFromApplicationPOM(WebDriver driver) {
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
		
		@FindBy(xpath ="/html/body/div[1]/div[4]/div/article/div[1]/div/div/ul[2]/li[2]/a")
		private WebElement logoutBtn;

		//@FindBy(name="login")
		//private WebElement loginBtn; 
		
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
		public void clickLogin1() {
		this.Logintestlink.click(); 
		}
		
		public void clickLogout() {
		this.logoutBtn.click(); 
		
	  }
}