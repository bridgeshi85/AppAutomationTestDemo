package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/resources/features",
        glue = "com.demo.stepDefs",
        plugin = { "pretty" },
        monochrome = true
)
public class CucumberRunner extends AbstractTestNGCucumberTests {



}
