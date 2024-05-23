package Practice.test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport {
	
	public class SampleReportTest {
		ExtentReports report;

		public void configBS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		// add env information &create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
		}

		@AfterSuite
		public void configAS() {
		report.flush();
		}

		@Test
		public void createContact() {
		// spark report config
		           WebDriver driver=new ChromeDriver();
		           driver.get("http://localhost:8881");
		           TakesScreenshot tse = (TakesScreenshot)driver;
		      String src=     tse.getScreenshotAs(OutputType.BASE64);
		     // File desc=new File(/.)



		ExtentTest test = report.createTest("createContact");
		
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "Create Contact");
		if("HDFC".equals("HDFC")) {
		test.log(Status.PASS, "Contact is created");
		}else {
			test.log(Status.FAIL, "Contact is created");	
		}
		//report.flush();
		//System.out.println("login to app");
		
		}
		}
		}


