@ACP
Feature: Account Creation

  Background:
    Given I am on the Registration page

  @validAccountCreation @ACP
  Scenario Outline: Creating a new account with valid details
    When I enter the following account details
      | firstName   | lastName | addressStreet | addressCity | addressState | addressZipCode | phoneNumber  | ssn        | username | password | repeatedPassword |
      | <firstName> | <lastName> | <addressStreet> | <addressCity> | <addressState> | <addressZipCode> | <phoneNumber> | <ssn> | <username> | <password> | <repeatedPassword> |
    And I submit the registration form
    Then I should see an account creation success message

    Examples:
      | firstName | lastName | addressStreet | addressCity | addressState | addressZipCode | phoneNumber  | ssn        | username | password | repeatedPassword |
      | John      | Doedoe      | 123 Main St   | Anytown     | VA           | 12345          | 123-456-7890 | 123-45-6789 | joohhnnddoe  | password | password |

  @invalidAccountCreation @ACP
  Scenario Outline: Handling invalid account creation attempts
    When I enter the following account details
      | firstName   | lastName   | addressStreet   | addressCity   | addressState   | addressZipCode   | phoneNumber   | ssn   | username   | password   | repeatedPassword   |
      | <firstName> | <lastName> | <addressStreet> | <addressCity> | <addressState> | <addressZipCode> | <phoneNumber> | <ssn> | <username> | <password> | <repeatedPassword> |
    And I submit the registration form
    Then I should see an error message

    Examples:
      | firstName | lastName | addressStreet | addressCity | addressState | addressZipCode | phoneNumber  | ssn        | username | password | repeatedPassword |
      | John          | Doe      | 123 Main St   | Anytown     | VA           | 12345          | 123-456-7890 | 123-45-6789 | johndoe  | passsword | password |
