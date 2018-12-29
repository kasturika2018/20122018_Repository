package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_039POM {

	 private WebDriver driver; 
		
		public RETC_039POM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
	
		@FindBy(id="user_login")
		private WebElement userName; 
		
		@FindBy(id="user_pass")
		private WebElement password;
	
		@FindBy(name="login")
		private WebElement loginBtn1; 
		
		//Click on Posts
		@FindBy(id="menu-posts")
		private WebElement Posts;
		
		// Click on Categories
		@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/ul/li[3]/ul/li[4]/a")
		private WebElement Categories;
		
		// Enter Valid Credentials in Name textbox
		
		@FindBy(id="tag-name")
		private WebElement NameTextBox;
		
		// Enter Valid Credentials in Slug textbox
		@FindBy(id="tag-slug")
		private WebElement SlugTextBox;
		
		// Enter Valid Credentials in Description textbox
		
		@FindBy(id="tag-description")
		private WebElement DescTextBox;
		
		
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
			
			//1. Click on Posts
			
			public void Postsclick() {
				this.Posts.click();
			}
	
			// Click on Categories
			public void Categoriesclick() {
				this.Categories.click();
			}
			public void EnterName(String password) {
				this.NameTextBox.clear(); 
				this.NameTextBox.sendKeys(password); 
				}
			public void EnterSlug(String password) {
				this.SlugTextBox.clear(); 
				this.SlugTextBox.sendKeys(password); 
				}
			public void EnterDesc(String password) {
				this.DescTextBox.clear(); 
				this.DescTextBox.sendKeys(password); 
				}
}
