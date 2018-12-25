package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
/*	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	*/
	@Test
	public void validLoginTest() {
		recoverPOM.clickLogin();
		
		recoverPOM.clickLostPassword();
		
		String ExpectedResult="Lost Password – Real Estate";
		String ActualResult = driver.getTitle();
		System.out.println(ActualResult);
		Assert.assertEquals(ActualResult, ExpectedResult);
		
		recoverPOM.EmailAddress("kasdasgu@in.ibm.com");
		recoverPOM.ResetPassword();
		String ExpectedResult1="A confirmation link has been sent to your email address.";
		String ActualResult1= driver.findElement(By.id("post-124")).getText();
		System.out.println(ActualResult1);
		Assert.assertEquals(ActualResult1, ExpectedResult1);
		
		// Go to URL
		//Reset Password link: http://realestate.hommelle.com/reset-password/?login=kasdasgu%40in.ibm.com&key=AxmRunH8yGshKDO6bJix 
		
		driver.get("http://realestate.hommelle.com/reset-password/?login=kasdasgu%40in.ibm.com&key=uTdfaNhCCPd8d2c8XmfA");
	    driver.manage().window().setSize( new Dimension( 1124, 850 ) );
	    String ExpectedResult2="Reset Password – Real Estate";
	    String ActualResult2 = driver.getTitle();
		System.out.println(ActualResult);
		Assert.assertEquals(ActualResult2, ExpectedResult2);

	    
		recoverPOM.Newpassword("training2018");
		recoverPOM.RepeateNewpassword("training2018");
		recoverPOM.ResetNewpassword();
		screenShot.captureScreenShot("First");
		
	}
}