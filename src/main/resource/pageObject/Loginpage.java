package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

import com.data.TestData;
import com.utils.CommonUtility;

public final class Loginpage extends CommonUtility {

	private By user = By.xpath("//input[@id='Email']");
//	private By pass = By.xpath("//input[@id='Password']");
	private By pass=RelativeLocator.with(By.tagName("input")).below(user);
	private By login=By.cssSelector("button[type='submit']");


	public Loginpage getUser(String username) throws Exception {		
		clear(user);
//		sendKeys(user, TestData.getUsername());
		sendKeys(user, username);
		return this;
	}

	public Loginpage getPass(String password) throws Exception {
		clear(pass);
		Thread.sleep(500);
//		sendKeys(pass, TestData.getPassword());
		sendKeys(pass, password);
		Thread.sleep(500);
		click(login);
		return this;
	}

}
