@searchEmployee
Feature: Search Employee

  Scenario: Search for Employee by ID
    Given user is logged in with valid credentials
    And user navigates to the employee list page
    When user enters valid employee id
    And clicks on search button
    Then employee information is displayed

  Scenario: Search Employee by Name
    Given user is logged in with valid credentials
    And user navigates to the employee list page
    When user enters valid employee name
    And clicks on search button
    Then employee information is displayed
