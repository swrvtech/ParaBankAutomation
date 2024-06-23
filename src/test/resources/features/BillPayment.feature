@billPayment
Feature: Bill Payment
  As a user, I want to pay my bills online so that I can manage my finances.

  Background:
    Given I am logged into my account
    And I am on the Bill Payment page

  @addBiller
  Scenario: Adding a new biller
    When I add a new biller with valid details
    Then I should see a biller added success message

  @payBill
  Scenario: Paying a bill
    When I enter valid bill payment details
    And I submit the payment
    Then I should see a bill payment success message

  @invalidBillPayment
  Scenario: Handling invalid bill payment attempts
    When I enter invalid bill payment details
    And I submit the payment
    Then I should see an error message