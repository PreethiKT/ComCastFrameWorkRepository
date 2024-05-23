package com.comcast.crm.objectrepositoyutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	
	WebDriver driver;                     
	public OrganizationPage(WebDriver driver)    // Rule 3 : Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver,this );
	}

   @FindBy(xpath="//img[@alt='Create Organization...']")
   private WebElement createNewOrgBtn;

public WebElement getCreateNewOrgBtn() {
	return createNewOrgBtn;
}
		

	}


