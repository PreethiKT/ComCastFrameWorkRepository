package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseUtility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoyutility.HomePage;
import com.comcast.crm.objectrepositoyutility.LoginPage;

public class BaseClass {

	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility ();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() throws SQLException {
		System.out.println("====Connect to DB , Report Config====");
		dbLib.getDbconnection();
	}
    // @Parameters("BROWSER")
//	@BeforeClass(groups = {"smokeTest","regressionTest"})
//	public void configBC(String Browser) throws Throwable {
//		System.out.println("==Launch the Browser==");
//  	String BROWSER =Browser; //fLib.getDataFromPropertiesFile("Browser");
//
//		if (BROWSER.equals("edge")) {
//			driver = new EdgeDriver();
//		} else if (BROWSER.equals("Chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equals("FireFox")) {
//			driver = new FirefoxDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//
//	}
	
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Throwable {
		System.out.println("==Launch the Browser==");
  	String BROWSER =fLib.getDataFromPropertiesFile("Browser");

		if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("FireFox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
        sdriver = driver;
	}

	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("=Login=");
		String URL = fLib.getDataFromPropertiesFile("Url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(alwaysRun=true)
	public void configAM() {
		System.out.println("=Logout=");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("==close the Browser==");
		driver.quit();

	}

	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws Throwable {
		System.out.println("====Close DB , Report backup====");
		dbLib.closeDbconnection();
	}
	

}
