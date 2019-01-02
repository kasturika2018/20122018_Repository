//Objective:To verify whether application allows admin to create property details based on the Feature created

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
import com.training.pom.RETC_057POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_057 {

	private WebDriver driver;
	private String baseUrl;
	private RETC_057POM RETC057;
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
		RETC057 = new RETC_057POM(driver); 
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
			 	
		RETC057.sendUserName("admin");
		RETC057.sendPassword("admin@123");
		RETC057.clickLoginBtn();
		
				
		
		RETC057.Propertiestab();
		
		RETC057.clickFeaturesLink();;
		
		RETC057.EnterNameTextBox("OpenBalcony");;
		
		RETC057.EnterSlugTextBox("Balcony");
		
		RETC057.EnterDescTextBox("Apartment with Open Balcony");
		;
		RETC057.clickSubmitFeature();
		
		RETC057.clickAddNew();
		
		RETC057.EnterTitleTextBox(" Avidipta PhaseI");
		
		RETC057.EnterCredentialsTextBox("Avidipta Kolkata");
		
		RETC057.FeatureClick();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		
		RETC057.WaitForPublish();
		
		RETC057.Publish();
		
		RETC057.WaitPostPublish();
		
		String ActualResult = RETC057.PostPublish();
		Assert.assertEquals(ActualResult, ExpectedResult);
				
	}
}
