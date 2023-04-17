package com.FEPS.settings;

/**
 * Author : JeevanKumar K V
 *  It holds the instances of 'driver',andriod driver
 * 'config reader'scenario and a Map
 */

import java.util.LinkedHashMap;
import java.util.Map;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import com.FEPS.interfaces.IconfigReader;
import com.paulhammant.ngwebdriver.NgWebDriver;


public class ObjectRepo 
{
	public static NgWebDriver ngWebDriver;
	
	public static WebDriver driver;
	
	public static String bearerToken;
	
	public static IconfigReader reader;
	
	public static Scenario scenario;
	
	public static String role_Based_UserName;
	
	public static String Platform;
	
	public static String Env;
	
	public static Map<String, Object> data = new LinkedHashMap<String, Object>();
	
	public static AppiumDriver<MobileElement> appiumDriver;
	
	public static String incontact_bearerToken;
	
	public static String incontact_agent_session_id;
}

