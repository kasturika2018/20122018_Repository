//Objective: To verify whether application allows admin to create property based on the Region created
package com.training.sanity.tests;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
			
			driver.quit();
		}
		@Test
		public void validLoginTest() throws AWTException, InterruptedException {
			
			String ExpectedResult="Post published. View post";
				 	
			RETC045.sendUserName("admin");
			RETC045.sendPassword("admin@123");
			RETC045.clickLoginBtn();
			
			//Verify the Page
					
			
			RETC045.Propertiestab();
			
			RETC045.clickRegionLink();
			
			RETC045.EnterNameTextBox("KolkataRegion");;
			
			RETC045.EnterSlugTextBox("kolkata");
			
			RETC045.selectParentRegion("Resale");
			
			RETC045.EnterDescTextBox("Resale in Kolkata");
			
			RETC045.clickSubmitRegion();
			;
			RETC045.clickAddNew();
			
			RETC045.EnterTitleTextBox("KolkataAvidipta");
			;
			RETC045.EnterCredentialsTextBox("KolkataAVD");
			
			RETC045.RegionClick();
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			RETC045.WaitForPublish();
			RETC045.Publish();
			RETC045.WaitPostPublish();
			
			String ActualResult = RETC045.PostPublish();
			Assert.assertEquals(ActualResult, ExpectedResult);
						
		}
	}



