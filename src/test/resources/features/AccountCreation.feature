@account
Feature: Account Creation
  As a new user, I want to create an account so that I can access banking services.

  Background:
    Given I am on the Registration page

  @validAccountCreation @ACP
  Scenario: Creating a new account with valid details
    When I enter valid account details
    And I submit the registration form
    Then I should see an account creation success message

  @invalidAccountCreation @ACP
  Scenario: Handling invalid account creation attempts
    When I enter invalid account details
    And I submit the registration form
    Then I should see an error message

  @verifyAccountCreation @ACP
  Scenario: Verifying account creation success message
    Given I have successfully created an account
    Then I should see the correct success message