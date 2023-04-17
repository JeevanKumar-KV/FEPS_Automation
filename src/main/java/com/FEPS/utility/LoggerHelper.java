package com.FEPS.utility;

/**
 * Author : Jeevan Kumar K V
 * Email id  : jeevankumar.kv@conduent.com
 */
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



@SuppressWarnings("rawtypes")
public class LoggerHelper {
	
	private static boolean root = false;
	
	public static Logger getLogger(Class clas) {
		if(root)
			return Logger.getLogger(clas);
			
		try {
			
			PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/main/resources/configFile/log4j.properties");
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		root = true;
		return Logger.getLogger(clas);
	}

}
