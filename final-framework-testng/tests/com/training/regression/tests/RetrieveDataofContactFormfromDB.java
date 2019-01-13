package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.ContactFormwithDBDataProvider;
import com.training.generics.ScreenShot;
import com.training.pom.ContactFormPOM;
import com.training.pom.ContactForminDBPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RetrieveDataofContactFormfromDB {
	private WebDriver driver;
	private String baseUrl;
	private ContactForminDBPOM contactinDBPOM;
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
		contactinDBPOM = new ContactFormPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		
		driver.quit();
	}
	
	@Test(dataProvider = "db-inputs", dataProviderClass = ContactFormwithDBDataProvider.class)
	public void addNewRegionDBTest(String regionName, String slugName, String desc) throws InterruptedException {
	
	// User click on Properties link
	testPOM.clickProperties();
	// User click on Regions link
	testPOM.clickRegions();
	// User enters text in Name textbox
	testPOM.enterName("New Launches123");

	// To Verify the RegionName entered in application is same as in DB
	String ExpRegionName = testPOM.getRegionName();
	String ActRegionName = regionName;
	Assert.assertEquals(ActRegionName, ExpRegionName);
	System.out.println("The RegionName is " + ActRegionName + " " + ExpRegionName);

	// User enters text in Slug textbox
	testPOM.enterSlug("launch");

	// To Verify the SlugName entered in application is same as in DB
	String ExpSlugName = testPOM.getSlugName();
	String ActSlugName = slugName;
	Assert.assertEquals(ActSlugName, ExpSlugName);
	System.out.println("The Slug is " + ActSlugName + " " + ExpSlugName);

	// User click on Parent Region dropdown and select 'None'
	testPOM.clickParentRegion();
	// User enters text in Description textbox
	testPOM.enterDescription("New Launches of vilas, apartments, flats");

	// To Verify the Description entered in application is same as in DB
	String ExpDescription = testPOM.getDescription();
	String ActDescription = desc;
	Assert.assertEquals(ActDescription, ExpDescription);
	System.out.println("The Slug is " + ActDescription + " " + ExpDescription);

	// User clicks on Add New Region button
	testPOM.addRegion();
	// User refreshes the browser
	driver.navigate().refresh();
	}

	
}
