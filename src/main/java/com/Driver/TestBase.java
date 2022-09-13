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
	/*@BeforeClass
	public void login() throws Exception {
		Loginpage lo=new Loginpage();
		lo.getUser().getPass();
		Thread.sleep(3000);
	}*/

}
