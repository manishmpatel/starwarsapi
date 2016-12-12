package com.optum.guidance.functional.testing;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"com.optum.guidance.functional.testing"}
        )
public class RunSearchFeature extends AbstractTestNGCucumberTests {
}