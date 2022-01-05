package com.Driver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import pageObject.Loginpage;

public class TestBase {
	
	@BeforeTest
	public void beforeIntialization() throws Exception {
		Driver.initDriver();
	}
	@AfterTest
	public void threadDown() {
		Driver.quitDriver();
	}
	@BeforeClass
	public void login() throws Exception {
		Loginpage lo=new Loginpage();
		lo.getUser().getPass();
	}

}
