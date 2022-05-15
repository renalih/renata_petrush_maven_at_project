Feature: As a user, I can login to the registered profile

  Background:
    Given User has been registered to the app before

    Scenario: I login to the profile
      Given I open test site
      When I enter valid credentials
      And I click on submit button
      Then I should see all existed elements on page

