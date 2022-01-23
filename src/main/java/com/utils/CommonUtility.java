package com.utils;

import org.openqa.selenium.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Driver.DriverManager;
import com.wait.ExplicitWaitFactory;



public class CommonUtility extends LocaterFactory {

	Actions action;
	JavascriptExecutor js;
	protected WebElement findelement(By by) {
		WebElement element=DriverManager.getDriver().findElement(by);
		return element;
	}
	protected List<WebElement> findelements(By by){
		List<WebElement> element=DriverManager.getDriver().findElements(by);
		return element;
	}

	protected void border(By by) {
		js = ((JavascriptExecutor) DriverManager.getDriver());
		js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 4px solid red;');",
				DriverManager.getDriver().findElement(by));
	}

	protected void scroll(By by) {
		js = ((JavascriptExecutor) DriverManager.getDriver());
		js.executeScript("arguments[0].scrollIntoView();", DriverManager.getDriver().findElement(by));
	}

	protected void frame(By by) {
		DriverManager.getDriver().switchTo().frame(DriverManager.getDriver().findElement(by));
	}

	protected void selectAction(By by) throws Exception {
		action = new Actions(DriverManager.getDriver());
		ExplicitWaitFactory.explicitWaitForElementToBeVisiable(by);
		action.moveToElement(DriverManager.getDriver().findElement(by)).build().perform();

	}

	protected void clickAction(By by) throws Exception {
		action = new Actions(DriverManager.getDriver());
		ExplicitWaitFactory.explicitWaitForElementToBeClickable(by);
		action.moveToElement(DriverManager.getDriver().findElement(by)).click().build().perform();
	}

	protected Boolean errormessage(By by) {
		js = ((JavascriptExecutor) DriverManager.getDriver());
		return (Boolean) js.executeScript("return arguments[0].checkValidity();",
				DriverManager.getDriver().findElement(by));
	}

	protected String printerrormessage(By by) {
		js = ((JavascriptExecutor) DriverManager.getDriver());
		return (String) js.executeScript("return arguments[0].validationMessage;",
				DriverManager.getDriver().findElement(by));

	}

	private Select getSelectWebElement(By by) {
		Select select = new Select(DriverManager.getDriver().findElement(by));
		return select;
	}

	protected void wait(By by, int milliSeconds) {
		try {
			DriverManager.getDriver().findElement(by).wait(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	protected TargetLocator allswitchTo(Consumer<TargetLocator> consumer) {
		TargetLocator element=DriverManager.getDriver().switchTo();
		consumer.accept(element);
		return element;
	}
	protected Alert alert(Consumer<Alert> consumer) {
		Alert alert=DriverManager.getDriver().switchTo().alert();
		consumer.accept(alert);
		return alert;
	}

	protected void click(By by) throws Exception {
		ExplicitWaitFactory.explicitWaitForElementToBeVisiable(by);
		DriverManager.getDriver().findElement(by).click();
	}

	protected void clear(By by) throws Exception {
		ExplicitWaitFactory.explicitWaitForElementToBeVisiable(by);
		DriverManager.getDriver().findElement(by).clear();
	}

	protected void sendKeys(By by, String value) throws Exception {
		ExplicitWaitFactory.explicitWaitForElementToBeVisiable(by);
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}

	protected String getText(By by) throws Exception {
		ExplicitWaitFactory.explicitWaitForElementToBeVisiable(by);
		String text = DriverManager.getDriver().findElement(by).getText();
		return text;
	}

	protected boolean isDisplayed(By by) {
		return DriverManager.getDriver().findElement(by).isDisplayed();
	}

	protected boolean isSelected(By by) {
		return DriverManager.getDriver().findElement(by).isSelected();
	}

	protected boolean isEnabled(By by) {
		return DriverManager.getDriver().findElement(by).isEnabled();
	}

	protected WebElement getWebElement(By by) {
		return DriverManager.getDriver().findElement(by);
	}

	protected List<WebElement> getAllElements(By by) {
		return DriverManager.getDriver().findElements(by);
	}

	protected boolean isAllElemetsEmpty(By by) {
		return DriverManager.getDriver().findElements(by).isEmpty();
	}

	protected int getSize(By by) {
		return findelements(by).size();
	}

	protected boolean isStringContains(By by, String value) {
		return DriverManager.getDriver().findElement(by).getText().contains(value);
	}

	protected boolean isStringEquals(By by, String value) {
		return DriverManager.getDriver().findElement(by).getText().equals(value);
	}

	protected boolean isStringEqualsIgnoreCase(By by, String value) {
		return DriverManager.getDriver().findElement(by).getText().equalsIgnoreCase(value);
	}

	protected Select selectDropDown(By by, Consumer<Select> consumer) {
		Select select=getSelectWebElement(by);
//		Select select = new Select(DriverManager.getDriver().findElement(by));
		consumer.accept(select);
		return select;
	
	}
	protected void Windowhandle(){
		Set<String> win=DriverManager.getDriver().getWindowHandles();
		Iterator<String> it=win.iterator();
		DriverManager.getDriver().switchTo().window(it.next());	
	}
	protected void widowhandle_By_index(int indexnumber) {
		List<String> ListofWindow=new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
		DriverManager.getDriver().switchTo().window(ListofWindow.get(indexnumber));
	}
	protected void Widowhandle_by_title() {
		String excepted=DriverManager.getDriver().getTitle();
		List<String> ListofWindow=new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
		for (String win : ListofWindow) {
		String actule=DriverManager.getDriver().getTitle();
		if(excepted.equals(actule)) {
			DriverManager.getDriver().switchTo().window(win);
			break;
		}
		}
		
	}
	protected Rectangle getrect(By by) {
		Rectangle rect=findelement(by).getRect();
		rect.getX();
		rect.getY();
		rect.getHeight();
		rect.getWidth();
		return rect;
	}

}
