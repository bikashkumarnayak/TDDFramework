package com.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.Driver.DriverManager;

public final class FluentWaitexecution {

	private FluentWaitexecution() {
		
	}
	public static void fluentWait(By by) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriver())
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);

				 wait.until(new Function<WebDriver, WebElement>() {
				  public WebElement apply(WebDriver driver) {
				    return driver.findElement(by);
				  }
				});
	}
}
