package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "classpath:features/placeValidations.feature",
	    glue = {"stepDefinations", "hooks"},
	    plugin = {
	        "pretty",
	        "html:target/cucumber-report.html",
	        "json:target/jsonReports/cucumber-report.json",
	        "summary"
	    },
	    monochrome = true,
	    tags = "@DeletePlace"
	)
public class TestRunnerTest {

}
