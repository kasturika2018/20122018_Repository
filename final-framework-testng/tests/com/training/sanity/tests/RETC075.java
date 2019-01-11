package com.training.sanity.tests;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor ;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ContactFormPOM;
import com.training.pom.LoginPOM055;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;





public class RETC075 {
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
	
	@Test
	public void validLoginTest() throws AWTException, InterruptedException {
	loginPOM055.sendusername1("admin");
	loginPOM055.sendpassword("admin@123");
	loginPOM055.clicksignin();
	loginPOM055.mouseoverpostslink();
	loginPOM055.clickpostslink();
	loginPOM055.clickaddnew();

	loginPOM055.clickaddnewcategorylink();
	loginPOM055.sendaddnewcategorytextbox("final");
	loginPOM055.selectparentcategory1ByIndex(10);

	loginPOM055.clickaddnewcategorybttn(); 
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	driver.get("http://realestate.hommelle.com/wp-admin/post-new.php"); 
	driver.navigate().refresh();


	loginPOM055.clickallcategory(); 
	//loginPOM055.selectallcategoryByVisibleText("chacolate1234");
	loginPOM055.finalcheckbox();
	Thread.sleep(7000);

	loginPOM055.clickpublish();


	}


}



