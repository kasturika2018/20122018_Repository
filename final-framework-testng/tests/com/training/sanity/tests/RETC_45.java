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
import com.training.pom.RETC45POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RETC_45 {
	
	

		private WebDriver driver;
		private String baseUrl;
		private RETC45POM RETC045;
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
			RETC045 = new RETC45POM(driver); 
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
		public void validLoginTest() throws AWTException, InterruptedException {
			
			String ExpectedResult="Post published. View post";
			Thread.sleep(5000);	 	
			RETC045.sendUserName("admin");
			RETC045.sendPassword("admin@123");
			RETC045.clickLoginBtn();
			Thread.sleep(5000);
			//Verify the Page
					
			
			RETC045.Propertiestab();
			Thread.sleep(5000);
			RETC045.clickRegionLink();
			Thread.sleep(5000);
			RETC045.EnterNameTextBox("KolkataRegion");;
			Thread.sleep(5000);
			RETC045.EnterSlugTextBox("kolkata");
			Thread.sleep(5000);
			RETC045.selectParentRegion("Resale");
			Thread.sleep(5000);
			RETC045.EnterDescTextBox("Resale in Kolkata");
			Thread.sleep(5000);
			RETC045.clickSubmitRegion();
			Thread.sleep(5000);
			RETC045.clickAddNew();
			Thread.sleep(5000);
			RETC045.EnterTitleTextBox("KolkataAvidipta");
			Thread.sleep(5000);
			RETC045.EnterCredentialsTextBox("KolkataAVD");
			Thread.sleep(5000);
			RETC045.RegionClick();
			Thread.sleep(5000);
			RETC045.Publish();
			Thread.sleep(5000);
			String ActualResult = RETC045.PostPublish();
			Assert.assertEquals(ActualResult, ExpectedResult);
						
		}
	}



