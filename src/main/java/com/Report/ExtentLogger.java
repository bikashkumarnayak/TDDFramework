package com.Report;

import com.Enum.ConfigProperty;
import com.FrameworkConfig.Config;
import com.aventstack.extentreports.MediaEntityBuilder;

import ScreenShot.ScreenshotUtils;
import propertyfile.PropetyFile;

/*
 * Creating screenshot and attaching to report in Base64Encoding
 * create extend report
 */
public final class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String message) {

		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {

		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {

		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void pass(String Message,boolean isScreenshotNeeded) throws Exception {
		if(PropetyFile.get(ConfigProperty.PASSEDSCREENSHOT).equalsIgnoreCase(Config.getYes()) && isScreenshotNeeded) {
			ExtentManager.getExtentTest().
			pass(Message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(Message);
		}
	}
	public static void fail(String Message,boolean isScreenshotNeeded) throws Exception {
		if(PropetyFile.get(ConfigProperty.FAILEDSCREENSHOT).equalsIgnoreCase(Config.getYes()) && isScreenshotNeeded) {
			ExtentManager.getExtentTest().
			pass(Message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else
		fail(Message);
	}
	public static void skip(String Message,boolean isScreenshotNeeded) throws Exception {
		if(PropetyFile.get(ConfigProperty.SKIPPEDSCREENSHOT).equalsIgnoreCase(Config.getYes()) && isScreenshotNeeded) {
			ExtentManager.getExtentTest().
			pass(Message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			skip(Message);
		}
	}
	
	
}
