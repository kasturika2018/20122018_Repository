package com.training.sanity.tests;
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
import com.training.pom.RETC_051POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RETC_051 {
	
		private WebDriver driver;
		private String baseUrl;
		private RETC_051POM RETC051;
		private static Properties properties;
		private ScreenShot screenShot;

		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}

		@BeforeMethod
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			RETC051 = new RETC_051POM(driver); 
			baseUrl = properties.getProperty("baseURL");
			//System.out.print(baseUrl);
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}
		@Test
		public void RETC_051() throws AWTException, InterruptedException {
			
			String ExpectedResult="My Profile – Real Estate";
			Thread.sleep(5000);	 	
			RETC051.sendUserName("admin");
			RETC051.sendPassword("admin@123");
			RETC051.clickLoginBtn();
			Thread.sleep(5000);
			//Verify the Page
			/*
			String ActualResult = driver.getTitle();
			System.out.println(ActualResult);
			Assert.assertEquals(ActualResult, ExpectedResult);
			screenShot.captureScreenShot("First");
			//1. Click on Properties tab
			*/
			
			//1. Click on Properties tab
			RETC051.Propertiestab();
			Thread.sleep(5000);
			//2. Click on All Properties link
			
			RETC051.mouseoverpost111();
			Thread.sleep(5000);
			
			//3. Click on Trash link
			RETC051.mouseoverTrash();
			Thread.sleep(5000);
			
			//4. Mouse over on Property you want to restore
			
			RETC051.mouseoverpost11();
			Thread.sleep(5000);
			
			
			//5. Click on Restore Link
			
			RETC051.mouseoverpost1();
			Thread.sleep(5000);
			
			//6. Click on All link
             
			RETC051.mouseoverpost111();
			Thread.sleep(5000);
		;
			//RETC051.AddNewlink1();
			Thread.sleep(5000);
			//RETC051.TitleHere1("New Property Avidipta");
			Thread.sleep(5000);
			//RETC051.textbox("3BHK on 10th Floor");
			Thread.sleep(5000);
			//RETC051.Publish(); 
			Thread.sleep(5000);
			
			
			RETC051.Propertiestab();
			Thread.sleep(5000);
			
		}
	}


