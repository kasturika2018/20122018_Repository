package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_039POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_039Test {

		private WebDriver driver;
		private String baseUrl;
		private RETC_039POM RETC039;
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
			RETC039 = new RETC_039POM(driver); 
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
			
			String ExpectedResult="My Profile – Real Estate";
			Thread.sleep(5000);	 	
			RETC039.sendUserName("admin");
			RETC039.sendPassword("admin@123");
			RETC039.clickLoginBtn();
			Thread.sleep(5000);
			//Verify the Page
			/*
			String ActualResult = driver.getTitle();
			System.out.println(ActualResult);
			Assert.assertEquals(ActualResult, ExpectedResult);
			screenShot.captureScreenShot("First");
			//1. Click on Properties tab
			*/
			System.out.println("Test11");
			RETC039.Postsclick();
			Thread.sleep(5000);
			RETC039.Categoriesclick();
			System.out.println("Test");
			RETC039.EnterName("KASDG");
			RETC039.EnterSlug("AAAA");
			RETC039.EnterDesc("TEST KAS");
			System.out.println("Tes1");
			//Thread.sleep(5000);
			//RETC033.TitleHere1("New Property Avidipta");
			//Thread.sleep(5000);
			//RETC033.textbox("3BHK on 10th Floor");
			//Thread.sleep(5000);
			//RETC033.Publish(); 
			//Thread.sleep(5000);
			//RETC033.Propertiestab();
			//Thread.sleep(5000);
			
		}
}