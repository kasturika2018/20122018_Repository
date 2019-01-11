//Objective: Post New Property from "Add New" link of Properties Tab and verify whether application allows admin to view added property details in All Properties window

package com.training.sanity.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.PostNewPropertyPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_033_1_Test {

	private WebDriver driver;
	private String baseUrl;
	private PostNewPropertyPOM RETC033;
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
		RETC033 = new PostNewPropertyPOM(driver); 
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
			
		// Enter login ( adin ) , password and Sign-In
		RETC033.sendUserName("admin");
		RETC033.sendPassword("admin@123");
		RETC033.clickLoginBtn();
		
		
		// Click on Properties Tab
		RETC033.Propertiestab();
				
		// Click on Add New Link of Propeties Tab
		RETC033.AddNewlink1();
				
		 // Enter Property Title
		RETC033.TitleHere1("New Property Avidipta");
		
		// Enter Property Desc
		RETC033.textbox("3BHK on 10th Floor");
		
		
		// Publish the property
		
		
		RETC033.WaitForPublish();	
		
		RETC033.Publish(); 
		
		RETC033.WaitPostPublish();
	
		
		// Validate Post Publish message
		String ActualResult = RETC033.PostPublish();
		System.out.println(ActualResult);
		Assert.assertEquals(ActualResult, ExpectedResult);
			
		// View the submitted property in All Properties Tab
		RETC033.Propertiestab();
		
		
				
	}
}
