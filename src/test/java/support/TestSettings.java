package support;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import pageobjects.GoogleApp;
import utilities.CaptureScreenShot;
import utilities.ExtentFactory;

public class TestSettings {

	private WebDriver driver;
	protected GoogleApp google;
	protected Browsers eBrowser;
	protected ExtentReports report;
	protected ExtentTest test;
	/*
	@BeforeClass(alwaysRun = true)
	public void Reporter() {
		report = ExtentFactory.getInstance();
		test = report.startTest("Test Started");
	}
	*/
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("firefox") String browser) {
		report = ExtentFactory.getInstance();
		test = report.startTest("Test Started");
		
		
		if(browser.toLowerCase().contains("firefox")) {
			eBrowser = Browsers.FIREFOX;
		} else if (browser.toLowerCase().contains("chrome")) {
			eBrowser = Browsers.CHROME;
		} else if (browser.toLowerCase().contains("ie")) {
			eBrowser = Browsers.IE;
		}
		
		switch (eBrowser) {
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + File.separator + "geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			break;
		case CHROME:
			break;
		default:
			break;
		}

	}
	
	@AfterMethod(alwaysRun = true)
	public void takeScreenShot(ITestResult testResult) {
		
		System.out.println(testResult.getName() + " : " + testResult.getStatus());
		
		if (testResult.getStatus() == ITestResult.FAILURE) {
			
			DateFormat formattedDate = new SimpleDateFormat("dd-MMM-yyyy-HH-mm-ss");
			String dateTime = formattedDate.format(new Date());
			
			CaptureScreenShot.captureScreenShot(driver,
					testResult.getName() + "_" + dateTime);
			test.log(LogStatus.FAIL, "Failed");
		} else if (testResult.getStatus()==ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "Passed");
		}
		
		report.endTest(test);
		report.flush();
		
		driver.quit();
	}
	/*
	@AfterClass(alwaysRun = true)
	public void teardown() {
		report.endTest(test);
		report.flush();
		//driver.quit();
	}
	*/
	public void goToGoogle() {
		driver.get("https://www.google.com");
		google = new GoogleApp(driver);
	}

}
