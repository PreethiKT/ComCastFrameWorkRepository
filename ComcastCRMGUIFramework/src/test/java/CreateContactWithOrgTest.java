
import org.openqa.selenium.By;
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


public class CreateContactWithOrgTest extends BaseClass {
	
	@Test
	public void createContactWithOrg() throws Throwable {
		int ranNum = jLib.getRandomNumber();

		// Read Test Script data from Excel
		String ConLastName = eLib.getDataFromExcel("contact", 7, 3) + ranNum;
		System.out.println("Contact Name generated is : " + ConLastName);

		String orgName = eLib.getDataFromExcel("contact", 7, 2) + ranNum;
		System.out.println("Org Name generated is : " + orgName);

		String OrgWindowUrl = eLib.getDataFromExcel("contact", 7, 4);
		String ContWindowUrl = eLib.getDataFromExcel("contact", 7, 5);
	// Create an organization
			HomePage homePagePOM = new HomePage(driver);
			homePagePOM.getOrgLink().click();

			// Step 3: Click on "Create Organization" Button
			OrganizationPage OrgPOM = new OrganizationPage(driver);
			OrgPOM.getCreateNewOrgBtn().click();

			// Step 4: Enter all the details and create an organization
			CreatingNewOrganizationPage cnOrgPOM = new CreatingNewOrganizationPage(driver);
			cnOrgPOM.createNewOrg(orgName);

			// Verification of organization
			// OrgInfoPOMPage object creation
			OrganizationInfoPage orgInfoPOM = new OrganizationInfoPage(driver);

			// Verify Header Detail with respect to Expected Result
			String HeaderDetails = orgInfoPOM.getHeaderMsg().getText();
			System.out.println("Details of Header is : " + HeaderDetails);
			if (HeaderDetails.contains(orgName)) {
				System.out.println("****OrgName is found in Header****: PASS");
			} else {
				System.out.println("****OrgName is NOT found in Header****: FAIL");
			}

			// Verify Header orgName info w.r.t Expected Result
			String orgNameCreated = orgInfoPOM.getHeaderMsg().getText();
			if (orgNameCreated.equals(orgName)) {
				System.out.println(orgName + " is created successfully==PASS");
			} else {
				System.out.println(orgName + " is NOT created== FAIL");
			}

			// Creating a contact
			// Click on contacts link
			HomePage hp = new HomePage(driver);
			hp.getContactLink().click();

			// Click on create new contact
			ContactHomePage contHpPOM = new ContactHomePage(driver);
			contHpPOM.getCreateNewContPlusIcon().click();

			// Enter the contact LastName
			CreateNewContactPage cnContPOM = new CreateNewContactPage(driver);
			cnContPOM.getContLastNameField().sendKeys(ConLastName);

			// Selecting organization within contact
			cnContPOM.getOrgNameInContPlusIcon().click();

			// switch to child window
			wLib.switchToTabOnURL(driver, OrgWindowUrl);

			// Select the organization name from child window
			OrgWithinContactPage orgInContPOM = new OrgWithinContactPage(driver);
			orgInContPOM.getSearchOrgField().sendKeys(orgName);
			orgInContPOM.getSearchOrgNowButton().click();

			// Selecting the Org - dynamic element
			driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

			// switch back to parent window
			wLib.switchToTabOnURL(driver, ContWindowUrl);

			// save the contact
			cnContPOM.getSaveContactButton().click();

			// Verification of contact
			ContactsInfoPage contInfoPOM = new ContactsInfoPage(driver);
			// Verifying header info w.r.t contact name
			String headerName = contInfoPOM.getContHeaderInfo().getText();
			if (headerName.contains(ConLastName)) {
				System.out.println("Contact detail is driven == PASS");
			} else {
				System.out.println("Contact detail is not driven == FAIL");
			}

			// Verify contact Last name created w.r.t contact name
			String SavedLastName = contInfoPOM.getContLastNameInfo().getText();
			if (SavedLastName.equals(ConLastName)) {
				System.out.println("Contact is created and verified == PASS");
			} else {
				System.out.println("Contact is not verified== FAIL");
			}

			// Verify org name within contact
			String orgNameSavedInCont = contInfoPOM.getOrgSavedInConDtlView().getText();
			if (orgNameSavedInCont.trim().equals(orgName)) {
				System.out.println("Org within contact is verified == PASS");
			} else {
				System.out.println("Org within contact is verified == FAIL");
			}

			System.out.println("createNewContWithOrgTest: EXECUTION SUCCESS");

}
}