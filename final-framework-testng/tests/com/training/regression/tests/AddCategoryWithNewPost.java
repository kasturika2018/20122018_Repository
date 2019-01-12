package com.training.regression.tests;

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
import com.training.pom.AddCategoryNewPostPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCategoryWithNewPost {
	
	private WebDriver driver;
	private String baseUrl;
	private AddCategoryNewPostPOM AddCatPOM;
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
		AddCatPOM = new AddCategoryNewPostPOM(driver);
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
		String ExpectedResult="Post published. View post";
		AddCatPOM.sendusername1("admin");
		AddCatPOM.sendpassword("admin@123");
		AddCatPOM.clicksignin();
		AddCatPOM.mouseoverpostslink();
		AddCatPOM.clickpostslink();
		AddCatPOM.clickaddnew();

		AddCatPOM.clickaddnewcategorylink();
		AddCatPOM.sendaddnewcategorytextbox("final");
		AddCatPOM.selectparentcategory1ByIndex(10);

		AddCatPOM.clickaddnewcategorybttn(); 
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		driver.get("http://realestate.hommelle.com/wp-admin/post-new.php"); 
		driver.navigate().refresh();


		AddCatPOM.clickallcategory(); 
	//loginPOM055.selectallcategoryByVisibleText("chacolate1234");
		AddCatPOM.EnterTitle("Avidipta Housing");
		AddCatPOM.EnterContent("Avidipta Flat for Sale");
		AddCatPOM.finalcheckbox();
		AddCatPOM.WaitForPublish();

		AddCatPOM.clickpublish();
		AddCatPOM.WaitPostPublish();
		String ActualResult = AddCatPOM.PostPublish();
		Assert.assertEquals(ActualResult, ExpectedResult);
		AddCatPOM.MouseOverAdmin();
		AddCatPOM.clickLogout();
		AddCatPOM.clickRealEstate();
		
		//robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		//robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		AddCatPOM.WaitForSearchProperty();
		AddCatPOM.searchProperty("Avidipta Housing");
		
		AddCatPOM.WaitPropertyList();
		AddCatPOM.clickSearchResult();
		AddCatPOM.WaitForAddedProperty();
		
	}

}
