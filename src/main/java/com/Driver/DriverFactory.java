package com.Driver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.Enum.ConfigProperty;
import com.FrameworkConfig.Config;
import com.propertyfile.PropetyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	static DesiredCapabilities cap;
	 
	private DriverFactory() {
		
	}
	
	public static WebDriver getDriver(String browserName) throws Exception {
		WebDriver driver=null;
		String remort=PropetyFile.get(ConfigProperty.RUNMODE);
//		String browserName = PropetyFile.get(ConfigProperty.BROWSER);
		if (browserName.equalsIgnoreCase(Config.getChrome())) {

			if (remort.equalsIgnoreCase("remote")) {
				cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} else {
				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
			}

		} else if (browserName.equalsIgnoreCase(Config.getFirefox())) {
			if (remort.equalsIgnoreCase("remote")) {
				cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hb"), cap);
			} else {
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			}
		} else if (browserName.equalsIgnoreCase(Config.getIe())) {
			if (remort.equalsIgnoreCase("remote")) {
				cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.IE);
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hb"), cap);
			} else {
				WebDriverManager.iedriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			}
		}
		return driver;
	}
}
