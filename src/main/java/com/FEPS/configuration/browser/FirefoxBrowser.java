package com.FEPS.configuration.browser;
/**
 * Author : JeevanKumar K V
 * Email id  : jeevankumar.kv@conduent.com
 */

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.FEPS.utility.ResourceHelper;


public class FirefoxBrowser {

	@SuppressWarnings("deprecation")
	public DesiredCapabilities getFirefoxCapabilities() {
		DesiredCapabilities firefox = new DesiredCapabilities();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);
		return firefox;
	}

	@SuppressWarnings("deprecation")
	public WebDriver getFirefoxDriver(DesiredCapabilities cap) {
		System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("driver/geckodriver.exe"));
		return new FirefoxDriver(cap);
	}

	public WebDriver getFirefoxDriver(String hubUrl, DesiredCapabilities cap) throws MalformedURLException {
		return new RemoteWebDriver(new URL(hubUrl), cap);
	}

	public FirefoxOptions getFirefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		// Set a preference for this particular profile.
		profile.setPreference("dom.ipc.plugins.enabled.libflashplayer.so", "false");
		String strFFBinaryPath = "C:\\Users\\mgolla\\AppData\\Local\\Mozilla Firefox\\firefox.exe";
		options.setBinary(strFFBinaryPath);
		options.setProfile(profile);
		// Sets whether Firefox should accept SSL certificates which have
		// expired, signed by an unknown authority or are generally untrusted.
		options.setAcceptInsecureCerts(true);

		return options;
	}

	@SuppressWarnings("deprecation")
	public DesiredCapabilities createFirefoxCapabilities() {
		FirefoxProfile profile = new FirefoxProfile();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(FirefoxDriver.MARIONETTE, true);

		// Start Mozilla with disable web notifications
		profile.setPreference("dom.webnotifications.enabled", false);

		// Allows the untrusted websites to run in the browser
		profile.setPreference("webdriver_assume_untrusted_issuer", true);

		// Start Mozilla assuming the Untrusted certificates accepting
		profile.setPreference("setAssumeUntrustedCertificateIssuer", true);
		profile.setPreference("security.enterprise_roots.enabled", true);
		capabilities.setCapability(FirefoxDriver.BINARY,
				"C:\\Users\\mgolla\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		return capabilities;

	}
}
