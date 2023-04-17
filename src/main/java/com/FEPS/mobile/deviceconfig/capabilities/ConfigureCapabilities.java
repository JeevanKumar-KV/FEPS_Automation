package com.FEPS.mobile.deviceconfig.capabilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.FEPS.configreader.FileReaderManager;
import com.FEPS.configreader.PropertyFileReader;



public class ConfigureCapabilities {

	PropertyFileReader prop = FileReaderManager.getInstance().getConfigReader();
	public DesiredCapabilities caps;

	public DesiredCapabilities setAndroidCapabilities() {
		caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getDeviceName());
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getPlatformName());
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getPlatformVersion());
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getautomationName());
//		caps.setCapability(MobileCapabilityType.BROWSER_NAME, prop.getbrowserName());
//		caps.setCapability("chromedriverExecutable", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver2_41.exe");//Use this only for chrome version 69
//		caps.setCapability("appWaitDuration", 30);

		caps.setCapability("nativeWebScreenshot", "true");
		caps.setCapability("deviceReadyTimeout", 15);
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.zoontek.rnbootsplash.RNBootSplashActivity");
	    caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.arbys.reactive");
		caps.setCapability("app",System.getProperty("user.dir")+"/src/test/java/com/inspire/brands/MobileApp_Files/Apps/app-prodArbys-release.apk");
		
		caps.setCapability("noReset", prop.getnoResetProperty());
		return caps;
	}

	public DesiredCapabilities setIOSCapabilities() {
		caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getDeviceName());
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getPlatformName());
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getPlatformVersion());

		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getautomationName());
		caps.setCapability("launchTimeout", 15000);
//		caps.setCapability(MobileCapabilityType.BROWSER_NAME, prop.getbrowserName());
//		caps.setCapability("safariAllowPopups", "true");
//		caps.setCapability("appWaitDuration", 30);

		caps.setCapability("nativeWebScreenshot", "true");
		caps.setCapability("nativeWebTap", "true");
//		caps.setCapability("acceptAlertButtonSelector", "**/XCUIElementTypeButton[`label CONTAINS[c] 'Allow Once'`]");
		caps.setCapability("locationServicesEnabled", "true");
		caps.setCapability("locationServicesAuthorized", "true");
		caps.setCapability("app",System.getProperty("user.dir")+"/src/test/java/com/inspire/brands/MobileApp_Files/Apps/InspireBrandsApp.app");
		caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
		caps.setCapability("noReset", Boolean.FALSE);
		return caps;
	}

}
