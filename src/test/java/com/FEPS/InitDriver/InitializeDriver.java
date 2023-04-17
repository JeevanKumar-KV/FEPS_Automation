package com.FEPS.InitDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

/**
 * @author JeevanKumar K V
 * Email id : balaji.singhy@conduent.com
 *         
 */


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.FEPS.configreader.FileReaderManager;
import com.FEPS.configreader.PropertyFileReader;
import com.FEPS.configuration.browser.BrowserType;
import com.FEPS.configuration.browser.ChromeBrowser;
import com.FEPS.exception.NoSutiableDriverFoundException;
import com.FEPS.mobile.deviceconfig.capabilities.ConfigureCapabilities;
import com.FEPS.settings.ObjectRepo;
import com.FEPS.utility.DateTimeHelper;
import com.FEPS.utility.LoggerHelper;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;


public class InitializeDriver {
    public RemoteWebDriver remoteWebDriver;
    //	WebDriver driver;
    public Scenario scenario;
    public AppiumDriver<MobileElement> AppiumDriver;
    public Logger oLog = LoggerHelper.getLogger(InitializeDriver.class);

    String operSys = System.getProperty("os.name").toLowerCase();
   
    //Values to set chrome options
    ChromeOptions options = new ChromeOptions();
    Map<String, Object> prefs = new HashMap<String, Object>();
    Map<String, Object> profile = new HashMap<String, Object>();
    Map<String, Object> contentSettings = new HashMap<String, Object>();
     
    public InitializeDriver() {
        ObjectRepo.reader = new PropertyFileReader();
     }


    @Before
    public void before(Scenario scenario) throws Exception {
    	
    	
        // String browser = System.getProperty("browser", "chrome");
        ObjectRepo.scenario = scenario;
        this.scenario = scenario;
        //setUpDriver(browser);

        @SuppressWarnings("unused")
		ArrayList<String> list = (ArrayList<String>) scenario.getSourceTagNames();
        //System.out.println(" Tags  list: " + list.toString());

        if (!scenario.getUri().toString().toUpperCase().contains("SERVICES"))
        {

            if (ObjectRepo.reader.getPlatform().equalsIgnoreCase("LocalMobile")) {

                //System.out.println("=============================. Initialization of Appium Driver called =========================================================== ");
                oLog.info("=============================. Initialization of Appium driver called ===========================================================");
                ObjectRepo.appiumDriver = launchApp();


            } else if (ObjectRepo.reader.getPlatform().equalsIgnoreCase("UI")) {
                //System.out.println("=============================. Initialization of Webdriver method  called ===========================================================");
                oLog.info("=============================. Initialization of Webdriver method  called  ===========================================================");

                //System.out.println(" Init browser  : " + ObjectRepo.reader.getBrowser());
                
                
                setUpDriver(ObjectRepo.reader.getBrowser());
                oLog.debug(ObjectRepo.reader.getBrowser());
                ObjectRepo.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            } 

        }

    }

    
    public void setUpDriver(BrowserType bType) throws Exception {
        ObjectRepo.driver = standAloneStepUp(bType);
        
        if (ObjectRepo.driver != null) {
            //System.out.println(" Driver is not null");
        } else {
            //System.out.println("Driver is null");
        }
        oLog.debug("InitializeWebDriver : " + ObjectRepo.driver.hashCode());
        ObjectRepo.driver.manage().timeouts().pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
        ObjectRepo.driver.manage().timeouts().implicitlyWait(ObjectRepo.reader.getImplicitWait(), TimeUnit.SECONDS);
        ObjectRepo.driver.manage().window().maximize();
        ObjectRepo.ngWebDriver = new NgWebDriver((JavascriptExecutor) ObjectRepo.driver);
        ObjectRepo.ngWebDriver.waitForAngularRequestsToFinish();
       
    }
    
    

