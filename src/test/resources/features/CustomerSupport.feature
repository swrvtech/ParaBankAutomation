@customerSupport
Feature: Customer Support
  As a user, I want to contact customer support so that I can get help with my account.

  Background:
    Given I am logged into my account
    And I am on the Customer Support page

  @submitSupportRequest
  Scenario: Submitting a support request
    When I submit a support request with valid details
    Then I should see a support request submission success message

  @viewSupportRequests
  Scenario: Viewing submitted support requests
    When I navigate to the Customer Support page
    Then I should see a list of my submitted support requests

  @invalidSupportRequest
  Scenario: Handling invalid support request submissions
    When I submit a support request with invalid details
    Then I should see an error message