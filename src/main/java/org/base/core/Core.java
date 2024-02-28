package org.base.core;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.tests"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class Core { }