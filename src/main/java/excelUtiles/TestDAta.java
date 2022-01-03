package excelUtiles;

import java.util.Map;

import org.testng.annotations.Test;

public class TestDAta {

	@Test(dataProvider = "getData",dataProviderClass =DataprovaiderUtiles.class)
	public void Testfild(Map<String, String> map) {
		System.out.println(map.get("username"));
	}
}
