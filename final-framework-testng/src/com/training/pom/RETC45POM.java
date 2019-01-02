//Objective: To verify whether application allows admin to create property based on the Region created

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

public class RETC45POM {
			
		    private WebDriver driver; 
			
			public RETC45POM(WebDriver driver) {
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
			
			//2. Click on Regions link
			
			@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/ul/li[8]/ul/li[5]/a")
			private WebElement Regionlink; 
			
			//3.  Enter Valid Credentials in Name textbox
			
			@FindBy(id="tag-name")
			private WebElement NameTextBox;
			
			//4. Enter Valid Credentials in Slug textbox
						
			@FindBy(id="tag-slug")
			private WebElement SlugTextbox;
			
			//5. Click on Parent Region
			
			@FindBy(id="parent")
			private WebElement ParentRegion ;
			
			//5. Enter Valid Credentials in Description textbox
			
			@FindBy(id="tag-description")
			private WebElement DescTextbox;
			
			// 6. Click on Add New Region button
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
			
			// Click on checkbox in the added Region
			@FindBy(id="in-region-196")
			private WebElement Region;
			
			// Wait for Publish button
			
			@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/form/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/a")
			private WebElement WaitForPublish;
			
			// Click on Publish button
			
			@FindBy(xpath = "//input[@id='publish']")
			private WebElement publish;
			
			// Wait for Post Publish
			@FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/p/a")
			private WebElement WaitPostPublish;
			
			// Post Publish message
			@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/p")
			private WebElement postPublishMessage;
			
		//Enter UserName		
		public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
		}
		
		public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
		}
		
		public void clickLoginBtn() {
		this.loginBtn1.click(); 
		}
		
		//1. Click on Properties tab
		
		public void Propertiestab() {
		this.Propertiestab.click();
		
		}
		//2. Click on Region link
		
		public void clickRegionLink() {
		this.Regionlink.click();
		}
		//3. Enter valid credentials in Enter Title Here textbooks
			
		public void EnterNameTextBox (String TitleHere) {
		//this.TitleHere.clear(); 
		this.NameTextBox.sendKeys(TitleHere);
		
		}	
		//4. Enter valid credentials in textbox

		public void EnterSlugTextBox (String textbox) {
			
		//driver.switchTo().frame(0);
		//this.Textbox.clear(); 
		this.SlugTextbox.sendKeys(textbox);
		//driver.switchTo().defaultContent();
		}
			
		//5. Select Parent Region
		
		public void selectParentRegion(String Text) {
			Select ParentRegionDropdown = new Select ( ParentRegion );
			ParentRegionDropdown.selectByVisibleText(Text);
			
		}
		
		public void EnterDescTextBox ( String text) {
			this.DescTextbox.sendKeys(text);
		}
		
		// Click on Add New Region button
		public void clickSubmitRegion () {
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
		public void RegionClick() {
			this.Region.click();
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