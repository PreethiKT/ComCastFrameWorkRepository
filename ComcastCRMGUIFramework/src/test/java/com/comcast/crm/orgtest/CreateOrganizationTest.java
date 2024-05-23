package com.comcast.crm.orgtest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoyutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoyutility.HomePage;
import com.comcast.crm.objectrepositoyutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoyutility.OrganizationPage;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createNewOrg() throws Throwable {
		
			// read testscripts data from Excelfile
			String orgName = eLib.getDataFromExcel("org",1,2) + jLib.getRandomNumber() ;
										
					//Step 2: Navigate to Organization Module
					HomePage op = new HomePage(driver);
					op.getOrgLink().click();
					
					//Step 3: Click on "Create Organization" Button
					
					OrganizationPage cnp = new OrganizationPage(driver);
					cnp.getCreateNewOrgBtn().click();
					
					//Step 4: Enter all the details and create an organization
					CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
					cnop.createNewOrg(orgName);
					
					//verify Header msg Excepted Result
					
					OrganizationInfoPage oip = new OrganizationInfoPage(driver);
					 oip.ConfMsg(orgName, wLib, driver);
//					String actOrgName = oip.getHeaderMsg().getText();
//					if(actOrgName.contains(orgName)) {
//						System.out.println(orgName + "name is verified == PASS");
//					}
//					else{
//						System.out.println(orgName + "name is not  verified == FAIL");
//					}
				//	System.out.println("org contact script first");
				
				}
	
	@Test(groups = "regressionTest")
	public void CreateOrgWithIndusTest() throws Throwable {
		
		// read testscripts data from Excelfile
		String orgName = eLib.getDataFromExcel("org",4,2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org",4,3);
		String type = eLib.getDataFromExcel("org",4,4);
		
		//Step 2: Navigate to Organization Module
		HomePage op = new HomePage(driver);
		op.getOrgLink().click();
		
		//Step 3: Click on "Create Organization" Button
		OrganizationPage cnp = new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();
		
		//Step 4: Enter all the details and create an organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.getOrgNameField().sendKeys(orgName);
		
		WebElement wbsele = cnop.getOrgIndustryDD();
				wLib.select(wbsele, industry);
		
	 WebElement wbsele2 = cnop.getOrgTypeDD();
	 wLib.select(wbsele2, type);
	 cnop.getOrgSaveBtn().click();
	 
	 OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		boolean b = actOrgName.contains(orgName);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(b, true);
//		if(actOrgName.contains(orgName)) {
//			System.out.println(orgName + "name is verified == PASS");
//		}
//		else{
//			System.out.println(orgName + "name is not  verified == FAIL");
//		}
//		System.out.println("org contact script Second");
	}


@Test(groups = "regressionTest")
public void createNewContactOrg() throws Throwable
{
	// read testscripts data from Excelfile;
	String orgName = eLib.getDataFromExcel("org",7,2) + jLib.getRandomNumber() ;
	String phoneNumber = eLib.getDataFromExcel("org",7,3) + jLib.getRandomNumber() ;

				//Step 2: Navigate to Organization Module
	HomePage op = new HomePage(driver);
	op.getOrgLink().click();
				
				//Step 3: Click on "Create Organization" Button
	OrganizationPage cnp = new OrganizationPage(driver);
	cnp.getCreateNewOrgBtn().click();
				
	//enter all the details and create new Organization
	CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	cnop.getOrgNameField().sendKeys(orgName);
	cnop.getOrgPhoneField().sendKeys(phoneNumber);
	cnop.getOrgSaveBtn().click();
	//verify dropdown industries and type info expected result
	OrganizationInfoPage oip = new OrganizationInfoPage(driver);

	WebElement actOrgName = oip.getHeaderMsg();
	wLib.waitForElementPresent(driver, actOrgName);
	String text = actOrgName.getText();
	boolean e = text.contains(orgName);
	Assert.assertEquals(e, true);
//	if (text.contains(orgName)) {
//	System.out.println(orgName + " name is verfied==PASS");
//	} else {
//	System.out.println(orgName + " name is not  verfied==Fail");
//	}

	String actph = oip.getVerifyphonelnk().getText();
	boolean e1 = actph.contains(phoneNumber);
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(e1, true);

//	if (actph.equals(phoneNumber)) {
//	System.out.println(phoneNumber + "is verified==PASS");
//	} else {
//	System.out.println(phoneNumber + "is not verified");
//	}
//	System.out.println("org contact script Third");
}

}

	
	

			


	


