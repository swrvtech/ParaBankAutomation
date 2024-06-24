@accountOverview
Feature: Account Overview
  As a user, I want to view an overview of my account so that I can see all my account details in one place.

  Background:
    Given I am logged into my account

  @viewAccountOverview @AOP
  Scenario: Viewing account overview
    When I navigate to the Account Overview page
    Then I should see all my account details

  @verifyAccountInfo @AOP
  Scenario: Verifying the accuracy of displayed account information
    When I navigate to the Account Overview page
    Then I should see accurate account information