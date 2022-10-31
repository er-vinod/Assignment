package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/assignment1.feature","src/test/resources/Assignment2.feature"},
		glue="stepDefinition",
		dryRun=false,
		tags = "@assignment2 or @assignment1",
		plugin= {"pretty","html:test-output/htmlReport.html","json:test-output/jsonReport.json"},
		monochrome = true
		)

public class AssignmentRunner {

}
