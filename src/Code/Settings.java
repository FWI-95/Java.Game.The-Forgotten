package Code;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class Settings {
	
	static Properties prop;
	
	public Settings(){
		prop = new Properties();
		
		try{
		InputStream in = getClass().getResourceAsStream("/Settings/settings.properties");
		
		prop.load(in);
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		if(!prop.containsKey("Version")){
			createSettings();
		}
	}
	
	public void createSettings(){
		prop.setProperty("Version", "1");
		prop.setProperty("language", "1");
		prop.setProperty("resx", "800");
		prop.setProperty("resy", "600");
		
		saveSettings();
	}
	
	public void saveSettings(){
		URL resourceUrl = getClass().getResource("/Settings/settings.properties");
		File file;
		try {
			file = new File(resourceUrl.toURI());
			OutputStream output = new FileOutputStream(file);
			prop.store(output, "auto generated");
		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	
	
	
	public String getSetting(String setting){
		return prop.getProperty(setting);
		
	}
	
	public void setSetting(String setting, String value){
		prop.setProperty(setting, value);
	}
}
