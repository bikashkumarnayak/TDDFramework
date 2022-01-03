package com.listiner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.Enum.ConfigProperty;
import com.FrameworkConfig.Config;

import propertyfile.PropetyFile;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count=0;
	private int retries=1;
	@Override
	public boolean retry(ITestResult result) {
		boolean value=false;
		try {
			if(PropetyFile.get(ConfigProperty.RETRYFAILEDTESTCASES).equals(Config.getYes())) {
			 value=count<retries;
			count++;
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return value;
	}

}
