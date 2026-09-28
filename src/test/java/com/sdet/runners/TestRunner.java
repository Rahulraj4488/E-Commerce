package com.sdet.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
//import org.junit.platform.suite.api.SelectClasspathPackage;
import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/webforce.feature")
//@SelectClasspathResource("features")
//@SelectClasspathPackage("features")
@ConfigurationParameter(
        key = Constants.GLUE_PROPERTY_NAME,
        value = "com.sdet.steps"
)
public class TestRunner {
}