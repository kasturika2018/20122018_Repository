package com.training.sanity.tests;

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

public class RETC_033_1_Test {

	private WebDriver driver;
	private String baseUrl;
	private RETC_033_1_POM RETC033;
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
		RETC033 = new RETC_033_1_POM(driver); 
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
	public void validLoginTest() {
		
		String ExpectedResult="My Profile – Real Estate";
				 	
		RETC033.sendUserName("admin");
		RETC033.sendPassword("admin@123");
		RETC033.clickLoginBtn(); 
		//Verify the Page
		/*
		String ActualResult = driver.getTitle();
		System.out.println(ActualResult);
		Assert.assertEquals(ActualResult, ExpectedResult);
		screenShot.captureScreenShot("First");
		//1. Click on Properties tab
		*/
		RETC033.Propertiestab();
		RETC033.AddNewlink1();
		RETC033.TitleHere1("New Property Avidipta");
		RETC033.textbox("3BHK on 10th Floor");
		RETC033.Publish(); 
		
		
	}
}
