#@test
Feature: Login
  #login to the application

  Scenario: login and verify on landing page
    Given I am on the login page
    When I input the login details
    Then I am on the landing page