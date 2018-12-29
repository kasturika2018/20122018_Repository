package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_033_1_POM {
	
	    private WebDriver driver; 
		
		public RETC_033_1_POM(WebDriver driver) {
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
		
		@FindBy(id = "title")
		private WebElement TitleHere;
		
	//4. Enter valid credentials in textbox
		
		
		@FindBy(xpath = "//textarea[@id='content']")
		private WebElement Textbox;
		
	//5. Click on Publish button
		
		@FindBy(xpath = "//input[@id='publish']")
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
		
	//driver.switchTo().frame(0);
	this.Textbox.clear(); 
	this.Textbox.sendKeys(textbox);
	//driver.switchTo().defaultContent();
	}
		
	//5. Click on Publish button
	
	public void Publish() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		this.publish.click();
		}
	
	//6. Click on All Properties link

	public void AllPropertieslink() {
		this.AllPropertieslink.click();
		}
	
}


