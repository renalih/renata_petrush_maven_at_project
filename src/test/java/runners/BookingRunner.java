package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"tasks"},
        features = {"src/test/resources/features/mynewfeature.feature"},
        strict = true
        //tags = {"@QA"}
)
public class BookingRunner {
}
