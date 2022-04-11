package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{	
	public WebDriver driver;
	
	public LoginPage(WebDriver rdriver)// Constructor which initiate the driver
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[@href='/login']")
	@CacheLookup
	WebElement linkLogin;
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Log in']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Log out")
	@CacheLookup
	WebElement linkLogout;
	
	public void setUserName(String uname)
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLoginbtn()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		linkLogout.click();
	}
	
	public void clickLoginlink()
	{
		linkLogin.click();
	}
	
	public boolean LogoutlinkDisplay()
	{
		if(linkLogout.isDisplayed())
			return true;
			else
				return false;
	}
	
	public boolean LoginlinkDisplay()
	{
		if(linkLogin.isDisplayed())
			return true;
			else
				return false;
	}
	
}
