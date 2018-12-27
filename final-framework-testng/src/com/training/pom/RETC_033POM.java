package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_033POM {
	
	    private WebDriver driver; 
		
		public RETC_033POM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
	
		@FindBy(id="user_login")
		private WebElement userName; 
		
		@FindBy(id="user_pass")
		private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn1; 
	
	
	//1. Click on Properties tab
		@FindBy(xpath= "/html/body/div[1]/div[1]/div[2]/ul/li[8]/a/div[3]")
		private WebElement Propertiestab; 
		
	//2. Click on Add New link
		
		@FindBy(xpath= "/html/body/div[1]/div[1]/div[2]/ul/li[8]/ul/li[3]/a")
		private WebElement AddNewlink; 
		
	//3. Enter valid credentials in Enter Title Here textbox
		
		@FindBy(xpath = "//*[@id=\"title-prompt-text\"]")
		private WebElement TitleHere;
		
	//4. Enter valid credentials in textbox
		
		@FindBy(id = "content_ifr")
		private WebElement textbox1;
		
	//5. Click on Publish button
		
		@FindBy(id = "publish")
		private WebElement publish;
		
	//6. Click on All Properties link
		
		@FindBy(id = "wp-first-item current")
		private WebElement AllPropertieslink;

	
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
	
	//1. Click on Properties tab
	
	public void Propertiestab() {
	this.Propertiestab.click();
	
	}
	//2. Click on Add New link
	
	public void AddNewlink1() {
	this.AddNewlink.click();
	}
	//3. Enter valid credentials in Enter Title Here textbooks
		
	public void TitleHere1 (String TitleHere) {
	//this.TitleHere.clear(); 
	this.TitleHere.sendKeys(TitleHere);
	
	}	
	//4. Enter valid credentials in textbox

	public void textbox (String textbox) {
	this.textbox1.clear(); 
	this.textbox1.sendKeys(textbox);
	}
		
	//5. Click on Publish button
	
	public void Publish() {
		this.publish.click();
		}
	
	//6. Click on All Properties link

	
	
}


