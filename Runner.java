package stepDefinations;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {".\\src\\test\\resources\\Features"},
		glue= {"StepDefinations"},
		dryRun = false,
		plugin = {"pretty",
				"html:cucumber.html",
				"json:cucumber.json"


		},
		monochrome = true
		)


public class Runner extends AbstractTestNGCucumberTests{

}
