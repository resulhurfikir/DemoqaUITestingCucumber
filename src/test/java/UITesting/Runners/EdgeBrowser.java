package UITesting.Runners;

import UITesting.Utilities.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = {"src/test/java/UITesting/FeatureFiles"},
        glue = {"UITesting/StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class EdgeBrowser extends AbstractTestNGCucumberTests {
    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        BaseClass.threadBrowserSet("edge");
    }
}
