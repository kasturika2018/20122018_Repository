package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeRolePOM {
private WebDriver driver; 
	
	public ChangeRolePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="sign-in")
	private WebElement Logintestlink; 
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn1;
	
	// Click User
	
	@FindBy(xpath="/html/body/div/div[1]/div[2]/ul/li[18]/a/div[3]")
	private WebElement User;
	
	@FindBy(xpath="/html/body/div/div[1]/div[2]/ul/li[18]/ul/li[2]/a")
	private WebElement AllUser;
	
	
	@FindBy(xpath="//*[@id=\"new_role2\"]")
	private WebElement Roles;
	
	@FindBy(xpath="//*[@id=\"changeit2\"]")
	private WebElement Change;
	
	@FindBy(xpath="/html/body/div/div[2]/div[2]/div[1]/div[3]/form/div[2]/div[3]/span[2]/a[1]")
	private WebElement MovePage;
	
	@FindBy(xpath="/html/body/div/div[2]/div[2]/div[1]/div[3]/div[2]/p")
	private WebElement ChangeRoleMessage;
	
	
	//@FindBy(name="login")
	//private WebElement loginBtn; 
	
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
	public void clickLogin() {
	this.Logintestlink.click(); 
	}
	
	public void clickUser() {
		
		this.User.click();
	}
	
	public void clickAllUser() {
		
		this.AllUser.click();
	}
	
	public String clickUserCheckBox ( String NameText) {
		
		if(driver.findElements(By.linkText(NameText)).size() != 0){
			WebElement link = driver.findElement(By.linkText(NameText));
			WebElement trElement = link.findElement(By.xpath("../../.."));
			WebElement checkboxElement = trElement.findElement(By.tagName("input"));
			checkboxElement.click();
			return "true";
		}
		else {
			return "false";
		}
		
		
	}
	
	public void MovePage() {
		
		this.MovePage.click();
	}
	
	public void SelectRole(String RoleText) {
		Select RolesList= new Select(this.Roles);
		RolesList.selectByVisibleText(RoleText);
		
	}
	
	public void clickChange() {
		
		this.Change.click();
	}
	
	public void WaitForMessage () {
		
		WebDriverWait wait1= new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(ChangeRoleMessage)); 
	
	}
	public String DisplayedChangeRoleMessage() {
		return this.ChangeRoleMessage.getText();
	}
	
}
