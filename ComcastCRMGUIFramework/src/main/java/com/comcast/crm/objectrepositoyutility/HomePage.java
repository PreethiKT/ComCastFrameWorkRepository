package com.comcast.crm.objectrepositoyutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	WebDriver driver;

	public HomePage(WebDriver driver) // Rule 3 : Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Products")
	private WebElement productLink;

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText="Contacts")
	private WebElement contactLink;

	@FindBy(linkText = "Campaigns")
	private WebElement compaignLink;

	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCompaignLink() {
		return compaignLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

// business library
	public void navigateToCompaginPage() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		compaignLink.click();
	}

	public void logout() {
	mousemoveonElement(driver, adminImg);
		signOutLink.click();
	}

}
