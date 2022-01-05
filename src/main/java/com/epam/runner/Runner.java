package com.epam.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Program_Portal.feature",
                    glue ="com.epam.bddTesting",
                    plugin = {"pretty","html:testReport/cucumber-report.html","pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                    publish = true
        //, plugin = { "pretty", "html:report.html","com.epam.reportportal.cucumber.StepReporter" }
 )
public class Runner extends AbstractTestNGCucumberTests{
}