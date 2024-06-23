@updatePersonalInfo
Feature: Update Personal Information
  As a user, I want to update my personal information so that my account information is current.

  Background:
    Given I am logged into my account
    And I am on the Update Personal Information page

  @validUpdate
  Scenario: Updating user profile information
    When I enter new valid personal information
    Then I should see a personal information update success message

  @invalidUpdate
  Scenario: Handling invalid update attempts
    When I enter invalid personal information
    Then I should see an error message