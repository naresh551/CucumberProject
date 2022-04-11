package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class Steps
{
	public WebDriver driver;
	public LoginPage lp;
	public DesiredCapabilities dc; // It will use to set all the options related to browser security/profile/general etc settings at runtime of program execution
	
	@Given("User launches chrome browser")
	public void user_launches_chrome_browser()
	{
		dc = new DesiredCapabilities();
		dc.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver(dc);
		System.out.println(" The chrome browser reference is :: "+driver);
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opnes_url(String url) throws Exception 
	{
		driver.manage().window().maximize();
	  driver.get(url);
	  Thread.sleep(5000);
	}

	@When("Click on LogIn header link")
	public void click_on_log_in_header_link() throws Exception
	{
		lp.clickLoginlink();
		 Thread.sleep(5000);
	   
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws Exception
	{
	    lp.setUserName(email);
	    lp.setPassword(password);
	    Thread.sleep(5000);
	}

	@When("Click on Login button")
	public void click_on_login_button() throws Exception
	{
	  lp.clickLoginbtn();
	  Thread.sleep(5000);
	}

	@Then("Check the Logout link is displayed")
	public void check_the_logout_link_is_displayed() throws Exception 
	{
			boolean result = lp.LogoutlinkDisplay();
			
			if(result)
				System.out.println(" Logout link is displaying... Login is successfull");
			else
			{
				System.out.println("Logout link is NOT displaying.... Login was unsuccessfull");
				Assert.fail("Logout link is NOT displaying.... Login was unsuccessfull");
			}
			 Thread.sleep(5000);
	}

	@When("User Click on Logout link")
	public void user_click_on_logout_link() throws Exception
	{
	    lp.clickLogout();
	    Thread.sleep(9000);
	}

	/*@Then("Check the Login link is displayed")
	public void check_the_login_link_is_displayed() throws Exception 
	{

		boolean result = lp.LoginlinkDisplay();
		
		if(result)
			System.out.println(" Login link is displaying... Logout is successfull");
		else
		{
			System.out.println("Login link is NOT displaying.... Logout was unsuccessfull");
			Assert.fail("Login link is NOT displaying.... Logout was unsuccessfull");
		}
	   
		 Thread.sleep(5000);
	}*/

	@Then("close the browser")
	public void close_the_browser()
	{
	    driver.close();
	    
	}


}
