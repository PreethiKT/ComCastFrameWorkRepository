package com.comcast.crm.contacttest;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoyutility.ContactHomePage;
import com.comcast.crm.objectrepositoyutility.ContactsInfoPage;
import com.comcast.crm.objectrepositoyutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoyutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoyutility.HomePage;
import com.comcast.crm.objectrepositoyutility.OrgWithinContactPage;
import com.comcast.crm.objectrepositoyutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoyutility.OrganizationPage;

/**
 * 
 * @author Preethi
 * 
 */
public class CreateContactTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {

		// Read Test Script Data From Excel
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// Step 2: Navigate to Contact Module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// Step 3: Click on "Create contact" Button

		ContactHomePage cp = new ContactHomePage(driver);
		cp.getCreateNewContPlusIcon().click();

		// Step 4: Enter all the details and create an contact
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.getContLastNameField().sendKeys(lastName);
		ccp.getSaveContactButton().click();

		// verify Header orgName info
		//WebElement e = driver.findElement(By.id("dvHeaderText"));
		//wLib.waitForElementPresent(driver, e);
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		//String actheader = cip.getContHeaderInfo().getText();
		String actheader = cip.getContHeaderInfo().getText();
		boolean status = actheader.trim().contains(lastName);
		Assert.assertEquals(status, true);

		String actLastName = driver.findElement(By.id("dtlview_Last name")).getText();
		//SoftAssert soft = new SoftAssert();
		boolean status1=actLastName.trim().contains(lastName);
		Assert.assertEquals(status1, true);
		//soft.assertEquals(actLastName, lastName);
		//soft.assertAll();
	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDate() throws Throwable {
		// read testscripts data from Excelfile
		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();

		/* Step 2: Navigate to Organization Module */		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		/* Step 3: Click on "Create Contact" Button */
		ContactHomePage cp = new ContactHomePage(driver);
		cp.getCreateNewContPlusIcon().click();

		/* Step 4: To capture the system date */
		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequriedDateYYYYDDMM(30);
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.getContLastNameField().sendKeys(lastName);

		ccp.getSuppStartDateField().clear();
		ccp.getSuppStartDateField().sendKeys(startDate);

		ccp.getSuppEndDateField().clear();
		ccp.getSuppEndDateField().sendKeys(endDate);
		ccp.getSaveContactButton().click();
		// verify Header orgName info

		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actStartDate = cip.getSuppSDCreatedDtlView().getText();
           Assert.assertEquals(startDate, actStartDate);
		String actendtDate = cip.getSuppEDCreatedDtlView().getText();
		   Assert.assertEquals(endDate, actendtDate);
//		if (actendtDate.equals(endDate)) {
//			System.out.println(endDate + " information for enddate is Verified  ==PASS");
//		} else {
//			System.out.println(endDate + " information for enddate is not Verified ==FAIL");
//		}
//		System.out.println("create contact script Second");

	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws Throwable {

		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();

//Step 2: Navigate to Organization Module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.getOrgNameField().sendKeys(orgName);
		cop.getOrgSaveBtn().click();
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		 oip.ConfMsg(orgName, wLib, driver);
		 
//Step 3: Click on "Create Organization" Button
		hp.getContactLink().click();
		ContactHomePage cp = new ContactHomePage(driver);
		cp.getCreateNewContPlusIcon().click();

//Step 4: Enter all the details and create an organization
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.getContLastNameField().sendKeys(contactLastName);

		// CreateNewContactPage cnp = new CreateNewContactPage(driver);
		ccp.getContLastNameField().sendKeys(contactLastName);
		ccp.getOrgNameInContPlusIcon().click();

//switch to child window
		wLib.switchToTabOnURL(driver, "module=Accounts");
		OrgWithinContactPage ocp = new OrgWithinContactPage(driver);
		ocp.getSearchOrgField().sendKeys(orgName);
		ocp.getSearchOrgNowButton().click();

		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();// dynamic Xpath

		wLib.switchToTabOnURL(driver, "contacts&action");
		driver.findElement(By.name("button")).click();

		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String headerInfo = cip.getContHeaderInfo().getText();
		Assert.assertEquals(contactLastName, headerInfo);

//verify Header orgName info

		String actorgName = cip.getOrgSavedInConDtlView().getText();
		Assert.assertEquals(orgName, actorgName);
		
//		if (actorgName.trim().equals(orgName)) {
//			System.out.println(orgName + "is Created==PASS");
//		} else {
//			System.out.println(orgName + "is not Created==FAIL");
//		}
//		System.out.println("create contact script Thired");
	}
}
