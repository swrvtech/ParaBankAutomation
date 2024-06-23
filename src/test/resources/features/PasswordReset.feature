@passwordReset
Feature: Password Reset
  As a user, I want to reset my password so that I can regain access to my account if I forget my password.

  Background:
    Given I am on the Login page

  @initiatePasswordReset
  Scenario: Initiating a password reset
    When I click the "Forgot login info?" link
    And I enter my email address
    Then I should see a password reset email sent confirmation message

  @invalidPasswordReset
  Scenario: Handling invalid password reset attempts
    When I click the "Forgot login info?" link
    And I enter an invalid email address
    Then I should see an error message

  @verifyPasswordReset
  Scenario: Verifying password reset success message
    Given I have received a password reset email
    When I follow the password reset instructions
    Then I should see a password reset success message