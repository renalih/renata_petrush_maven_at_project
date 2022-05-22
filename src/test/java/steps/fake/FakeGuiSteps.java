package steps.fake;

import driver.Config;
import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.net.MalformedURLException;

public class FakeGuiSteps {

    @Given(value = "I go to onliner.by")
    public void checkHeaderTest() throws MalformedURLException {
        Driver.setConfig(Config.REMOTE);
        Driver.getWebDriver().get("https://www.onliner.by/");
    }

    @When("I start waiting")
    public void checkFooterTest() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Then("I just passed")
    public void verify(){
        Assert.assertTrue(true);
    }
}
