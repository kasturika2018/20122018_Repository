package com.training.sanity.tests;


import java.util.List;
//import junit.framework.*;
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LogoutFromAppplication {
	protected ChromeDriver driver;
	protected void setUp(){
	      DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
	      driver = new ChromeDriver(capabilities);
	      driver.get("http://realestate.hommelle.com/");
	      driver.manage().window().setSize( new Dimension( 1124, 850 ) );
	   }
	protected void tearDown(){
	      driver.quit();
	   }
	public void testLogin() {
	    //write your code to enter username
		driver.findElement(By.name("userName")).sendKeys("manzoor");
		WebElement e = driver.findElement(By.name("userName"));
		System.out.println("getAttribute() " + e.getAttribute("value"));
		
	//	WebElement e = driver.findElement(By.id("myTextArea"));
		//	String ActualResult= driver.;
					//write script using getAttribute method
			
			
			String ExpectedResult="manzoor";
		//	assertEquals(ActualResult, ExpectedResult);
	    
	  }
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\SeleniumSetupFiles\\chromedriver_win32\\chromedriver.exe");
		LogoutFromAppplication page;
		page = new LogoutFromAppplication();
		page.setUp();
		page.testLogin();
		//driver.get("http://demowebshop.tricentis.com");
		//String s; 
		//s= driver.getTitle();
		//System.out.println(s);
		//logon
		
		
		
		//lopggedin
		
		
		
		
		//driver.close();
		
		// TODO Auto-generated method stub

	}
}
