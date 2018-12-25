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
import com.training.pom.GenerateNewPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class generateNewPassword {
	
	    //This program depends on Admin access 
	    //As Admin credentials are not working, executing the scenario with user login
	
	private WebDriver driver;
	private String baseUrl;
	private GenerateNewPasswordPOM generatePasswordPOM;
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
		generatePasswordPOM = new GenerateNewPasswordPOM(driver); 
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
		generatePasswordPOM.clickLogin();
		generatePasswordPOM.sendUserName("kasdasgu@in.ibm.com");
		generatePasswordPOM.sendPassword("training2018");
		generatePasswordPOM.clickLoginBtn(); 
		generatePasswordPOM.ChangePasswordClick();
		generatePasswordPOM.sendCurrentPassword("training2018");
		generatePasswordPOM.sendNewPassword("training2018");
		generatePasswordPOM.sendConfirmPassword("training2018");
		generatePasswordPOM.clickSavePassword();
		screenShot.captureScreenShot("First");
	}
}

