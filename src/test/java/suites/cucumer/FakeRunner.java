package suites.cucumer;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"steps.fake"},
        features = {"src/test/resources/features/fake/FakeOne.feature"})

public class FakeRunner {

}
