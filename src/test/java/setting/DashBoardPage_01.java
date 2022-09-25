package setting;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Driver.TestBase;
import com.data.TestData;

import PageObjectModule.DashBoardPage;
import PageObjectModule.LogInValidation;

public class DashBoardPage_01 extends TestBase  {
	private DashBoardPage dp=new DashBoardPage();
	private LogInValidation lo=new LogInValidation();
	 @BeforeTest
	 public void loginvalidation() throws Exception {
		 lo.getUser(TestData.getUsername());
		 lo.getPass(TestData.getPassword());
	  }

//
  @Test
  public void Dashboard_Test1() {
	  dp.getOrderDetails();
	}
 
}
