package setting;

import org.testng.annotations.Test;

import com.Driver.TestBase;
import com.Enum.CatagaryType;
import com.annotation.FrameworkAnnotation;

import pageObject.Loginpage;
import pageObject.Dashboard;

public class DashboardPage extends TestBase {
	
	Loginpage lo=new Loginpage();
	Dashboard d=new Dashboard();
	
	
	@FrameworkAnnotation(authors= {"Bikash"},category= {CatagaryType.REGRESSION})
	@Test(priority = 1)
	public void loginvalidation() throws Exception {
		lo.getUser().getPass();
	}
	
	@FrameworkAnnotation(authors = "bikash",category =CatagaryType.SANITY )
	@Test(priority=2)
	public void Dashboard_Test1() {
		d.getOrderDetails();
	}

}
