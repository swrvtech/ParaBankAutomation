@login
Feature: Login and Logout
  As a registered user, I want to log in and log out of my account so that I can secure my banking information.

  Background:
    Given I am on the Login page

  @validLogin
  Scenario: Logging in with valid credentials
    When I enter valid credentials
    And I click the login button
    Then I should be redirected to the Accounts Overview page

  @invalidLogin
  Scenario: Handling invalid login attempts
    When I enter invalid credentials
    And I click the login button
    Then I should see an error message

  @logout
  Scenario: Logging out and verifying the logout success
    Given I am logged into my account
    When I click the logout button
    Then I should be redirected to the Login page
    And I should see a logout confirmation message