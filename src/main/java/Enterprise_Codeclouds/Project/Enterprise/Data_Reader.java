package Enterprise_Codeclouds.Project.Enterprise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Data_Reader {
	
	
	public String Data_Fetcher(String Key) throws IOException {
		System.out.println("Config path: " + System.getProperty("user.dir") + "\\src\\main\\java\\Data\\data.properties");
	    FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Data\\data.properties");
        Properties prop = new Properties();
	    prop.load(f);
	    return prop.getProperty(Key);}
}
