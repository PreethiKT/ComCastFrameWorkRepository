package com.comcast.crm.objectrepositoyutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Preethi
 * 
 * Contains Login page elements & business Lib like login()
 * 
 */

public class LoginPage extends WebDriverUtility {  //Rule-1 create a separate java class
	
	 WebDriver driver;                     
	public LoginPage(WebDriver driver)    // Rule 3 : Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver,this );
	}
	@FindBy(name="user_name")         // Rule-2 Object Creation
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	// Rule 4 : Object  Encapsulation
	// Rule 5 : Object Utilization
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * login to application based on UserName , Password , URL arguments
	 * @param url
	 * @param username
	 * @param password
	 * @throws InterruptedException
	 */
	
// Run 5 : provide Action // business method
	public void loginToApp(String url,String username , String password) throws InterruptedException {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	

	

}
