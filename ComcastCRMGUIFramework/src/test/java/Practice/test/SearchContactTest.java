package Practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoyutility.LoginPage;

/**
 * test class for Contact module
 * @author Preethi
 * 
 */

public class SearchContactTest extends BaseClass {
	
	/**
	 * login()==> navigateContact==>createcontact()==>verify
	 * @throws Throwable 
	 */
	
	@Test
	public void searchContactTest() throws Throwable
	{
		/*Step 1: login to app*/
	    LoginPage lp = new LoginPage(driver);
	    lp.loginToApp("url", "username", "password");
	}
	

}
