//Objective:To verify whether application allows admin to create property details based on the Feature created
package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RETC_057POM {
	
	private WebDriver driver; 
	
	public RETC_057POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;

	@FindBy(name="login")
	private WebElement loginBtn1; 

	//1. Click on Properties tab
	@FindBy(xpath= "/html/body/div[1]/div[1]/div[2]/ul/li[8]/a/div[3]")
	private WebElement Propertiestab; 

	//2. Click on Features link
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/ul/li[8]/ul/li[4]/a")
	private WebElement Featureslink;
	
	//3.  Enter Valid Credentials in Name textbox
	
	@FindBy(id="tag-name")
	private WebElement NameTextBox;
	
	//4. Enter Valid Credentials in Slug textbox 
				
	@FindBy(id="tag-slug")
	private WebElement SlugTextbox;
	
	//5. Enter Valid Credentials in Description textbox 
	
	@FindBy(id="tag-description")
	private WebElement DescTextbox;
	
	// 6. Click on Add New Features button
	@FindBy(id="submit")
	private WebElement submit;
	
	// Click on Add new link
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/ul/li[8]/ul/li[3]/a")			
	private WebElement NewLink;			
				
	// Add New Title
	@FindBy(id="title")
	private WebElement Title;
				
	// Add Valid Credentials 
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement Credentials;
				
	// Click on checkbox in the added Features
	@FindBy(id="in-property_feature-200")
	private WebElement Feature;
	
	// Wait for Publish button
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/form/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/a")
	private WebElement WaitForPublish;
	
	// Click on Publish button
				
	@FindBy(xpath = "//input[@id='publish']")
	private WebElement publish;
	
	// Wait for Post Publish
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/p/a")
	private WebElement WaitPostPublish;
			
	// Post publish message
	@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/p")
	private WebElement postPublishMessage;
	
	//Enter UserName		
	public void sendUserName(String userName) {
	this.userName.clear();
	this.userName.sendKeys(userName);
	}
	
	//Enterl Password
	public void sendPassword(String password) {
	this.password.clear(); 
	this.password.sendKeys(password); 
	}
			
	// Click login button
	public void clickLoginBtn() {
	this.loginBtn1.click(); 
	}
			
	//1. Click on Properties tab
			
	public void Propertiestab() {
	this.Propertiestab.click();
	}
    
	public void clickFeaturesLink() {
		this.Featureslink.click();
		}
		//3. Enter valid credentials in Enter Title Here textbooks
			
		public void EnterNameTextBox (String TitleHere) {
		//this.TitleHere.clear(); 
		this.NameTextBox.sendKeys(TitleHere);
		
		}	
		//4. Enter valid credentials in textbox

		public void EnterSlugTextBox (String textbox) {
			
		this.SlugTextbox.sendKeys(textbox);
		//driver.switchTo().defaultContent();
		}
			
		
		public void EnterDescTextBox ( String text) {
			this.DescTextbox.sendKeys(text);
		}
		
		// Click on Add New Feature button
		public void clickSubmitFeature () {
			this.submit.click();
		}
		//Click on Add new link
		
		public void clickAddNew () {
			this.NewLink.click();
		}
		
		public void EnterTitleTextBox(String text) {
			//this.TitleTextBox.clear(); 
			this.Title.sendKeys(text); 
			}
		public void EnterCredentialsTextBox ( String text) {
			//this.BodyTextBox.clear();
			this.Credentials.sendKeys(text);				
		}
		public void FeatureClick() {
			this.Feature.click();
		}
		
		public void WaitForPublish() {
			WebDriverWait wait= new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(WaitForPublish));
			
		}
		// Publish
		public void Publish() throws AWTException {

			this.publish.click();
		}
		
		public void WaitPostPublish () {
			
			WebDriverWait wait1= new WebDriverWait(driver, 30);
			wait1.until(ExpectedConditions.elementToBeClickable(WaitPostPublish)); 
		
		}
		public String PostPublish() {
			return this.postPublishMessage.getText();
		}
	}
