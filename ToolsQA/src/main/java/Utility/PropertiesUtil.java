package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	final static String configPropertiesFilePath = System.getProperty("user.dir")
			+ "\\src\\test\\java\\DummyFramework\\Properties" + "\\config.properties";

	public static String read(String x) throws IOException {
		FileInputStream fis = new FileInputStream(new File(configPropertiesFilePath));
		Properties prop = new Properties();
		prop.load(fis);		
		String p =prop.getProperty(x);
		System.out.println(p);
		return (p);
	}
}
