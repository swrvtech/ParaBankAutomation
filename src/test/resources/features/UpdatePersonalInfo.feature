@updatePersonalInfo
Feature: Update Personal Information

  Background:
    Given I am logged into my account

  @updatePersonalInfo @UIP
  Scenario: Updating personal information with valid details
    When I navigate to the Update Personal Information page
    And I update the following personal information
      | firstName | lastName | addressStreet | addressCity | addressState | addressZipCode | phoneNumber |
      | John      | Doe      | 123 New St    | Newtown     | NY           | 54321          | 987-654-3210|
    And I submit the update form
    Then I should see a personal information update success message

  @invalidUpdatePersonalInfo @UIP
  Scenario: Updating personal information with invalid details
    When I navigate to the Update Personal Information page
    And I update the following personal information
      | firstName | lastName | addressStreet | addressCity | addressState | addressZipCode | phoneNumber |
      |           |          |               |             |              |                |             |
    And I submit the update form
    Then I should see an invalid error message
