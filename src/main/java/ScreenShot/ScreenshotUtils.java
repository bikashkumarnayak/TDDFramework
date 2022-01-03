package ScreenShot;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Driver.DriverManager;
import com.FrameworkConfig.Config;

public final class ScreenshotUtils {
	private ScreenshotUtils() {
	}
	
	public static String getBase64Image() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
		
	}
	
	
	public static File getScreenshot(String result) throws IOException {
		File scr=((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr, new File(Config.getScreenshotpath()+result+Config.getScreenshotformat()));
		return scr;
		
	}
	
}
