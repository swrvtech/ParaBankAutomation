@transactionHistory
Feature: Transaction History
  As a user, I want to view my transaction history so that I can track my account activity.

  Background:
    Given I am logged into my account

  @viewTransactionHistory
  Scenario: Viewing transaction history for an account
    When I navigate to the Transaction History page
    Then I should see the transaction history for my account

  @filterTransactionHistory
  Scenario: Filtering transaction history by date
    When I filter transactions by a specific date range
    Then I should see the transactions for that date range

  @invalidTransactionHistory
  Scenario: Handling invalid transaction history inquiries
    When I enter an invalid date range
    Then I should see an error message