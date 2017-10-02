package utilities;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	
	public static ExtentReports getInstance() {
		ExtentReports report;
		
		String path = System.getProperty("user.dir") + File.separator + "target/Reports.html";
		
		report = new ExtentReports(path);
		return report;
	}

}
