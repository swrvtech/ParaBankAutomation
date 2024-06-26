Feature: Account Creation

  Background:
    Given I am on the Registration page

  @validAccountCreation @ACP
  Scenario Outline: Creating a new account with valid details
    When I enter the following account details
      | firstName | lastName | addressStreet | addressCity | addressState | addressZipCode | phoneNumber  | ssn        | username | password | repeatedPassword |
      | <firstName> | <lastName> | <addressStreet> | <addressCity> | <addressState> | <addressZipCode> | <phoneNumber> | <ssn> | <username> | <password> | <repeatedPassword> |
    And I submit the registration form
    Then I should see an account creation success message

    Examples:
      | firstName | lastName | addressStreet | addressCity | addressState | addressZipCode | phoneNumber  | ssn        | username | password | repeatedPassword |
      | John      | Doe      | 123 Main St   | Anytown     | VA           | 12345          | 123-456-7890 | 123-45-6789 | johndoe  | password | password |
      | Jane      | Smith    | 456 Oak St    | Othertown   | CA           | 67890          | 987-654-3210 | 987-65-4321 | janesmith| secret123| secret123 |
      | Alice     | Johnson  | 789 Pine St   | Smalltown   | TX           | 54321          | 654-321-0987 | 654-32-1098 | alicejohn| pass123  | pass123  |
      | Bob       | Brown    | 101 Maple Ave | Bigcity     | NY           | 67890          | 321-098-7654 | 321-09-8765 | bobbrown | mypass123| mypass123|

  @invalidAccountCreation @ACP
  Scenario Outline: Handling invalid account creation attempts
    When I enter the following account details
      | firstName | lastName | addressStreet | addressCity | addressState | addressZipCode | phoneNumber  | ssn        | username | password | repeatedPassword |
      | <firstName> | <lastName> | <addressStreet> | <addressCity> | <addressState> | <addressZipCode> | <phoneNumber> | <ssn> | <username> | <password> | <repeatedPassword> |
    And I submit the registration form
    Then I should see an error message

    Examples:
      | firstName | lastName | addressStreet | addressCity | addressState | addressZipCode | phoneNumber  | ssn        | username | password | repeatedPassword |
      |           | Doe      | 123 Main St   | Anytown     | VA           | 12345          | 123-456-7890 | 123-45-6789 | johndoe  | password | password |
      | John      |          | 456 Oak St    | Othertown   | CA           | 67890          | 987-654-3210 | 987-65-4321 | janesmith| secret123| secret123 |
      | Alice     | Johnson  |               | Smalltown   | TX           | 54321          | 654-321-0987 | 654-32-1098 | alicejohn| pass123  | pass123  |
      | Bob       | Brown    | 101 Maple Ave |             | NY           | 67890          | 321-098-7654 | 321-09-8765 | bobbrown | mypass123| mypass123|
      | John      | Doe      | 123 Main St   | Anytown     | VA           | 12345          | 123-456-7890 |            | johndoe  | password | password |
      | Jane      | Smith    | 456 Oak St    | Othertown   | CA           | 67890          | 987-654-3210 | 987-65-4321 | janesmith| secret123|            |
