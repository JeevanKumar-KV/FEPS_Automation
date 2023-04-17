package com.FEPS.configreader;

import com.FEPS.configuration.browser.BrowserType;
import com.FEPS.interfaces.IconfigReader;
import com.FEPS.settings.ObjectRepo;

import org.apache.log4j.Level;
import org.testng.Assert;

import java.io.FileInputStream;

import java.util.Properties;

public class PropertyFileReader implements IconfigReader {

	String Env, bsDevice, deviceOS, platform, bsDeviceName, bsMobileOS, browserName, osVersion, browserVersion,
			endpoint_type = null;
	BrowserType browser;

	FileInputStream fis = null;
	public Properties prop = null;

	String role_Based_UserName = null;
	String role = null;

	public PropertyFileReader() {
		prop = new Properties();

		// Global Env value
		if (System.getenv("Env") == null || System.getenv("Env").equals("") || System.getenv("Env").isEmpty()) {
			// Local Env Value
			if (System.getProperty("environment") == null || System.getProperty("environment").equals("")
					|| System.getProperty("environment").isEmpty()) {
				System.out.println("Path " + System.getProperty("user.dir"));
				System.out.println(" ");
				System.out.println(
						"***************************************************************************************************");

				System.err.println(
						"No Env Value set at Global (Jenkins or CI/CD) and at Local (Command Line Interface (CLI ))  - "
								+ " Hence chosing the Default ENV value as : QA ");
				System.err.println(
						"Qa Properties File path : \\src\\main\\resources\\configFile\\QA_FEPS_Config.properties");

				System.out.println(
						"***************************************************************************************************");
				System.out.println(" ");
				try {
					fis = new FileInputStream(System.getProperty("user.dir")
							+ "\\src\\main\\resources\\configFile\\QA_FEPS_Config.properties");

					prop.load(fis);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Local Env Value set : " + System.getProperty("environment"));

				try {

					fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\configFile\\"
							+ System.getProperty("environment") + "_FEPS_Config.properties"); // Default to qa Env
																									// when Env value is
																									// not supplied in
																									// jenkins

					prop.load(fis);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("Global Env Value set  : " + System.getenv("Env"));
			String Env = System.getenv("Env").toUpperCase();

			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\configFile\\" + Env
						+ "_FEPS_Config.properties");
				prop.load(fis);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public String get_Env() {

		// Global Env value from CI/CD( Jenkins)
		if (System.getenv("Env") == null || System.getenv("Env").equals("") || System.getenv("Env").isEmpty()) {
			// Local Env Value
			if (System.getProperty("environment") == null || System.getProperty("environment").equals("")
					|| System.getProperty("environment").isEmpty()) {
				Env = prop.getProperty("ENV");
			} else {
				Env = System.getProperty("environment");
			}
		} else {
			Env = System.getenv("Env");
		}

		ObjectRepo.Env = Env;
		return Env;

	}

	// To get platform like UI , API, Mobile , Browserstack
	public String getPlatform() {

		// System.err.println(" Platform - "+System.getProperty("platform"));

		// Global Platform value from CI/CD( Jenkins)
		if (System.getenv("platform") == null || System.getenv("platform").equals("")
				|| System.getenv("platform").isEmpty()) {
			// Local Platform Value Command line interface (CLI)
			if (System.getProperty("platform") == null || System.getProperty("platform").equals("")
					|| System.getProperty("platform").isEmpty()) {
				platform = prop.getProperty("platform");
			} else {
				platform = System.getProperty("platform");
			}

		} else {
			platform = System.getenv("platform");
		}

		ObjectRepo.Platform = platform;
		return platform;
	}

	// ------------------------Bearer Token methods Details
	// -------------------------------
	// get Bearer Base Url
	public String get_Bearer_Base_Api_Url() {
		return prop.getProperty("Bearer_Base_Api_Url");
	}

	// get Bearer endpoint url
	public String get_Bearer_endPoint_Url() {
		return prop.getProperty("Bearer_Endpoint_Url");
	}

	// get Bearer Client Username
	public String get_Bearer_Username() {
		String Bearer_Username = null;

		Bearer_Username = prop.getProperty("Bearer_Username");

		return Bearer_Username;
	}

	// get Bearer Client Password
	public String get_Bearer_Password() {

		String Bearer_Password = null;

		Bearer_Password = prop.getProperty("Bearer_Password");

		return Bearer_Password;
	}

	// get Bearer Client ID
	public String get_Bearer_Client_Id() {
		String Bearer_Client_Id = null;

		Bearer_Client_Id = prop.getProperty("Bearer_Client_Id");

		return Bearer_Client_Id;
	}

	// get Bearer Client Secret
	public String get_Bearer_Client_Secret() {
		String Bearer_Client_Secret = null;

		Bearer_Client_Secret = prop.getProperty("Bearer_Client_Secret");

		return Bearer_Client_Secret;
	}

	// ---------------------------------------------------------------------------------------------

	// ------------------------Incontact Bearer Token methods Details
	// -------------------------------

	// get InContact Bearer Base Url
	public String get_InContact_Bearer_Base_Api_Url() {
		return prop.getProperty("Bearer_InContact_Base_Api_Url");
	}

	// get InContact Bearer endpoint url
	public String get_InContact_Bearer_EndPoint_Api_Url() {
		return prop.getProperty("Bearer_InContact_Endpoint_Api_Url");
	}
	
	// get InContact Agent ID
	public String get_InContact_Agent_Id() {
		return prop.getProperty("InContact_Agent_Id");
	}
	
	// get InContact Agent Session Base Url
	public String get_InContact_Agent_Session_Base_Api_Url() {
		return prop.getProperty("InContact_Agent_Session_Base_Api_Url");
	}
	
	// get InContact Agent Session End Point
	public String get_InContact_Agent_Session_EndPoint_Api_Url() {
		return prop.getProperty("InContact_Agent_Endpoint_Api_Url");
	}
	
	// get InContact Agent Leg Connection End Point
	public String get_InContact_Agent_Leg_Connection_EndPoint_Api_Url() {
		return prop.getProperty("InContact_Agent_Leg_Connection_Endpoint_Api_Url");
	}


	// ---------------------------------------------------------------------------------------------

	// -------------------------------- Case Creation Api Url
	// ---------------------------------------

	public String get_Case_Creation_Base_Api_Url() {
		String case_Creation_Api_Url = null;

		case_Creation_Api_Url = prop.getProperty("Case_Creation_Base_Api_Url").trim();

		return case_Creation_Api_Url;
	}

	public String get_Case_Creation_Api_Endpoint_Url() {
		return prop.getProperty("Case_Creation_Api_Endpoint_Url").trim();
	}

	// -------------------------------- OCR Process URL
	// ---------------------------------------------------------

	public String get_OCR_Process_Base_Api_Url() {
		return prop.getProperty("OCR_Process_Base_Api_Url");
	}

	public String get_OCR_Process_Endpoint_Api_Url() {
		return prop.getProperty("OCR_Process_Enpoint_Api_Url");
	}

	// To get Role based username
	// This method is used when userrole or usertype is supplied from either
	// enternal CI/CD or at Command Line Interface (CLI)
	public String get_Role_Based_UserName() {
		role_Based_UserName = null;
		role = null;

		// To get Global Role based username set from CI/CD(Jenkins)
		if (System.getenv("UserRole") == null || System.getenv("UserRole").equals("")
				|| System.getenv("UserRole").isEmpty()) {
			System.out.println(" System.getProperty(\"UserRole\")  : " + System.getProperty("UserRole"));
			// To get Role based username set locally through Command Line Interface (CLI)
			if (System.getProperty("UserRole") == null || System.getProperty("UserRole").equals("")
					|| System.getProperty("UserRole").isEmpty()) {
				role_Based_UserName = prop.getProperty("userRole_Agent"); // if no user roles supplied from global or at
																			// CLI then by default Agent role is
																			// selected
			} else {
				role = System.getProperty("UserRole").trim(); // CLI
				role_Based_UserName = get_username(role);
			}
		} else {
			// if Global env variable is not null
			role = System.getenv("UserRole").trim();
			role_Based_UserName = get_username(role);

		}

		ObjectRepo.role_Based_UserName = role_Based_UserName;

		return role_Based_UserName;
	}

	public String get_username(String roletype) {
		System.out.println("roletype : " + roletype);
		String UserName = null;

		if (prop.getProperty("userRole_" + roletype) != null) {
			UserName = prop.getProperty("userRole_" + roletype);
		} else {
			System.err.println("Failed - Due to specified/entered User Role : '" + roletype
					+ "' is undefined - Use correct User Roles");
			Assert.assertNotNull(null, "Failed - Due to specified/entered User Role : '" + roletype
					+ "' is undefined - Use correct User Roles");
		}
		ObjectRepo.role_Based_UserName = UserName;
		return UserName;
	}

	// Get Role based password
	public String get_Role_Based_Password() {
		boolean password_flag = false;
		String role_Based_Password = null;

		if (!(prop.getProperty("userRole_" + role) == null)) {

			// role = System.getProperty("UserRole").trim();
			role_Based_Password = prop.getProperty("userRole_" + role + "_Pwd").trim();
			password_flag = true;
			if (password_flag == false) {
				System.err.println("Failed - Due to entered Password is  incorrect for " + role
						+ " role - Enter the correct password based on Role");
				Assert.assertTrue(false, "Failed - Due to entered Password is  incorrect for " + role
						+ " role - Enter the correct password based on Role");
			}
		} else {
			System.err.println(
					"Failed - The specified User Role : '" + role + "' is undefined - Use correct User Roles ");
			Assert.assertNotNull(null,
					"Failed - The specified/entered User Role : '" + role + "' is undefined - Use correct User Roles");
		}
		return role_Based_Password;
	}

	// ------------------------------------------------------------------------------------------------------------

	// This method is called and used when role is supplied from Scenario outline
	// and when UserRole is not supplied at CLI or at Global ( jenkins CI/CD)
	public String get_Role_Based_Password(String roletype) {
		boolean password_flag = false;
		String role_Based_Password = null;
		if (!(prop.getProperty("userRole_" + roletype) == null)) {
			// role = System.getProperty("UserRole");
			role_Based_Password = prop.getProperty("userRole_" + roletype + "_Pwd");
			password_flag = true;
			if (password_flag == false) {

				System.err.println("Failed - Due to entered Password is  incorrect for " + roletype
						+ " role - Enter the correct password based on Role");
				Assert.assertTrue(false, "Failed - Due to entered Password is  incorrect for " + roletype
						+ " role - Enter the correct password based on Role");
			}

		} else {
			System.err.println(
					"Failed - The specified User Role : '" + role + "' is undefined - Use correct User Roles ");
			Assert.assertNotNull(null,
					"Failed - The specified/entered User Role : '" + role + "' is undefined - Use correct User Roles");
		}

		return role_Based_Password;
	}

	public String getUserName() {
		return prop.getProperty("Username");
	}

	public String getPassword() {
		return prop.getProperty("Password");
	}

	public boolean getBrowserWindowSize() {

		return prop.getProperty("windowMaximize") != null;
	}

	public String getDriverPath() {

		return prop.getProperty("DriverPath");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplicitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	public BrowserType getBrowser() {
		if (System.getProperty("browser").isEmpty())
			browser = BrowserType.valueOf(prop.getProperty("browser").toUpperCase());
		else
			browser = BrowserType.valueOf(System.getProperty("browser").toUpperCase());

		return browser;
	}

	public Level getLoggerLevel() {

		switch (prop.getProperty("Logger.Level")) {

		case "DEBUG":
			return Level.DEBUG;
		case "INFO":
			return Level.INFO;
		case "WARN":
			return Level.WARN;
		case "ERROR":
			return Level.ERROR;
		case "FATAL":
			return Level.FATAL;
		}
		return Level.ALL;
	}

	public String getJsonDataFilePath() {
		return prop.getProperty("jsonDataFileReader");
	}

	public String extentConfigFilePath() {
		return prop.getProperty("extentReportPathConfig");
	}

	// ********************* UI related methods ********************************* //

	@Override
	public String get_FEPS_Website_URL() {
		String FEPS_WebSite_Url = null;

		if (get_Env().equalsIgnoreCase("qa")) {
			FEPS_WebSite_Url = prop.getProperty("FEPS_QA_URL");
		}
		if (get_Env().equalsIgnoreCase("dev")) {
			FEPS_WebSite_Url = prop.getProperty("FEPS_Dev_URL");
		}
		if (get_Env().equalsIgnoreCase("stg")) {
			FEPS_WebSite_Url = prop.getProperty("FEPS_Stg_URL");
		}
		if (get_Env().equalsIgnoreCase("Uat")) {
			FEPS_WebSite_Url = prop.getProperty("FEPS_Uat_URL");
		}
		if (get_Env().equalsIgnoreCase("Prod")) {
			FEPS_WebSite_Url = prop.getProperty("FEPS_Prod_URL");
		}
		return FEPS_WebSite_Url;
	}

	// ======================================================================================================================
//  Mobile
	@Override
	public String get_Mobile_OS() {
		return prop.getProperty("Mobile_platformName");
	}

	// Appium Capabilities
	@Override
	public String getDeviceName() {
		String DeviceName = null;
		if (get_Mobile_OS().equalsIgnoreCase("IOS"))
			DeviceName = prop.getProperty("iOS_DeviceName");
		else if (get_Mobile_OS().equalsIgnoreCase("Android"))
			DeviceName = prop.getProperty("Android_DeviceName");
		return DeviceName;
	}

	@Override
	public String getPlatformName() {
		return prop.getProperty("Mobile_platformName");
	}

	@Override
	public String getPlatformVersion() {
		String PlatformVersion = null;
		if (get_Mobile_OS().equalsIgnoreCase("IOS"))
			PlatformVersion = prop.getProperty("iOS_Version");
		else if (get_Mobile_OS().equalsIgnoreCase("Android"))
			PlatformVersion = prop.getProperty("Android_Version");
		return PlatformVersion;

	}

	@Override
	public String getautomationName() {
		String AutomationName = null;
		if (get_Mobile_OS().equalsIgnoreCase("IOS"))
			AutomationName = prop.getProperty("iOS_automationName");
		else if (get_Mobile_OS().equalsIgnoreCase("Android"))
			AutomationName = prop.getProperty("Android_automationName");
		return AutomationName;
	}

	@Override
	public String getbrowserName() {
		String BrowserName = null;
		if (get_Mobile_OS().equalsIgnoreCase("IOS"))
			BrowserName = prop.getProperty("iOS_BrowserName");
		else if (get_Mobile_OS().equalsIgnoreCase("Android"))
			BrowserName = prop.getProperty("Android_BrowserName");
		return BrowserName;
	}

	@Override
	public String getnoResetProperty() {
		return prop.getProperty("noResetProperty");
	}

	@Override
	public String getAppiumServerURL() {
		return prop.getProperty("Appium_Server_URL");
	}

	public String getAppActivity() {
		return prop.getProperty("appActivity");
	}

	public String getAppPackage() {
		return prop.getProperty("appPackage");
	}

	public String getApp() {
		return prop.getProperty("app");
	}

	public String getHubUrl() {
		return prop.getProperty("hubUrl");
	}

	/**
	 * Get geolocatiion setting for browser from config file
	 */
	public String getLocationShareSetting() {
		return prop.getProperty("geolocation");
	}

}
