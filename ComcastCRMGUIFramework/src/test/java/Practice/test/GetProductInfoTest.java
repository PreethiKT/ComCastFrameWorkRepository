package Practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
	
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName , String productName)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://amazon.in");
		
		//Search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		String x = "//span[text()='"+productName+"']/../../../../div[3]/div/div/div/div[1]/div/a/span/span[2]/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);	
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		
		ExcelUtility eLib = new ExcelUtility();
		int rowcount = eLib.getRowcount1("product");
		Object[][] objArr = new Object[rowcount][2];
		
	for(int i=0; i<rowcount; i++)
	{		objArr [i][0] = eLib.getDataFromExcel("product", i+1, 0);
		    objArr [i][1] = eLib.getDataFromExcel("product", i+1, 1);
	}
		return objArr;
	}
}
