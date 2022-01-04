package com.Driver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	@BeforeTest
	public void beforeIntialization() throws Exception {
		Driver.initDriver();
	}
	@AfterTest
	public void threadDown() {
		Driver.quitDriver();
	}

}
