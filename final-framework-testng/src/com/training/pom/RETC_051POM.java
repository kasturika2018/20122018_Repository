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
import com.training.pom.RETC_033_1_POM;
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
			
		//2. Click on Add New link
			
			//@FindBy(xpath= "/html/body/div[1]/div[1]/div[2]/ul/li[8]/ul/li[3]/a")
			//private WebElement AddNewlink; 
			
		//3. Enter valid credentials in Enter Title Here textbox
			
			//@FindBy(id = "title")
			//private WebElement TitleHere;
			
		//4. Enter valid credentials in textbox
			
			
			//@FindBy(xpath = "//textarea[@id='content']")
			//private WebElement Textbox;
			
		//5. Click on Publish button
			
			//@FindBy(xpath = "//input[@id='publish']")
			//private WebElement publish;
			
		//6. Click on All Properties link
			
			@FindBy(id = "wp-first-item current")
			private WebElement AllPropertieslink;

			
			//3. Click on Trash link
			
			@FindBy(className = "row-actions")
			private WebElement Trash;
			public void mouseoverTrash()
			{
			Actions action=new Actions(driver);
			action.moveToElement(this.Trash).build().perform();
			}
			
			public void clickaddnew() {
			this.Trash.click();
			}
			//4. Mouse over on Property you want to restore
			@FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/ul/li[4]/a\r\n" + "			")
			private WebElement Trash1;
			public void mouseoverpost11()
			{
			Actions action=new Actions(driver);
			action.moveToElement(this.Trash1).build().perform();
			}
			
			//5. Click on Restore Link
			@FindBy(css = "#post-3074 > td:nth-child(2) > div:nth-child(3) > span:nth-child(1) > a:nth-child(1)")
			
			private WebElement Restore;
			public void mouseoverpost1()
			{
			Actions action=new Actions(driver);
			action.moveToElement(this.Restore).build().perform();
			}
			
			//6. Click on All link
            
			@FindBy(css = "/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/ul/li[1]/a/span")
			private WebElement Alllink;


			public void Alllink1()
			{
			Actions action=new Actions(driver);
			action.moveToElement(this.Alllink).build().perform();
			}
			
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
		
		//public void AddNewlink1() {
		//this.AddNewlink.click();
		//}
		//3. Enter valid credentials in Enter Title Here textbooks
			
		//public void TitleHere1 (String TitleHere) {
		//this.TitleHere.clear(); 
		//this.TitleHere.sendKeys(TitleHere);
		
		//}	
		//4. Enter valid credentials in textbox

		//public void textbox (String textbox) {
			
		//driver.switchTo().frame(0);
		//this.Textbox.clear(); 
		//this.Textbox.sendKeys(textbox);
		//driver.switchTo().defaultContent();
		//   }
			
		// 5. Click on Publish button
		
		//public void Publish() throws AWTException {
		//	Robot robot = new Robot();
		//	robot.keyPress(KeyEvent.VK_PAGE_UP);
		//	((WebElement) this.publish).click();
		//	}
		
		//6. Click on All Properties link

		//public void AllPropertieslink() {
		//	this.AllPropertieslink.click();
		//	}
		
	    
	    
	    private WebDriver driver;
		private String baseUrl;
		private RETC_033_1_POM RETC033;
		private static Properties properties;
		private ScreenShot screenShot;

		public Object mouseoverpost1;

		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}

		@BeforeMethod
		public void setUp() throws Exception {
			driver1 = DriverFactory.getDriver(DriverNames.CHROME);
			RETC033 = new RETC_033_1_POM(driver1); 
			baseUrl = properties.getProperty("baseURL");
			//System.out.print(baseUrl);
			screenShot = new ScreenShot(driver1); 
			// open the browser 
			driver1.get(baseUrl);
		}
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver1.quit();
		}
		@Test
		public void validLoginTest() throws AWTException, InterruptedException {
			
			String ExpectedResult="My Profile – Real Estate";
			Thread.sleep(5000);	 	
			RETC033.sendUserName("admin");
			RETC033.sendPassword("admin@123");
			RETC033.clickLoginBtn();
			Thread.sleep(5000);
		}
			//Verify the Page
			/*
			String ActualResult = driver.getTitle();
			System.out.println(ActualResult);
			Assert.assertEquals(ActualResult, ExpectedResult);
			screenShot.captureScreenShot("First");
			//1. Click on Properties tab
			
			RETC033.Propertiestab();
			Thread.sleep(5000);
			RETC033.AddNewlink1();
			Thread.sleep(5000);
			RETC033.TitleHere1("New Property Avidipta");
			Thread.sleep(5000);
			RETC033.textbox("3BHK on 10th Floor");
			Thread.sleep(5000);
			RETC033.Publish(); 
			Thread.sleep(5000);
			RETC033.Propertiestab();
			Thread.sleep(5000);
			
		}
            */
		public void Trash() {
			// TODO Auto-generated method stub
			
		}

		public void Alllink() {
			// TODO Auto-generated method stub
			
		}

	

		
	}



