
package com.comcast.crm.objectrepositoyutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

import org.testng.Assert;


public class OrganizationInfoPage {


	WebDriver driver;

	public OrganizationInfoPage(WebDriver driver) // Rule 3 : Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;

	@FindBy(xpath = "(//td[@class='dvtCellInfo'])[13]")
	private WebElement indrustrieslnk;

	@FindBy(xpath = "(//td[@class='dvtCellInfo'])[15]")
	private WebElement typelnk;

	@FindBy(id = "dtlview_Phone")
	private WebElement verifyphonelnk;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getIndrustrieslnk() {
		return indrustrieslnk;
	}

	public WebElement getTypelnk() {
		return typelnk;
	}

	public WebElement getVerifyphonelnk() {
		return verifyphonelnk;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public void ConfMsg(String orgname, WebDriverUtility wLib, WebDriver driver) {
       wLib.waitForElementPresent(driver, headerMsg);
       String actual = headerMsg.getText();
       boolean s = actual.contains(orgname);
       Assert.assertEquals(s, true);
	}

}
