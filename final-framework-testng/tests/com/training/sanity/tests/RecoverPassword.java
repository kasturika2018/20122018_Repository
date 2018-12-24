package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginTestPOM;
import com.training.pom.RecoverLostPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RecoverPassword {
	
	private WebDriver driver;
	private String baseUrl;
	private RecoverLostPasswordPOM recoverPOM;
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
		recoverPOM = new RecoverLostPasswordPOM(driver); 
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
		recoverPOM.clickLogin();
		//loginPOM.sendUserName("admin");
		//loginPOM.sendPassword("admin@123");
		recoverPOM.clickLostPassword();
		recoverPOM.EmailAddress("kasdasgu@in.ibm.com");
		recoverPOM.ResetPassword();
		screenShot.captureScreenShot("First");
	}
}