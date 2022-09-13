package com.Driver;

import java.net.URL;
import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.Enum.ConfigProperty;
import com.FrameworkConfig.Config;
import com.propertyfile.Jsonutiles;
import com.propertyfile.PropetyFile;

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
		ChromeOptions option=new ChromeOptions();
		option.setHeadless(true);
		if (Objects.isNull(DriverManager.getDriver())) {

			switch (remort) {
			case "chrome":
				DriverManager.setDriver(WebDriverManager.chromedriver().create());
				break;
			case "firefox":
				DriverManager.setDriver(WebDriverManager.firefoxdriver().create());
				break;
			case "Headless_Chrome":
				DriverManager.setDriver(WebDriverManager.chromedriver().capabilities(option).create());
				break;
			case "Headless_Firefox":
				
				DriverManager.setDriver(WebDriverManager.firefoxdriver().capabilities(option).create());
				break;
			case"RemortChrome":
				cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				new RemoteWebDriver(new URL("http://localhost:4455/wd/hub"), cap);
				break;
			case "parallel":
				cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
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

	static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
