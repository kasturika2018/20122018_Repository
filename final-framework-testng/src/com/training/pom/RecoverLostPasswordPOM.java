package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoverLostPasswordPOM {
private WebDriver driver; 
	
	//public RecoverLostPasswordPOM(WebDriver driver) {
	//this.driver = driver; 
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
	
	//password recover page should get displayed
	//Reset Password link: http://realestate.hommelle.com/reset-password/?login=kasdasgu%40in.ibm.com&key=AxmRunH8yGshKDO6bJix 
	/*
	@FindBy(className="Reset Password – Real Estate")
	private WebElement Resetpassword1;
	String Expected ="Reset Password";
	String Actual = driver.findElement(By.linkText("Reset Password")).getText();
	System.out.println("Kasturika's working code"+Actual);
	void assertEquals1(Actual, Expected)
	*/
	
	//Find New Password textbox
	  
	@FindBy(id="pass1")
	private WebElement Newpassword;
		
	//Find Repeat New Password textbox
	
	@FindBy(id="pass2")
	private WebElement RepeateNewpassword;
		
	
	//Click on Reset button
	
	@FindBy(id="resetpass-button")
	private WebElement ResetNewpassword;
		
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
	
	
	//Reset Password link: http://realestate.hommelle.com/reset-password/?login=kasdasgu%40in.ibm.com&key=AxmRunH8yGshKDO6bJix 
	//Enter valid credentials in New Password textbox
	    
	    public void Newpassword(String Newpassword) {
		this.Newpassword.clear();
		this.Newpassword.sendKeys(Newpassword);
	    }
	    
		//Enter valid credentials in Repeat New Password textbox
		
		public void RepeateNewpassword(String RepeateNewpassword) {
		this.RepeateNewpassword.clear();
		this.RepeateNewpassword.sendKeys(RepeateNewpassword);
		}
		//Click on Reset button
		
		public void ResetNewpassword() {
		this.ResetNewpassword.click(); 
		}
		//Password has been changed. Message should get displayed
		
		/*
		String Expected ="Password has been changed";
		String Actual = driver.findElement(By.linkText("Password has been changed")).getText();
		System.out.println("Kasturika's working code"+Actual);
		void assertEquals(Actual, Expected)
		*/
}