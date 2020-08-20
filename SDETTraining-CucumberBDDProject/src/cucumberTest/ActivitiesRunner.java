package cucumberTest;



import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "features",
    glue = {"stepDefinitions"},
      
    tags = {"@jobBoardActivities"},
    plugin = {"pretty", "html: target/cucumber-reports/reports"},
    monochrome = true,
    strict = true
)

public class ActivitiesRunner {

}
