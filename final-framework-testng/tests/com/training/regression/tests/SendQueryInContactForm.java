package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.ContactFormDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ContactFormPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SendQueryInContactForm {
	private WebDriver driver;
	private String baseUrl;
	private ContactFormPOM contactPOM;
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
		contactPOM = new ContactFormPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs", dataProviderClass = ContactFormDataProviders.class)
	public void loginDBTest(String Name, String Email, String Subject, String Message ) {
		
		String ExpectedResult="Thank you for your message. It has been sent.";
		contactPOM.clickLogin();
		
	   	
		contactPOM.sendUserName("kasdasgu@in.ibm.com");
		contactPOM.sendPassword("training2018");
		contactPOM.clickLoginBtn();
		contactPOM.MouseOverNewLAunch();
		contactPOM.clickProperty();
		
		System.out.println("Name is:" + Name);
		System.out.println("Email is:" + Email);
		System.out.println("Sub is:" + Subject);
		System.out.println("Message is:" + Message);
		
		contactPOM.sendName(Name);
		contactPOM.sendEmail(Email);
		contactPOM.sendSubject(Subject);
		contactPOM.sendMessage(Message);
		contactPOM.clickSend();
		
		contactPOM.WaitForMessage();
		
		
		String ActualResult = contactPOM.PostSend();
		System.out.println("ActualResult is:" + ActualResult);
		Assert.assertEquals(ActualResult, ExpectedResult);
		
		screenShot.captureScreenShot(Name);

	}
}
