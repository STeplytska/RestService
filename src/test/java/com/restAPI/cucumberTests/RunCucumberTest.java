package com.restAPI.cucumberTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/restAPI/cucumberTests",
        plugin = {"pretty"})
public class RunCucumberTest {

}