    @After
    public void after(Scenario scenario) throws Exception {
    	
        if (!scenario.getUri().toString().toUpperCase().contains("SERVICES"))
        {
            if (ObjectRepo.reader.getPlatform().equalsIgnoreCase("UI")) {
                oLog.info("TearDownWeb Driver method called ......................................");
                tearDownWebDriver(scenario);
                oLog.info("");
            }
            if (ObjectRepo.reader.getPlatform().equalsIgnoreCase("LocalMobile")) {
                oLog.info("TearDownAndroid Driver method called ......................................");
                teardownMobileDriver(scenario);
                oLog.info("");
            }
            
        }
	
    }


   


    public WebDriver standAloneStepUp(BrowserType bType) throws Exception {
        WebDriver driver;
        try {
            oLog.info(bType);

            switch (bType) {

                case CHROME:
                   //if (operSys.contains("windows"))
                   //     System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");

                   // if (operSys.contains("mac") || operSys.contains("linux"))
                   //     System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver");

                    ChromeOptions options = new ChromeOptions();
                    //added below line for chrome update
                    options.addArguments("--remote-allow-origins=*");
                    DesiredCapabilities capabilities = new DesiredCapabilities();
//                    options.addArguments("user-data-dir=C:/Users/52257256/AppData/Local/Google/Chrome/User Data");
//         		 	options.addArguments("profile-directory=Profile 7");
                    options.addArguments("--ignore-certificate-errors");
                    //To disable 'Allow microphone' permission
                    options.addArguments("use-fake-ui-for-media-stream");
                    options.addArguments("--disable-geolocation");
                    //options.addArguments("--incognito");
                    options.addArguments("--enable-strict-powerful-feature-restrictions");
                    options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
                    Map<String,Object> prefs = new HashMap<String, Object>();
            		prefs.put("credentials_enable_service", false);
            		prefs.put("profile.password.manager_enabled", false);
            		prefs.put("profile.default_content_setting_values.notifications", 2);
            		options.setExperimentalOption("prefs", prefs);
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    options.merge(capabilities);
                    
                    WebDriverManager.chromedriver().setup();
            		driver = new ChromeDriver(options);                   
                   
                    oLog.info("Launching the Chrome Browser");
                    return driver;

                case FIREFOX:
                   // System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/driver/geckodriver.exe");
                   // driver = new FirefoxDriver();
                    //driver = new FirefoxDriver(firefox.getFirefoxOptions());
                	
                	WebDriverManager.firefoxdriver().setup();
                	driver = new FirefoxDriver();
                	oLog.info("Launching the Firefox Browser");
                    return driver;

                case SAFARI:
                    //driver = new SafariDriver();
                	DriverManagerType safari = DriverManagerType.SAFARI;
                	WebDriverManager.getInstance(safari).setup();
                	Class<?> safariClass =  Class.forName(safari.browserClass());
                	driver = (WebDriver) safariClass.getDeclaredConstructor().newInstance();
                	
                    return driver;

                case HEADLESS:
                    ChromeBrowser chrome = ChromeBrowser.class.newInstance();
                    //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
                    //driver = new ChromeDriver(chrome.getHeadlessChromeOptions());
                	WebDriverManager.chromedriver().setup();
           		    driver = new ChromeDriver(chrome.getHeadlessChromeOptions()); 
                    oLog.info("Launching the Chrome Browser in Headless Mode");
                    return driver;

                case IE:
                    //IExploreBrowser iExplore = IExploreBrowser.class.newInstance();
                    //System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/main/resources/driver/IEDriverServer.exe");
                    //driver = new InternetExplorerDriver(iExplore.getIEOptions());
                	WebDriverManager.iedriver().setup();
                	driver = new InternetExplorerDriver();
                    oLog.info("Launching the Internet Explorer Browser");
                    return driver;


                case EDGE:
                    //System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/resources/driver/MicrosoftWebDriver.exe");
                    //driver = new EdgeDriver();
                	WebDriverManager.edgedriver().setup();
                	driver = new EdgeDriver();
                    oLog.info("Launching the EDGE Browser");
                    return driver;

                default:
                    throw new NoSutiableDriverFoundException(" Driver Not Found : " + ObjectRepo.reader.getBrowser());
            }
        } catch (Exception e) {
            oLog.info(e);
            throw e;
        }
    }

