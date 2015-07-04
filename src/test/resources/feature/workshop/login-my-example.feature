@screen
Feature: Login

  Scenario: Login Successfully
    Given I navigate to the login page
    And fill in valid credentia
  ls
    When clicking the login button
    Then the user is logged in

  Scenario Outline: Failed login
    Given I navigate to the login page
    When I enter email "<email>" and password "<password>"
    When clicking the login button
    Then the login error message "<errorMessage>" is displayed
    Examples:
      | email       | password   | errorMessage                |
      | eu@fast.com |            | Please enter your password! |
      |             | apass.pass | Please enter your email!    |
      |             |            | Please enter your email!    |
      | eu@fast.com | wrong.pass | Invalid user or password!   |

#  Scenario: Login with non matching password
#    Given I navigate to the login page
#    When I enter email "eu@fast.com" and password "wrong.pass"
#    When clicking the login button
#    Then the login error message "Invalid user or password!" is displayed
#
#  Scenario: Login with no password
#    Given I navigate to the login page
#    When I enter email "eu@fast.com" and password ""
#    When clicking the login button
#    Then the login error message "Please enter your password!" is displayed
#
#  Scenario: Login with no email
#    Given I navigate to the login page
#    When I enter email "" and password "eu.pass"
#    When clicking the login button
#    Then the login error message "Please enter your email!" is displayed
#
#
#  Scenario: Login with invalid email
#    Given I navigate to the login page
#    When I enter email "eu" and password "eu.pass"
#    When clicking the login button
#    Then the login error message "Invalid email!" is displayed



