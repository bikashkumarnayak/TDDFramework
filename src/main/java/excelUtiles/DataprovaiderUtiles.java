package excelUtiles;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;
import com.FrameworkConfig.Config;

public final class DataprovaiderUtiles {

	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider
	public static Object[] getData(Method m) {
		String TestName = m.getName();
		if (list.isEmpty()) {
			list = ExcelUtils.getDataDeatils("Location");
		}
		List<Map<String, String>> smalllist = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("TestName").equalsIgnoreCase(TestName)
					&& list.get(i).get("execute").equalsIgnoreCase(Config.getYes())) {
				smalllist.add(list.get(i));
			}
		}

		return smalllist.toArray();
	}

}
