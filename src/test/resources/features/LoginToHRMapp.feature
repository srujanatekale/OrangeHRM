@Login
Feature: Login Functionality

  Scenario: Valid login to HRM
    # Given I navigated to HRM website
    When I enter a valid username
    And I enter a valid password
    And I click on the submit button
    Then I validate that I am logged in

  # And I quit the browser
  @smoke @regression
  Scenario: Invalid login
    # Given I navigated to HRM website
    When I enter a valid username
    And I enter an invalid password
    And I click on the submit button
    Then I validate that Invalid Credentials is displayed

  # And I quit the browser
  @HW3_1
  Scenario Outline: Login using Scenario Outline and Examples
    When I enter the valid "<username>" and "<password>"
    And I click on the submit button
    Then I verify that "<employeeName>" is shown

    Examples: 
      | username | password      | employeeName          |
      | lanalang | beautifulLife | Lana Lang             |
      | test1    | test123456    | testName testLastname |
      
    @HW3_2
    Scenario: Login using Datatable
    When user enters a username and a password and clicks on submit button
			| username | password      | employeeName          |
      | lanalang | beautifulLife | Lana Lang             |
      | test1    | test123456    | testName testLastname |