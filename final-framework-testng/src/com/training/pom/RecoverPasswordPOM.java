package com.training.pom;

import org.openqa.selenium.WebDriver;

public class RecoverPasswordPOM {
	package com.training.pom;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public RecoverPasswordPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(className="sign-in")
		private WebElement Logintestlink; 
		
		//@FindBy(id="user_login")
		//private WebElement userName; 
		
		//@FindBy(id="user_pass")
		//private WebElement password;
		
		@FindBy(className="Lost_password")
		private WebElement LostYourPassword1; 
		
		@FindBy(name="user_login")
		private WebElement EmailAddress;

		@FindBy(className="lostpassword-button")
		private WebElement ResetPassword; 
		
			public void sendEmailAddress(String EmailAddress) {
			this.EmailAddress.clear();
			this.EmailAddress.sendKeys(EmailAddress);
		}
		
		//public void sendPassword(String password) {
			//((WebElement) this.password).clear(); 
			//((WebElement) this.password).sendKeys(password); 
		//}
		
			public void clickLogintestlink() {
				this.Logintestlink.click(); 
			}
			
			public void clickLostYourPassword() {
			this.LostYourPassword1.click(); 
		}

		
		
		
		
		public static void ResetPassword() {
			this.ResetPassword.click(); 
			}
	  }

