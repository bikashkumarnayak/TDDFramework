package propertyfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.Enum.ConfigProperty;
import com.FrameworkConfig.Config;

public final class PropetyFile {

	private PropetyFile() {

	}
	private static Properties prop=new Properties();
	private static final Map<String,String> CONFIGMAP=new HashMap<>();
	
	static {
		try {
			File file=new File(Config.getConfigproperty());
			FileInputStream fs=new FileInputStream(file);
			prop.load(fs);
			for (Map.Entry<Object, Object> entry : prop.entrySet()) {
				
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static String get(ConfigProperty key) throws Exception {
		if(Objects.isNull(key.name().toLowerCase()) ||Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property Name" + key +" is not found");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
	public static String getValue(String key) throws Exception {
		
		if(Objects.isNull(key) ||Objects.isNull(key)) {
			throw new Exception("Property Name" + key +" is not found");
		}
		return prop.getProperty(key);
	}

}
