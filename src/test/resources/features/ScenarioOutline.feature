Feature: Scenario Outline Example

	@outline
  Scenario Outline: 
    When I Login with "<username>" and "<password>"
    And Click on the Login button
    Then Validate that "<username>" is displayed
    And Print Bye "<fullName>" on screen

    Examples: 
      | username | password | fullName     |
      | ibrahim  | pw123    | Ibrahim Ali  |
      | tima     | tm123    | Tima D       |
      | ebru     | eb123    | Ebru Demirer |
