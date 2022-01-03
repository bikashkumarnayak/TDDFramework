package propertyfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.Enum.ConfigProperty;
import com.FrameworkConfig.Config;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jsonutiles {
	private static Map<String, String> CONFIGMAP;
	
	private Jsonutiles() {
		
	}
	static {
		try {
			CONFIGMAP=new ObjectMapper().readValue(new File(Config.getJsonpath()),new TypeReference<HashMap<String ,String>>(){});
			
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String get(ConfigProperty key) throws Exception {
		if(Objects.isNull(key.name().toLowerCase()) ||Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property Name" + key +" is not found.Please found the property");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
