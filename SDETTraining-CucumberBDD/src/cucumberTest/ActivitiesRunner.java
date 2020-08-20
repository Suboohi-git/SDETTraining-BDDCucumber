package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/* Activity 1
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Selenium\\Workspace\\SDETTraining-CucumberBDD\\features",
    glue = {"stepDefinitions"},
    tags = {"@activity1_1"},
    strict = true
)
*/

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "features",
    glue = {"stepDefinitions"},
    tags = {"@activity2_4"},
    strict = true
)

public class ActivitiesRunner {}
