package hadleSSL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.security.Security;

import com.Driver.DriverManager;

public class DevtoolFunction {

	public static void SSLCeritificate() {
		DevTools devtool=((ChromeDriver)DriverManager.getDriver()).getDevTools();
		devtool.send(Security.enable());
		devtool.send(Security.setIgnoreCertificateErrors(true));
	}
}
