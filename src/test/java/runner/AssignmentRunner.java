package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/assignment1.feature","src/test/resources/Assignment2.feature"},
		glue="stepDefinition",
		dryRun=false,
		//tags = "@test",
		plugin= {"pretty","html:testoutput.html"},
		monochrome = true	
		)

public class AssignmentRunner {

}
