//To verify whether application displays property details in all properties. upon clicking Restore link of selected property " New Property Avidipta" details in Trash
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
			driver.quit();
		}
		@Test
		public void RETC_051() throws AWTException, InterruptedException {
			
				 	
			RETC051.sendUserName("admin");
			RETC051.sendPassword("admin@123");
			RETC051.clickLoginBtn();
			
			
						
			//1. Click on Properties tab
			RETC051.Propertiestab();
			
			
			//2. Click on All Properties link
			RETC051.AllPropertieslink();
			
			
			// Click on Trash
			RETC051.clickTrash();
			
			
			// Mouse over property to Restore
			RETC051.MouseOverProperty();
			
			
			//3. Click on Restore link
			RETC051.clickRestore();
			
			
			//6. Click on All link
             
			RETC051.clickAllLink();
			

		}
	}


