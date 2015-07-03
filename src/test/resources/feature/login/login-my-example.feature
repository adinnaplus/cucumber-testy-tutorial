Feature: Login

  Scenario: Login Successully
    Given I navigate to the login page
    And fill in valid credentials
    When clicking the login button
    Then the user is logged in

  Scenario: Login with invalid password
    Given I navigate to the login page
    And fill in invalid credentials
    When clicking the login button
    Then the invalid credetials error message is displayed