package com.training.sanity.tests;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

//import junit.framework.*;
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LogoutFromApplicationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

@Test
public class LogoutFromAppplication {

	private String baseUrl;
	private LogoutFromApplicationPOM logoutPOM;
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
		ChromeDriver driver = (ChromeDriver) DriverFactory.getDriver(DriverNames.CHROME);
		logoutPOM = new LogoutFromApplicationPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//System.out.print(baseUrl);
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	public void validLoginTest() {
		logoutPOM.clickLogin1();
		logoutPOM.sendUserName("kasdasgu@in.ibm.com");
		logoutPOM.sendPassword("training2018");
		logoutPOM.clickLoginBtn(); 
		logoutPOM.clickLogout(); 
		screenShot.captureScreenShot("First");
	}
}

