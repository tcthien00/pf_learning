# PeopleFluent Interview Activity

## Repository Purpose
This repository is the starting point for the test activity that forms part of the Senior QA Engineer recruitment process

It contains the test framework as well as instructions on 
* How to install
* How to execute the current tests
* Additional test scenario to be automated 

## Prerequisites
The following should be installed before attempting this exercise

* Intellij Community edition (plugins:  cucumber for Java)
* Java version 1.8 (min)
* Cucumber 
* Selenium Webdriver
* Apache Maven


## Additional Scenario to automate
```
 Scenario: change landing page to "Learn", re-login and confirm the change
    Given I am on the landing page
    And I open the settings page
    And amend the user preference first screen to "Learn"
    When I re-login
    Then I am on the "Learn" page
 ```

Run the existing test
* Open the project
* Expand the Maven Projects tab (RH Side of the window)
* Expand the Lifecycle folder
* Double click the test section.. the tests should commence
* The output should look like this:

```
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running runners.MyRunner
@run
Feature: Login
Starting ChromeDriver 2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5) on port 42246
Only local connections are allowed.
Nov 13, 2018 2:52:54 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: OSS

  #login
  Scenario: login and verify on landing page # Login.feature:5
    Given I am on the login page             # Login.I_am_on_the_login_page()
    When I input the login details           # Login.I_input_the_login_details()
    Then I am on the landing page            # Login.I_am_on_the_landing_page()


  #amend first page
  Scenario: login and verify on landing page # Login.feature:5
    Given I am on the landing page           # AmendFirstPage.I_am_on_the_landing_page()
    When I input the login details           # AmendFirstPage.I_re_login()
    Then I am on the landing page            # AmendFirstPage.I_am_on_the_learn_page()

2 Scenarios (2 passed)
6 Steps (6 passed)
0m15.432s
```

