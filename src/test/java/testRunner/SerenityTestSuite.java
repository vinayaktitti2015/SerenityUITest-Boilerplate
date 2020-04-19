package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import net.thucydides.core.annotations.Managed;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", 
tags = { "@search" },
glue = { "step_definitions" })

public class SerenityTestSuite {

}
