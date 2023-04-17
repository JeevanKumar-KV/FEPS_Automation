package com.FEPS.utility;

/**
 * Author : JeevanKumar K V
 * Email id  : jeevankumar.kv@conduent.com
 */

import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.IOException;


public  class ReportPortal {

	public static void updateReportPortalPropertiesFile() throws ConfigurationException {

		String TestType=System.getProperty("platform").equalsIgnoreCase("local")?"API":"UI";
		String OS=System.getProperty("bsDevice").equalsIgnoreCase("windows")
				?System.getProperty("bsDesktopOS").toUpperCase()
				:System.getProperty("bsMobileOS").toUpperCase();
		String TestSuite=System.getProperty("platform").equalsIgnoreCase("local")
				?System.getProperty("environment").toUpperCase()+"_"+TestType
				:System.getProperty("environment").toUpperCase()+"_"+TestType+"_"+System.getProperty("bsDevice").toUpperCase()+"_"+OS;


		PropertiesConfiguration config = new PropertiesConfiguration(System.getProperty("user.dir") + "/src/test/resources/reportportal.properties");
		config.setProperty("rp.project", " arbys_automation_testing");
		config.setProperty("rp.launch", " "+TestSuite+"_RESULTS" );
		config.setProperty("rp.testsuite", " "+TestSuite + DateTimeHelper.getCurrentDate());
		config.setProperty("rp.tags", " "+System.getProperty("cucumber.tags"));
		config.setProperty("rp.apitoken", " eca967a7-5d09-490a-8788-7f847f8d8faa");
		config.save(System.getProperty("user.dir") + "/src/test/resources/reportportal.properties");

		//System.out.println("Report portal Property File Successfully Updated..");
	}




	public static void main(String args[]) throws IOException, UnirestException, ConfigurationException {
		updateReportPortalPropertiesFile();
	}
}
