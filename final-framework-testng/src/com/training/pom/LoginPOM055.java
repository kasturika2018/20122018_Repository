package com.training.pom;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.Select;



	public class LoginPOM055 {

	private WebDriver driver; 
	public LoginPOM055(WebDriver driver) {
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

	@FindBy(xpath="//*[@id=\"in-category-242\"]")
	private WebElement finalcheckbox;

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

	@FindBy(xpath = "//input[@id='publish']")
	private WebElement publish;


	public void clickpublish() {
	// TODO Auto-generated method stub
	this.publish.click();
	}
	} 




