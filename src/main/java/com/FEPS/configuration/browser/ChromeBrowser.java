package com.FEPS.configuration.browser;

import com.FEPS.settings.ObjectRepo;
import com.FEPS.utility.DateTimeHelper;
import com.FEPS.utility.ResourceHelper;

import org.json.JSONObject;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class ChromeBrowser {

	public DesiredCapabilities getChromeCapabilities() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		DesiredCapabilities chrome = new  DesiredCapabilities();
		chrome.setJavascriptEnabled(true);

		chrome.setCapability(ChromeOptions.CAPABILITY, option);
		return chrome;
	}

	public WebDriver getChromeDriver(DesiredCapabilities cap) {
		System.setProperty("webdriver.chrome.driver",
				ResourceHelper.getResourcePath("driver/chromedriver.exe"));
		System.setProperty("webdriver.chrome.logfile",
				ResourceHelper.getResourcePath("logs/chromelogs/")
						+ "chromelog" + DateTimeHelper.getCurrentDateTime()
						+ ".log");
		return new ChromeDriver();
	}
	
	public WebDriver getChromeDriver(String hubUrl,DesiredCapabilities cap) throws MalformedURLException {
		return new RemoteWebDriver(new URL(hubUrl), cap);
	}
	
	public ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-web-security");
		options.addArguments("--no-proxy-server");
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		Map<String,Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password.manager_enabled", false);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", prefs);
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		DesiredCapabilities chrome = new DesiredCapabilities();
		chrome.setJavascriptEnabled(true);
		options.merge(chrome);
		//****************************geolocation****************************
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("profile.default_content_settings.geolocation", ObjectRepo.reader.getLocationShareSetting());

		options.setExperimentalOption("prefs", jsonObject);

//		ChromeDriver driver = new ChromeDriver();
//		Map coordinates = new HashMap()
//		{{
//			put("latitude", 50.2334);
//			put("longitude", 0.2334);
//			put("accuracy", 1);
//		}};
//		final Map map = driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		//**************************************************************************
		return options;
	}
	
	public ChromeOptions getHeadlessChromeOptions() {
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-gpu");
        return chromeOptions;
	}

}
