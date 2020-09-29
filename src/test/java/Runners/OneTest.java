package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"summary","pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-report/TestResult.json"},
        monochrome = false,
        features = "src/test/resources/features/test.feature",
        glue="Steps")
public class OneTest{

}