package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCategoryNewPostPOM {
	private WebDriver driver; 
	
	public AddCategoryNewPostPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="log")
	private WebElement username1;

	@FindBy(name="pwd")
	private WebElement password;

	@FindBy(xpath="//*[@id=\"tab1\"]/form/p[3]/input")

	private WebElement signin;

	@FindBy(xpath="//*[@id=\"menu-posts\"]/a/div[2]")
	private WebElement postslink;

	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[3]/a")
	private WebElement addnew;

	@FindBy(xpath="//*[@id=\"category-add-toggle\"]")
	private WebElement addnewcategorylink;



	@FindBy(xpath="//*[@id=\"newcategory\"]")
	private WebElement addnewcategorytextbox;

	public void selectparentcategory1ByIndex(int i) {

	Select parentcategory1=new Select(driver.findElement(By.xpath("//*[@id=\"newcategory_parent\"]")));
	parentcategory1.selectByIndex(7);
	}

	@FindBy(id="category-add-submit")
	private WebElement addnewcategorybttn;

	@FindBy(xpath="//*[@id=\"category-tabs\"]/li[1]/a")
	private WebElement allcategory;
	
	@FindBy(xpath="//*[@id=\"title\"]")
	private WebElement TitleBox;
	
	@FindBy(xpath="//*[@id=\"content\"]")
	private WebElement ContentBox;

	@FindBy(xpath="//*[@id=\"in-category-436\"]")
	private WebElement finalcheckbox;
	
	// Wait for Publish button
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/form/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/a")
	private WebElement WaitForPublish;
			
	@FindBy(xpath = "//input[@id='publish']")
	private WebElement publish;
	
	// Wait for Post Publish
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/p/a")
	private WebElement WaitPostPublish;

	// Post publish message
	@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/p")
	private WebElement postPublishMessage;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div/ul[2]/li/a/span")
	private WebElement adminHover;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div/ul[2]/li/div/ul/li[3]/a")
	private WebElement Logout ;
	
	@FindBy(xpath="/html/body/div[1]/header/div[2]/div[1]/div[1]/div[1]/h2/a")
	private WebElement RealEstate;
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div/article/div[3]/div/div/div/div/div/div[1]/div/div[3]/form/input[1]")
	private WebElement WaitPropertySearch;
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div/article/div[3]/div/div/div/div/div/div[1]/div/div[3]/form/input[1]")
	private WebElement PropertySearch;
			
	public void sendusername1(String username) {
	this.username1.click();
	this.username1.sendKeys(username);
	}

	public void sendpassword(String password) {
	this.password.click();
	this.password.sendKeys(password);
	}

	public void clicksignin() {
	this.signin.click();
	}

	public void mouseoverpostslink() {
	Actions action = new Actions(driver);
	action.moveToElement(this.postslink).build().perform();
	}
	public void clickpostslink() {
	this.postslink.click();
	}

	public void clickaddnew() {
	this.addnew.click();
	}
	public void clickaddnewcategorylink() {
	this.addnewcategorylink.click();
	}
	public void sendaddnewcategorytextbox(String addnewcategorytext) {
	this.addnewcategorytextbox.click();
	this.addnewcategorytextbox.sendKeys(addnewcategorytext);
	}
	public void clickaddnewcategorybttn() {
	this.addnewcategorybttn.click();
	}

	//public void selectallcategoryByVisibleText(String string) {

	//WebElement checkBox1 = driver.findElement(By.xpath("//*[@id=\"category-237\"]/label"));
	//WebElement checkBox2 = driver.findElement(By.id("in-category-217"));
	//}



	public void clickallcategory() {
	// TODO Auto-generated method stub
	this.allcategory.click();
	}

	public void finalcheckbox() {
	// TODO Auto-generated method stub
	this.finalcheckbox.click();
	}

	public void EnterTitle(String Title) {
		this.TitleBox.clear();
		this.TitleBox.sendKeys(Title);
	}

	public void EnterContent(String Content) {
		this.ContentBox.click();
		this.ContentBox.sendKeys(Content);
	}
	
	public void WaitForPublish() {
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(WaitForPublish));
		
	}
	
	public void WaitPostPublish () {
		
		WebDriverWait wait1= new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(WaitPostPublish)); 
	
	}
	public void clickpublish() {
	// TODO Auto-generated method stub
	this.publish.click();
	}
	
	public String PostPublish() {
		return this.postPublishMessage.getText();
	}
	
	public void MouseOverAdmin()
	{
		Actions action=new Actions(driver);
		action.moveToElement(this.adminHover).build().perform();
	}
	public void clickLogout() {
		// TODO Auto-generated method stub
		this.Logout.click();
	}
	
	public void clickRealEstate() {
		this.RealEstate.click();
	}
	
	public void WaitForSearchProperty () {
		
		WebDriverWait wait1= new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(WaitPropertySearch)); 
	
	}
	
	public void searchProperty(String Property) {
		this.PropertySearch.sendKeys(Property);
		this.PropertySearch.sendKeys(Keys.ENTER);
	}
}
