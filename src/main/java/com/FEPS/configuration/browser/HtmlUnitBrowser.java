package com.FEPS.configuration.browser;

/**
 * Author : JeevanKumar K V
 * Email id  : jeevankumar.kv@conduent.com
 */
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class HtmlUnitBrowser {
	
	public Capabilities getHtmlUnitDriverCapabilities() {
		@SuppressWarnings("deprecation")
		DesiredCapabilities unit = DesiredCapabilities.htmlUnit();
		return unit;
	}
	
	public WebDriver getHtmlUnitDriver(Capabilities cap) {
		return new HtmlUnitDriver(cap);
	}

}
