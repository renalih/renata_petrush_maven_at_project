Feature: As a user, I can add any hotel to favorites

  Background:
    Given I login to the Booking profile as registered user

  Scenario: I add the first and the last hotel from the list to favorites
    Given I open test site
    When I search hotel for specific dates
    And I add the first hotel to favorites
    And I add the last hotel to favorites
    Then I see that the heart icon becomes red
    And the marked hotels appear in "My next trip" list





