Feature: Sign up a new profile on Booking

  Background:
    Given I create a template email address using real email "renapeta@protonmail.com"


  Scenario: I can sign up a new profile
    Given I open test site
    When I register a new user
    And I get confirmation on my email
    And I confirm my registration
    Then I should see greeting message
