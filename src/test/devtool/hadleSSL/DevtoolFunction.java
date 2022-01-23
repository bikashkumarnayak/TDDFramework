package hadleSSL;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.emulation.Emulation;
import org.openqa.selenium.devtools.v95.security.Security;

import com.Driver.DriverManager;

public final class DevtoolFunction {

	static DevTools devtool=((ChromeDriver)DriverManager.getDriver()).getDevTools();
	public static DevTools SSLCeritificate() {
		devtool.send(Security.enable());
		devtool.send(Security.setIgnoreCertificateErrors(true));
		return devtool;
	}
	public static DevTools getGeoLocation(int lat,int longitude) {
		devtool.createSession();
		devtool.send(Emulation.setGeolocationOverride(Optional.of(lat),Optional.of(longitude)
				,Optional.of(1)));
		return devtool;
	}
	
}
