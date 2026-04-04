package day20ddttesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readingpropertiesfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties prop=new Properties();
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
      //loading the file
		prop.load(fs);
		
		//reading data from file
		String url=prop.getProperty("appurl");
		String eml=prop.getProperty("email");
		String pwd=prop.getProperty("password");
		String oid=prop.getProperty("orderid");
		String cid=prop.getProperty("customerid");

		System.out.println(url+" "+eml+" "+pwd+" "+oid+" "+cid);
		/*
		 * Set<String> ke=prop.stringPropertyNames(); prints all yhe key values
		 * set<Object> val=prop.keySet(); 
		 * prop.values();  prints all the values
		 */
		fs.close();
		
	}

}
