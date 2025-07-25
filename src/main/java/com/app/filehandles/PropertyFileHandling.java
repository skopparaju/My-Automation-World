package com.app.filehandles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileHandling {
	
	
	public String getProperty(String key) throws Exception   {
		
		
		FileReader reader = new FileReader(System.getProperty("user.dir")+"/src/main/resources/EnvironmentVariables.properties");
		
		Properties p = new Properties();
		
		p.load(reader);
		String value = p.getProperty(key);
		
		return value;
	}
	
	
	
	public void setProperty(String key,String value) {
		
		try {
			Properties properties = new Properties();
			properties.setProperty(key, value);



			File file = new File(System.getProperty("user.dir")+"/src/main/resources/EnvironmentVariables.properties");
			FileOutputStream fileOut = new FileOutputStream(file);
			//properties.store(fileOut, "Favorite Things");
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
