Feature: Scenario with DataTable

@dataTable
  Scenario: Add employees with DataTable
    When I login to the HRM website
    And I want to add Employees
      | FirstName | MiddleName | LastName   |
      | Umut      | M          | Degismen   |
      | Iana      | M          | L          |
      | Iana      |            | Gandrabura |
    Then I validate employee is added
