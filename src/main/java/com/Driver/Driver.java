package com.Driver;

import java.net.URL;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.Enum.ConfigProperty;
import com.FrameworkConfig.Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import propertyfile.Jsonutiles;
import propertyfile.PropetyFile;

public final class Driver {

	static DesiredCapabilities cap;

	private Driver() {

	}

	public static void initDriver() throws Exception{

		WebDriver driver=null;
		String remort=PropetyFile.get(ConfigProperty.RUNMODE);
		String browserName = PropetyFile.get(ConfigProperty.BROWSER);
		if (Objects.isNull(DriverManager.getDriver())) {
			
			if (browserName.equalsIgnoreCase(Config.getChrome())) {

				if (remort.equalsIgnoreCase("remote")) {
					cap = new DesiredCapabilities();
					cap.setBrowserName(BrowserType.CHROME);
					driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				} else {
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					DriverManager.setDriver(driver);
				}

			} else if (browserName.equalsIgnoreCase(Config.getFirefox())) {
				if (remort.equalsIgnoreCase("remote")) {
					cap = new DesiredCapabilities();
					cap.setBrowserName(BrowserType.FIREFOX);
					driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				} else {
					WebDriverManager.firefoxdriver().setup();
					DriverManager.setDriver(new FirefoxDriver());
				}
			} else if (browserName.equalsIgnoreCase(Config.getIe())) {
				if (remort.equalsIgnoreCase("remote")) {
					cap = new DesiredCapabilities();
					cap.setBrowserName(BrowserType.IE);
					driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				} else {
					WebDriverManager.iedriver().setup();
					driver=new InternetExplorerDriver();
					DriverManager.setDriver(driver);
				}
			}
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Config.getExplecitywait()));
			try {
				DriverManager.getDriver().get(Jsonutiles.get(ConfigProperty.URL));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
