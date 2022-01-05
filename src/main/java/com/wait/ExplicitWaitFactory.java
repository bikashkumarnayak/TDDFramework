package com.wait;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Driver.DriverManager;
import com.FrameworkConfig.Config;


/*
 * Managing different explicit wait and returning webElement to perform action on it
 */
public final class ExplicitWaitFactory {

	private ExplicitWaitFactory() {
	}

	public static WebElement explicitWaitForElementToBeClickable(By by) {
		return new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(Config.getExplecitywait()))
				.until(ExpectedConditions.elementToBeClickable(by));
	}

	public static WebElement explicitWaitForElementToBePresent(By by) {
		return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Config.getExplecitywait()))
				.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	public static WebElement explicitWaitForElementToBeVisiable(By by) {
		return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Config.getExplicitywait()))
				.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	public static List<WebElement> explicitywaitforvisibilityOfAllElements(By by) {
		return new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(Config.getExplicitywait()))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));		
	}
	public static void ExplecityWait(By by) {
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Config.getExplicitywait()))
		.until(d->{
			if(d.findElements(by).isEmpty()) {
				return d.findElements(by).get(0);
			}else {
				d.navigate().refresh();
			return	d.findElement(by);
			}
			
		});
	}
}