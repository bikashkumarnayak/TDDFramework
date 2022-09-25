package setting;

import org.testng.annotations.Test;

import com.Driver.TestBase;
import com.Enum.CatagaryType;
import com.annotation.FrameworkAnnotation;
import com.dataProvaider.DataprovaiderTestData;

import PageObjectModule.LogInValidation;




public class login extends TestBase {

	
	private LogInValidation lo=new LogInValidation();
	
//	@FrameworkAnnotation(authors= {"Bikash"},category= {CatagaryType.REGRESSION})
	@Test(dataProvider = "nopcommerce",dataProviderClass = DataprovaiderTestData.class)
	public void loginvalidation(String username,String password) throws Exception {
		lo.getUser(username).getPass(password);
	}
}
