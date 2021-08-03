
package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * This ConfigReader file will read the config file
 *
 */

public class ConfigReader {

	/**
	 * will read the properties file with this function
	 * 
	 * @param filePath
	 * @return
	 */
	public ConfigReader() {

	}

	public Properties loadPropertyFile(String filePath) {
		File file = new File(filePath);
		Properties prop = new Properties();

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			prop.load(fileInput);
		} catch (Exception e) {
			new LogUtil().errorLog(ConfigReader.class, "Caught the exception", e);
		}
		return prop;
	}

	/**
	 * will get sting value from properties file
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		Properties prop = loadPropertyFile("src/main/resources/ConfigFile/config.properties");
		return prop.getProperty(key);
	}

	/**
	 * will get int value from properties file
	 * 
	 * @param key
	 * @return
	 */
	public int getIntValue(String key) {
		Properties prop = loadPropertyFile("src/main/resources/ConfigFile/config.properties");
		String strKey = prop.getProperty(key);
		return Integer.parseInt(strKey);
	}

	public String getTDValue(String key) {
		Properties prop = loadPropertyFile("src/test/resources/testData/td.properties");
		return prop.getProperty(key);
	}

}