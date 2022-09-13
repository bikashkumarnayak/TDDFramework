package setting;

import org.testng.annotations.Test;

import com.Driver.TestBase;
import com.Enum.CatagaryType;
import com.annotation.FrameworkAnnotation;
import com.dataProvaider.DataprovaiderTestData;

import pageObject.Loginpage;

public class login extends TestBase {

	
	Loginpage lo=new Loginpage();
	@FrameworkAnnotation(authors= {"Bikash"},category= {CatagaryType.REGRESSION})
	@Test(dataProvider = "nopcommerce",dataProviderClass = DataprovaiderTestData.class)
	public void loginvalidation(String username,String password) throws Exception {
		lo.getUser(username).getPass(password);
	}
}
