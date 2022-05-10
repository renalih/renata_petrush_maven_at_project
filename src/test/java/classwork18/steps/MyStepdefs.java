package classwork18.steps;

import classwork17.Driver;
import classwork18.pages.BookingMainPage;
import classwork18.pages.BookingResultPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MyStepdefs {

    BookingMainPage mainPage = new BookingMainPage();
    BookingResultPage resultsPage = new BookingResultPage();

    @Given("I open test site")
    public void iOpenTestSite() {
        Driver.getWebDriver().get("https://booking.com");
        Driver.getWebDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
    }

    @When("I fill {string} into form")
    public void iFillIntoForm(String city) {
        mainPage.searchCity(city);
    }

    @Then("I see greeting message")
    public void iSeeGreetingMessage() {
        Assert.assertTrue("Result count is not expected!", 25 == resultsPage.getResults());
    }

    @After
    public void after() {
        Driver.destroy();
    }
}
