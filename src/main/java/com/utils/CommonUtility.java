package com.utils;

import org.openqa.selenium.Rectangle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Navigation;
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
		//allswitchTo(e->e.window(ListofWindow.get(indexnumber)));
	}
	protected void Widowhandle_by_title() {
		String excepted=DriverManager.getDriver().getTitle();
		List<String> ListofWindow=new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
		for (String win : ListofWindow) {
		String actule=DriverManager.getDriver().getTitle();
		if(excepted.equals(actule)) {
			allswitchTo(e->e.window(win));
			break;
			
		}
		}
		
	}
	protected  Rectangle getrect(By by,Consumer<Rectangle> consumer) {
		Rectangle rect=findelement(by).getRect();
		consumer.accept(rect);
		return rect;
	}
	protected Navigation Navigate(Consumer<Navigation> consumer) {
		Navigation nav= DriverManager.getDriver().navigate();
		consumer.accept(nav);
		return nav;
	}
	public void calender_handle(String tdate,String dateformat,By fild,By text,String act_dateFormat,By prv_buttton,By next_button ) throws Exception {
		Calendar calender=Calendar.getInstance();
		String targetdate=tdate;
		SimpleDateFormat targetDateformate=new SimpleDateFormat(dateformat);
		Date Formatedate;
		try {
			targetDateformate.setLenient(false);
			Formatedate=targetDateformate.parse(targetdate);
			calender.setTime(Formatedate);
			int targetDay=calender.get(Calendar.DAY_OF_MONTH);
			int targetmonth=calender.get(Calendar.MONTH);
			int targetyear=calender.get(Calendar.YEAR);
			click(fild);
			String todaydate=getText(text);
			calender.setTime(new SimpleDateFormat(act_dateFormat).parse(todaydate));
			int actualmonth=calender.get(Calendar.MONTH);
			int actualyear=calender.get(Calendar.YEAR);
			System.out.println(targetyear);
			if(targetyear<actualyear) {
			while(targetmonth<actualmonth || targetyear<actualyear) {
				click(prv_buttton);
				todaydate=getText(text);
				calender.setTime(new SimpleDateFormat(act_dateFormat).parse(todaydate));
				actualmonth=calender.get(Calendar.MONTH);
				actualyear=calender.get(Calendar.YEAR);	
			}	
			}
			else {
				while(targetmonth>actualmonth || targetyear>actualyear) {
					click(next_button);
					todaydate=getText(text);
					calender.setTime(new SimpleDateFormat(act_dateFormat).parse(todaydate));
					actualmonth=calender.get(Calendar.MONTH);
					actualyear=calender.get(Calendar.YEAR);	
				}	
			}
			List<WebElement> dates=DriverManager.getDriver().findElements(By.xpath("//*[@class='ui-datepicker-calendar']"
					+ "//a[not(contains(@class,'ui-state-default ui-priority-secondary'))]"));
			for (WebElement date : dates) {
				String actdate=date.getText();
				int da=Integer.parseInt(actdate);
				if(da==targetDay) {
				date.click();
				break;
				
				}
				
			}
			
		} catch (ParseException e) {
			throw new Exception("Invalide date is provaided,Please check into that");
		}
	}

}
