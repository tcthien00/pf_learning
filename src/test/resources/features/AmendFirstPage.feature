@test
Feature: Amend the first page the logged in user sees
  #login to the application and change the users first page

  Scenario: change landing page to Learn, re-login and confirm the change
    Given I open the settings page
    And amend the user preference first screen to Learn
    When I re-login
    Then I am on the Learn page