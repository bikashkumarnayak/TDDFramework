package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

import com.data.TestData;

import utils.CommonUtility;

public final class Loginpage extends CommonUtility {

	private By user = By.xpath("//input[@id='Email']");
//	private By pass = By.xpath("//input[@id='Password']");
	private By pass=RelativeLocator.with(By.tagName("input")).below(user);
	private By login=By.cssSelector("button[type='submit']");

	public Loginpage getUser() throws Exception {
		clear(user);
		sendKeys(user, TestData.getUsername());
		return this;
	}

	public Loginpage getPass() throws Exception {
		clear(pass);
		Thread.sleep(500);
		sendKeys(pass, TestData.getPassword());
		Thread.sleep(500);
		click(login);
		return this;
	}

}
