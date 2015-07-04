@screen

Feature: As a logged in user I can change my password

  Scenario: Change password successfully
    Given I successfully login
    When I click on Preferences button
    And I input current password
    And I input new password
    And I retype password
    And I click on Save Change Password button
    Then I will see the message "Your password has been successfully changed."
    Then I can relogin with the new password