    public void tearDownWebDriver(Scenario scenario) throws IOException {

        try {
            if (ObjectRepo.driver != null) {
                if (scenario.isFailed()) {
                    scenario.log("Scenario Failed, Capturing Screenshot.............");

                    TakesScreenshot screenshot = (TakesScreenshot) ObjectRepo.driver;

                   
                    //To save screenshot in Automation_report directory
                    String scnenario_name = scenario.getName();
                    String[] testcase_id= scnenario_name.split(":");
                    FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")+"/Automation_Report/ScreenshotsFailure/" + testcase_id[0] + DateTimeHelper.getCurrentDateTime() + ".png"));
                   
                    //To attach screenshot in extent report
                    	scenario.attach(screenshot.getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
                    
                    	//ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(getWebBase64Screenshot(ObjectRepo.driver,scenario));
                    	
                    	
                    	

                }
                ObjectRepo.driver.quit();
                //System.out.println(" ");
                oLog.info("");
                oLog.info("=============================. Shutting Down Webdriver ===========================================================");
            }
        } catch (Exception e) {
            oLog.error(e);
            throw e;
        }
    }
    
    
    public static String getWebBase64Screenshot(WebDriver driver, Scenario scenario) throws IOException  {

		String Base64StringofScreenshot="";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		 File destDir = new File(System.getProperty("user.dir")+"/Automation_Report/ScreenshotsFailure/" + scenario.getName() + DateTimeHelper.getCurrentDateTime() + ".png");
		if (!destDir.exists())
			destDir.mkdir();

		File destPath = new File(destDir.getAbsolutePath()
				+ System.getProperty("file.separator") + scenario.getName().replaceAll(" ", "_") + ".png");

		try {
			FileUtils.copyFile(src, destPath);
		} catch (IOException e) {

			e.printStackTrace();
		}
		//
		byte[] fileContent = FileUtils.readFileToByteArray(src);
		Base64StringofScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
		return Base64StringofScreenshot;
	}
    
   
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public AppiumDriver<MobileElement> launchApp() throws MalformedURLException, FileNotFoundException {
        PropertyFileReader prop = FileReaderManager.getInstance().getConfigReader();
        //System.out.println(" ");
        oLog.info("");
        //System.out.println(" ...................................Starting with Appium Driver Initialization .................................................");
        oLog.info("...................................Starting with Appium Driver Initialization .................................................");
        //System.out.println(" ");
        try {
            if (prop.get_Mobile_OS().equalsIgnoreCase("Android")) {
                DesiredCapabilities caps = new ConfigureCapabilities().setAndroidCapabilities();
                AppiumDriver = new AndroidDriver(new URL(prop.getAppiumServerURL()), caps);
                AppiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (prop.get_Mobile_OS().equalsIgnoreCase("iOS")) {
                DesiredCapabilities caps = new ConfigureCapabilities().setIOSCapabilities();
                AppiumDriver = new IOSDriver(new URL(prop.getAppiumServerURL()), caps);
                AppiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
            //System.out.println(" ");
            oLog.info("...................................Started and Initialized Appium Driver ........................................................");
            //System.out.println(" ...................................Started and Initialized Appium Driver ........................................................");

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return AppiumDriver;
    }


   

    public void teardownMobileDriver(Scenario scenario) {
        try {
            if (ObjectRepo.appiumDriver != null) {
                if (scenario.isFailed()) {
                    TakesScreenshot screenshot = ObjectRepo.appiumDriver;
                    scenario.attach(screenshot.getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
                }
                ObjectRepo.appiumDriver.quit();
                //System.out.println(" ");
                oLog.info(" ");
                oLog.info("=============================Shutting Down the Appium driver===========================================================");
            }
        } catch (Exception e) {
            oLog.error(e);
            throw e;
        }
    }

        
} 
