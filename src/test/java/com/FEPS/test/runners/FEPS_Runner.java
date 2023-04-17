package com.FEPS.test.runners;
/**
 * Author : Jeevan Kumar K V
 * Email id  : jeevankumar.kv@conduent.com
 */
import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.CucumberOptions;

import courgette.api.testng.TestNGCourgette;
import org.testng.annotations.Test;


@Test
@CourgetteOptions(
        threads = 1, // threads value is controlled in build.gradle or by using passing cli parameter -Pthreads
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = true,
        rerunAttempts = 1,
        showTestOutput = true,
        reportTitle = "FEPS - Automation Report",
        reportTargetDir = "Automation_Report",
        environmentInfo = "Browser=chrome; Project_info=FEPS !; Author = JeevanKumar K V",
        //disableHtmlReport = {HtmlReport.COURGETTE_HTML, HtmlReport.CUCUMBER_HTML},
       // plugin = {"extentreports", "reportportal"},
       	plugin = {"extentreports","HtmlReport.CUCUMBER_HTML"},
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = {"classpath:com.FEPS.test.stepdefinition", "com.FEPS.InitDriver","src.test.java","src.main.java","src.main.resources"},
                tags = {"@729451","@729452"},
                publish = true,
                plugin = { "json:target/FEPS.json",
                		"pretty",                      
                          //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                           
                        //"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                         //"json:Automation_Report/cucumber-report/cucumber.json",
                        // "html:Automation_Report/cucumber-report/cucumber.html",
                        // "json:Automation_Report/Extent_Spark_Report/cucumber.json",
                        // "html:Automation_Report/Extent_Spark_Report/cucumber.html"

                }
                  
        ))


public class FEPS_Runner extends TestNGCourgette {
}
