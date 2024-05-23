package Practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
@Listeners(com.comcast.crm.listenerUtility.ListImpClass.class)
public class InvoiceTest  extends BaseClass{
	// retry Analyser program
	@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImp.class)
	public void activateSim()
	{
		System.out.println("Execute createInvoiceTest ");
		Assert.assertEquals("", "Login");
		 System.out.println("Test-1");
		 System.out.println("Test-2");
		 System.out.println("Test-3");
		 System.out.println("Test-4");
	}
	

//	@Test
//	public void createInvoiceTest()
//	{
//		System.out.println("Execute createInvoiceTest ");
//		String actTitle = driver.getTitle();
//		Assert.assertEquals(actTitle, "Login");
//		 System.out.println("Test-1");
//		 System.out.println("Test-2");
//		 System.out.println("Test-3");
//		 System.out.println("Test-4");
//	}
	
	@Test
	public void createInvoiceWithContact()
	{
		System.out.println("Execute createInvoiceWithContact");
		System.out.println("Test-1");
		 System.out.println("Test-2");
		 System.out.println("Test-3");
		 System.out.println("Test-4");
		
	}
	
}
