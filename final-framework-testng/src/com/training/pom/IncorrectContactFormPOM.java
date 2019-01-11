package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IncorrectContactFormPOM {
private WebDriver driver; 
	
	public IncorrectContactFormPOM(WebDriver driver) {
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
	
	// Mouse over New Launch
	
	@FindBy(xpath="/html/body/div[1]/header/div[2]/nav/div/ul/li[2]/a")
	private WebElement NewLaunch;
	
	@FindBy(xpath="/html/body/div[1]/header/div[2]/nav/div/ul/div[1]/div/div[2]/div[2]/a")
	private WebElement Property;
	
	@FindBy(xpath="/html/body/div[1]/div[5]/div/div[2]/div[1]/div[2]/div/div[2]/form/p[1]/label/span/input")
	private WebElement Name;
	
	@FindBy(xpath="/html/body/div[1]/div[5]/div/div[2]/div[1]/div[2]/div/div[2]/form/p[2]/label/span/input")
	private WebElement Email;
	
	@FindBy(xpath="/html/body/div[1]/div[5]/div/div[2]/div[1]/div[2]/div/div[2]/form/p[3]/label/span/input")
	private WebElement Subject;
	
	@FindBy(xpath="/html/body/div[1]/div[5]/div/div[2]/div[1]/div[2]/div/div[2]/form/p[4]/label/span/textarea")
	private WebElement Message;
	
	@FindBy(xpath="/html/body/div[1]/div[5]/div/div[2]/div[1]/div[2]/div/div[2]/form/p[5]/input")
	private WebElement Send;
	
	@FindBy(xpath="/html/body/div[1]/div[5]/div/div[2]/div[1]/div[2]/div/div[2]/form/p[2]/label/span/input")
	private WebElement FailMessage;
	
	
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
	
	public void MouseOverNewLAunch()
	{
		Actions action=new Actions(driver);
		action.moveToElement(this.NewLaunch).build().perform();
	}
	public void clickProperty()
	{
		this.Property.click();
	}
	public void sendName(String NameText) {
		this.Name.clear();
		this.Name.sendKeys(NameText);
	}
	public void sendEmail(String EmailText) {
		this.Email.clear();
		this.Email.sendKeys(EmailText);
	}
	public void sendSubject(String SubjectText) {
		this.Subject.clear();
		this.Subject.sendKeys(SubjectText);
	}
	public void sendMessage(String MessageText) {
		this.Message.clear();
		this.Message.sendKeys(MessageText);
	}
	public void clickSend() {
		this.Send.click();
	}
		
	public String ErrorCheck() {
		return this.FailMessage.getAttribute("validationMessage");
	}

}
