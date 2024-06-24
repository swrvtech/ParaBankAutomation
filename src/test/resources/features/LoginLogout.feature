@login
Feature: Login and Logout for Parabank

  @validLogin
  Scenario Outline: Valid login
    Given I am on the Login page
    When user enters "<Username>" and "<Password>"
    And user clicks on login button
    Then user is successfully logged in

    Examples:
      | Username | Password |
      | john     | demo     |

  @invalidLogin
  Scenario Outline: Error message validation during invalid login
    Given I am on the Login page
    When user enters "<Username>" and "<Password>"
    And user clicks on login button
    Then user sees "<ErrorMessage>"

    Examples:
      | Username        | Password        | ErrorMessage                                    |
      | invalidUsername | invalidPassword | The username and password could not be verified.|
      | invalidUsername |                 | The username and password could not be verified.|
      |                 | invalidPassword | The username and password could not be verified.|
      |                 |                 | Please enter a username and password.           |

  @logOut
  Scenario: Logout
    Given I am logged into my account
    When I click the logout button
    Then I should be redirected to the Login page
    And I should see a logout confirmation message
