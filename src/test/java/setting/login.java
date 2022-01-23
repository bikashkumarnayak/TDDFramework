package setting;

import org.testng.annotations.Test;

import com.Driver.TestBase;
import com.Enum.CatagaryType;
import com.annotation.FrameworkAnnotation;


import pageObject.Loginpage;

public class login extends TestBase {

	
	Loginpage lo=new Loginpage();
	@FrameworkAnnotation(authors= {"Bikash"},category= {CatagaryType.REGRESSION})
	@Test
	public void loginvalidation() throws Exception {
		lo.getUser().getPass();
	}
}
