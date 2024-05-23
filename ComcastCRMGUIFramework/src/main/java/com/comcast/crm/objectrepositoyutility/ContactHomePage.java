package com.comcast.crm.objectrepositoyutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactHomePage {

	
	//Initialization
			WebDriver driver;
			public ContactHomePage(WebDriver driver)
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
			
		//Declaration
			@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
			private WebElement createNewContPlusIcon;
			
		//Getters	
			public WebElement getCreateNewContPlusIcon() {
				return createNewContPlusIcon;
			}
			
			
	
}
