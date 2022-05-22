/*
package steps;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.trashmail.TemplateEmail;


public class StepsSignUp {

    TemplateEmail templateEmail = new TemplateEmail();

    @Given("I create a template email address using real email {string}")
    public void iCreateATemplateEmailAddress(String realEmail) {
        Driver.getWebDriver().get("https://trashmail.com");
        templateEmail.getTempEmail();
        templateEmail.fillInRealEmailField(realEmail);
        templateEmail.setNumberOfForwards();
        templateEmail.setLifeSpanField();
        templateEmail.submitEmailCreation();
    }

    @When("I register a new user")
    public void iRegisterANewUser() {
    }

    @And("I get confirmation on my email")
    public void iGetConfirmationOnMyEmail() {
    }

    @And("I confirm my registration")
    public void iConfirmMyRegistration() {
    }

    @Then("I should see greeting message")
    public void iShouldSeeGreetingMessage() {
    }
}
*/
