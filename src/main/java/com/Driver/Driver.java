package com.Driver;

import java.net.URL;
import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.Enum.ConfigProperty;
import com.FrameworkConfig.Config;
import com.propertyfile.Jsonutiles;
import com.propertyfile.PropetyFile;

import devToolsMethod.DevtoolFunction;
import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")
public final class Driver {

	static DesiredCapabilities cap;

	private Driver() {

	}

	
	public static void initDriver() throws Exception {

//		WebDriver driver = null;
		@SuppressWarnings("unused")
		String remort = PropetyFile.get(ConfigProperty.RUNMODE);
		String browserName = PropetyFile.get(ConfigProperty.BROWSER);
		if (Objects.isNull(DriverManager.getDriver())) {

			switch (browserName) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
				break;
			case "remort":
				cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				break;
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

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
