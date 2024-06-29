@updatePersonalInfo
Feature: Update Personal Information

  Background:
    Given I am logged into my account

  @updatePersonalInfo @UIP
  Scenario Outline: Updating personal information with valid details
    When I navigate to the Update Personal Information page
    And I update the following personal information
      | firstName | lastName | addressStreet | addressCity | addressState | addressZipCode | phoneNumber |
      | <firstName> | <lastName>    | <addressStreet>   | <addressCity>    | <addressState>      | <addressZipCode>       | <phoneNumber>|
    And I submit the update form
    Then I should see a personal information update success message
    Examples:
      | firstName | lastName | addressStreet | addressCity | addressState | addressZipCode | phoneNumber  | ssn        | username | password | repeatedPassword |
      | John      | DoeBo    | 123 Main St   | Anytown     | VA           | 12345          | 123-456-7890 | 123-45-6789 | joohhnnddoe  | password | password |

  @invalidUpdatePersonalInfo @UIP
  Scenario: Updating personal information with invalid details
    When I navigate to the Update Personal Information page
    And I update the following personal information
      | firstName | lastName | addressStreet | addressCity | addressState | addressZipCode | phoneNumber |
      |           |          |               |             |              |                |             |
    And I submit the update form
    Then I should see an invalid error message
