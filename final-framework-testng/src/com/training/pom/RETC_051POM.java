//To verify whether application displays property details in all properties. upon clicking Restore link of selected property " New Property Avidipta" details in Trash
package com.training.pom;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.PostNewPropertyPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_051POM {
	
	    private WebDriver driver1; 
			
		public RETC_051POM(WebDriver driver) {
			this.driver1 = driver; 
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
		
		//6. Click on All Properties link
		@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/ul/li[8]/ul/li[2]/a")
		private WebElement AllProperties;
		
			
		@FindBy(id = "wp-first-item current")
		private WebElement AllPropertieslink;

			
		//3. Click on Trash link
		
		@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/ul/li[4]/a")
		private WebElement TrashLink;
		
		@FindBy(className = "row-actions")
		private WebElement Trash;
	
		
		// Mouse over on Property to be restored
		
		@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/table/tbody/tr[1]/td[1]/strong")
		private WebElement PropertyToRestore;
		
		// Click on Restore
		@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/table/tbody/tr[1]/td[1]/div[2]/span[1]/a")
		private WebElement Restore;
		
		// Click on All Link
		@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/ul/li[1]/a")
		private WebElement AllLink;
		
		
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
		
		//public void textbox (String textbox) {
			
		//driver.switchTo().frame(0);
		//this.Textbox.clear(); 
		//this.Textbox.sendKeys(textbox);
		//driver.switchTo().defaultContent();
		//   }
			
		
		//6. Click on All Properties link

		public void AllPropertieslink() {
			this.AllProperties.click();
		}
		
		// Click on Trash Link
		public void clickTrash() {
			this.TrashLink.click();
		}
		
		// Movse over property to be restored
		public void MouseOverProperty()
		{
		Actions action=new Actions(driver1);
		action.moveToElement(this.PropertyToRestore).build().perform();
		}
		
		// Click on Restore
		public void clickRestore() {
			this.Restore.click();
		}
		
		// Click on All Link
		public void clickAllLink() {
			this.AllLink.click();
		}
	}
