package steps.fake;

import driver.Config;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import tasks.classworkday19.logging.L4JLogging;

import java.net.MalformedURLException;


public class FakeBaseSteps {
    private static final Logger LOGGER = Logger.getLogger(L4JLogging.class.getName());

    @Before
    public void beforetest() throws MalformedURLException {
        LOGGER.info("Initializing WebDriver..");
        Driver.initWebDriver(Config.CHROME);
    }

    @After
    public void afterTest() {
        LOGGER.info("Killing WebDriver..");
        Driver.destroy();
    }
}
