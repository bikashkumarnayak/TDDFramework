package com.Report;

import com.aventstack.extentreports.ExtentTest;

/*
 * To set, get and remove ExtentTest and manage Thread safety
 */
public final class ExtentManager {
	private ExtentManager() {
	}

	private static ThreadLocal<ExtentTest> et = new ThreadLocal<ExtentTest>();

	 static ExtentTest getExtentTest() {
		return et.get();
	}

	 static void setExtentTest(ExtentTest extentTestRef) {
		et.set(extentTestRef);
	}

	 static void unload() {
		et.remove();
	}
}
