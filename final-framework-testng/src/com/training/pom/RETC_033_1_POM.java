//Objective: Post New Property from "Add New" link of Properties Tab and verify whether application allows admin to view added property details in All Properties window

package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RETC_033_1_POM {
	
	    private WebDriver driver; 
		
		public RETC_033_1_POM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
	
		// Admin Login
		@FindBy(id="user_login")
		private WebElement userName; 
		
		// Admin password
		@FindBy(id="user_pass")
		private WebElement password;
		
		// Login Button
	
		@FindBy(name="login")
		private WebElement loginBtn1; 
	
	
		// Click on Properties tab
		@FindBy(xpath= "/html/body/div[1]/div[1]/div[2]/ul/li[8]/a/div[3]")
		private WebElement Propertiestab; 
		
		// Click on Add New link
		
		@FindBy(xpath= "/html/body/div[1]/div[1]/div[2]/ul/li[8]/ul/li[3]/a")
		private WebElement AddNewlink; 
		
		// Enter valid credentials in Enter Title Here textbox
		
		@FindBy(id = "title")
		private WebElement TitleHere;
		
		// Enter valid credentials in textbox
		
		@FindBy(xpath = "//textarea[@id='content']")
		private WebElement Textbox;
		
		// Wait for Publish button
		
		@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/form/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/a")
		private WebElement WaitForPublish;
		
		// Click on Publish button
		
		@FindBy(xpath = "//input[@id='publish']")
		private WebElement publish;
		
		// Wait for Post Publish
		@FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/p/a")
		private WebElement WaitPostPublish;
		
		// Post publish message
		@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/p")
		private WebElement postPublishMessage;
		
		// Click on All Properties link
		
		@FindBy(id = "wp-first-item current")
		private WebElement AllPropertieslink;

		// Enter UserName
		public void sendUserName(String userName) {
			this.userName.clear();
			this.userName.sendKeys(userName);
		}
		
		// Enter Password
		public void sendPassword(String password) {
			this.password.clear(); 
			this.password.sendKeys(password); 
		}
		
		//Click Sign In button
		public void clickLoginBtn() {
			this.loginBtn1.click(); 
		}

		// Click on Properties tab

		public void Propertiestab() {
			this.Propertiestab.click();

		}
		// Click on Add New link

		public void AddNewlink1() {
			this.AddNewlink.click();
		}
		//Enter valid credentials in Enter Title Here textbooks

		public void TitleHere1 (String TitleHere) {
			//this.TitleHere.clear(); 
			this.TitleHere.sendKeys(TitleHere);

		}	
		// Enter valid credentials in textbox

		public void textbox (String textbox) {

			//driver.switchTo().frame(0);
			this.Textbox.clear(); 
			this.Textbox.sendKeys(textbox);
			//driver.switchTo().defaultContent();
		}

		// Click on Publish button
		
		public void WaitForPublish() {
			WebDriverWait wait= new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(WaitForPublish));
			
		}
		public void Publish() throws AWTException {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			this.publish.click();
		}

		public void WaitPostPublish () {
			
			WebDriverWait wait1= new WebDriverWait(driver, 30);
			wait1.until(ExpectedConditions.elementToBeClickable(WaitPostPublish)); 
		
		}
		// Check Post Publish message
		public String PostPublish() {
			return this.postPublishMessage.getText();
		}
		
		// Click on All Properties link
		public void AllPropertieslink() {
			this.AllPropertieslink.click();
		}
	
}


