package com.Factory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Driver.DriverManager;
import com.Enum.ConfigProperty;
import com.FrameworkConfig.Config;

public class ExplicityWaitFactory {
	static WebElement element=null;
	@SuppressWarnings("deprecation")
	public static WebElement performExplecityWait(ConfigProperty wait,By by) {
		if(wait==ConfigProperty.CLICKABLE) {
		element=	new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(Config.getExplecitywait()))
			.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(wait==ConfigProperty.PRESENCE) {
			element=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(Config.getExplecitywait()))
			.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(wait==ConfigProperty.VISIBLE) {
		element=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(Config.getExplecitywait()))
			.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		return element;
	}

}
