package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class ConfigDataProvider {
	Properties prop;
	public ConfigDataProvider() {
		File file=new File("src/main/resources/config/config.properties");
		try {
			FileInputStream fs=new FileInputStream(file);
			prop=new Properties();
			prop.load(fs);
		}catch(Exception e){
			System.out.println("Not able to find the file"+e.getMessage());
			
		}
	}
	public String getBrowser() {
		return prop.getProperty("browser");
		
	}
	public String getUrl() {
		return prop.getProperty("url");
		
	}
	public String getValue(String tosearch) {
		return prop.getProperty("tosearch");
		
	}

}
