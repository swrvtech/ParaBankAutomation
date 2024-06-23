@fundTransfers
Feature: Fund Transfers
  As a user, I want to transfer funds between my accounts so that I can manage my money.

  Background:
    Given I am logged into my account
    And I am on the Transfer Funds page

  @validFundTransfer
  Scenario: Transferring funds between accounts
    When I enter valid transfer details
    And I submit the transfer form
    Then I should see a transfer success message

  @invalidFundTransfer
  Scenario: Handling invalid fund transfer attempts
    When I enter invalid transfer details
    And I submit the transfer form
    Then I should see an error message