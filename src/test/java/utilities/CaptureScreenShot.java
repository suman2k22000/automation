package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class CaptureScreenShot {
	
	public static void captureScreenShot(WebDriver driver, String fileName) {
		fileName = fileName + ".png";
		String dir = System.getProperty("user.dir") + File.separator + "target/Screenshots";
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenshot, new File(dir + File.separator + fileName));
		} catch (IOException e) {
			System.out.println("Failed to copy screenshot file");
			e.printStackTrace();
		}		
	}

}
