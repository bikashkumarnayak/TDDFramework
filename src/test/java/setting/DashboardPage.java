package setting;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Driver.TestBase;
import com.Enum.CatagaryType;
import com.annotation.FrameworkAnnotation;
import com.data.TestData;

import pageObject.Loginpage;
import pageObject.Dashboard;

public class DashboardPage extends TestBase {
	
	Loginpage lo=new Loginpage();
	Dashboard d=new Dashboard();
	
	
	@FrameworkAnnotation(authors= {"Bikash"},category= {CatagaryType.REGRESSION})
	@BeforeTest
	public void loginvalidation() throws Exception {
		lo.getUser(TestData.getUsername()).getPass(TestData.getPassword());
	}
	
	@FrameworkAnnotation(authors = "bikash",category =CatagaryType.SANITY )
	@Test(priority=1)
	public void Dashboard_Test1() {
		d.getOrderDetails();
	}

}
