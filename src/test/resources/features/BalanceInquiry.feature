@balanceInquiry
Feature: Balance Inquiry
  As a user, I want to view my account balance so that I can manage my finances.

  Background:
    Given I am logged into my account

  @viewBalance
  Scenario: Viewing the account balance for different account types
    When I navigate to the Account Balance page
    Then I should see the balance for all my account types

  @invalidBalanceInquiry
  Scenario: Handling invalid balance inquiries
    When I try to view the balance for a non-existent account
    Then I should see an error message